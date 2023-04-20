package top.flobby.security.cache;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import top.flobby.common.cache.RedisCache;
import top.flobby.security.user.UserDetail;
import top.flobby.common.cache.RedisKeys;

 /**
 * @author : Flobby
 * @program : admin-template
 * @description : 登录用户的缓存操作
 * @create : 2023-04-20 19:16
 **/
@Component
@AllArgsConstructor
public class TokenStoreCache {

    private final RedisCache redisCache;

    public void saveUser(String accessToken, UserDetail user) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        redisCache.set(key, user);
    }

    public UserDetail getUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        return (UserDetail) redisCache.get(key);
    }

    public void deleteUser(String accessToken) {
        String key = RedisKeys.getAccessTokenKey(accessToken);
        redisCache.delete(key);
    }
}
