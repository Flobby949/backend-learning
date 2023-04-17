package top.flobby.push.websocket;

import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : Flobby
 * @program : spring-boot-learning
 * @description : SpringBoot 服务端 WebSocket 服务接收类
 * @create : 2023-04-17 15:41
 **/

@Slf4j
@Component
@ServerEndpoint(value = "/socket/{id}")
public class WebSocketServer {

    /**
     * 与某个客户端连接的会话，存放和客户端连接对应的 WebSocket 对象
     */
    private Session session;
    /**
     * 编号
     */
    private Integer id;
    /**
     * ConcurrentHashMap 并发编程工具包下的线程安全的集合
     */
    public static ConcurrentHashMap<Integer, WebSocketServer> map = new ConcurrentHashMap<>();
    /**
     * 在线人数
     */
    private static int onlineCount = 0;

    /**
     * 连接建立成功
     */
    @OnOpen
    public void onOpen(@PathParam("id") Integer id, Session session) {
        log.info("WebSocket 连接成功");
        // 接收编号
        this.id = id;
        this.session = session;
        // 放入集合
        map.put(id, this);
        addOnlineCount();
        log.info("有新连接加入，当前在线人数为：{}", getOnlineCount());
        sendMsg("连接成功，当前连接已建立");
    }

    @OnClose()
    public void onClose() {
        log.info("有链接关闭");
        // 移除连接会话
        map.remove(id);
        subOnlineCount();
        log.info("有连接关闭，当前在线人数为：{}", getOnlineCount());
    }

    @OnError
    public void onError(Throwable e) {
        log.error(e.getMessage());
    }

    /**
     * 收到客户端发送消息后调用
     *
     * @param session 会话
     * @param msg     消息
     */
    @OnMessage
    public void onMessage(Session session, String msg) {
        log.info("接收到客户端发送的消息，{}", msg);
        broadcastMsg(msg);
    }

    /**
     * 群发
     *
     * @param msg 消息
     */
    private void sendMsg(String msg) {
        try {
            getSession().getBasicRemote().sendText(msg);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * 私聊
     *
     * @param msg 消息
     */
    private void sendMsg(Integer id, String msg) {
        WebSocketServer socketServer = map.get(id);
        if (socketServer != null) {
            socketServer.sendMsg(msg);
        } else {
            log.warn("客户端已下线");
        }
    }

    /**
     * 广播
     *
     * @param msg 消息
     */
    private void broadcastMsg(String msg) {
        map.values().forEach(server -> {
            server.sendMsg(msg);
        });
    }

    public Session getSession() {
        return session;
    }

    /**
     * 上线
     */
    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    /**
     * 下线
     */
    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

    /**
     * 获取在线人数
     *
     * @return int count
     */
    public static synchronized int getOnlineCount() {
        return WebSocketServer.onlineCount;
    }
}
