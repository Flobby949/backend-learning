const app = Vue.createApp({
    data() {
        return {
            msg: '123',
            id: 0,
            content: '',
            ws: null
        }
    },
    methods: {
        open() {
            console.log("open")
            this.ws = new WebSocket(`ws://localhost:8080/socket/${this.id}`)
            this.ws.onopen = () => {
                console.log("webSocket 连接成功")
            }
            this.ws.onclose = () => {
                console.log("webSocket 连接关闭")
            }
            this.ws.onerror = (e) => {
                console.log("webSocket 连接异常，" + e)
            }
            this.ws.onmessage = (res) => {
                console.log(res)
                this.msg = this.msg.concat("" + res.data)
            }
        },
        sendMsg(msg) {
            console.log("send")
            this.ws.send(this.content)
            this.content = ""
        },
        logout() {
            this.ws.onclose = () => {
                console.log("webSocket 连接关闭")
            }
        }
    }
})