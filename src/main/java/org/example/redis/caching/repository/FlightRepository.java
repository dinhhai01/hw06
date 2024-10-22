package org.example.redis.caching.repository;


import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.*;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class FlightRepository {
    private JedisCluster jedisCluster;

    private JedisPool jedisPool;


    public FlightRepository() {

    }

    public void setKey(String key){
        getRedisConnection().set(key, String.valueOf(1));
        getRedisConnection().expire(key, 10);
    }

    public boolean isExistingKey(String key){
        Object value = getRedisConnection().get(key);
        if (value == null){
            setKey(key);
            return false;
        }
        return true;
    }

    public void unlink(String key){
        getRedisConnection().unlink(key);
    }

    public Jedis getRedisConnection() {
        if (jedisPool == null) {
            JedisPoolConfig poolConfig = new JedisPoolConfig();
            poolConfig.setMaxIdle(10);
            poolConfig.setMaxTotal(50);
            poolConfig.setMinIdle(2);

            jedisPool = new JedisPool(poolConfig, "localhost", 6379, 2000);
        }

        return jedisPool.getResource();
    }
}
