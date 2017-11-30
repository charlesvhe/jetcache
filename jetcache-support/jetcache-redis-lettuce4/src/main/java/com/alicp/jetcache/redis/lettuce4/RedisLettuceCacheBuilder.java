package com.alicp.jetcache.redis.lettuce4;

import com.alicp.jetcache.external.ExternalCacheBuilder;
import com.lambdaworks.redis.AbstractRedisClient;

/**
 * Created on 2017/4/28.
 *
 * @author <a href="mailto:areyouok@gmail.com">huangli</a>
 */
public class RedisLettuceCacheBuilder<T extends ExternalCacheBuilder<T>> extends ExternalCacheBuilder<T> {
    public static class RedisLettuceCacheBuilderImpl extends RedisLettuceCacheBuilder<RedisLettuceCacheBuilderImpl> {
    }

    public static RedisLettuceCacheBuilderImpl createRedisLettuceCacheBuilder() {
        return new RedisLettuceCacheBuilderImpl();
    }

    protected RedisLettuceCacheBuilder() {
        buildFunc(config -> new RedisLettuceCache((RedisLettuceCacheConfig) config));
    }

    @Override
    public RedisLettuceCacheConfig getConfig() {
        if (config == null) {
            config = new RedisLettuceCacheConfig();
        }
        return (RedisLettuceCacheConfig) config;
    }

    public T redisClient(AbstractRedisClient redisClient){
        getConfig().setRedisClient(redisClient);
        return self();
    }

    public void setRedisClient(AbstractRedisClient redisClient) {
        getConfig().setRedisClient(redisClient);
    }
}