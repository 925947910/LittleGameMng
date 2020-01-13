package com.cointer.redis.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.cointer.redis.IJedisClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Redis实现
 */
@Configuration
public class JedisClient implements IJedisClient {

    private final JedisPool jedisPool;

    @Autowired
    public JedisClient(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }
    @Override
    public int  getNumActive() {
    	return  this.jedisPool.getNumActive();
    }
    @Override
    public int getNumWaiters() {
    	return  this.jedisPool.getNumWaiters();
    }
    @Override
    public int getNumIdle() {
    	return  this.jedisPool.getNumIdle();
    }
    @Override
    public Jedis getJedis() {
    	return  this.jedisPool.getResource();
    }
    @Override
    public void returnJedis(Jedis jedis) {
    	jedis.close();
    } 
    @Override
    public String set(int db,String key, String value) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(db);
        String result = jedis.set(key, value);
        jedis.close();
        return result;
    }

    @Override
    public String get(int db,String key) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(db);
        String result = jedis.get(key);
        jedis.close();
        return result;
    }

    @Override
    public Boolean exists(int db,String key) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(db);
        Boolean result = jedis.exists(key);
        jedis.close();
        return result;
    }

    @Override
    public Long expire(int db,String key, int seconds) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(db);
        Long result = jedis.expire(key, seconds);
        jedis.close();
        return result;
    }

    @Override
    public Long ttl(int db,String key) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(db);
        Long result = jedis.ttl(key);
        jedis.close();
        return result;
    }

    @Override
    public Long incr(int db,String key) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(db);
        Long result = jedis.incr(key);
        jedis.close();
        return result;
    }

    @Override
    public Long hset(int db,String key, String field, String value) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(db);
        Long result = jedis.hset(key, field, value);
        jedis.close();
        return result;
    }
    public String hmset(int db,String key,Map<String,String> map) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(db);
        String result = jedis.hmset(key, map);
        jedis.close();
        return result;
    }
    @Override
    public String hget(int db,String key, String field) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(db);
        String result = jedis.hget(key, field);
        jedis.close();
        return result;
    }
    @Override
    public List<String> hmget(int db,String key, String... fields) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(db);
        List<String> result = jedis.hmget(key, fields);
        jedis.close();
        return result;
    }
    @Override
    public Long hdel(int db,String key, String... field) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(db);
        Long result = jedis.hdel(key, field);
        jedis.close();
        return result;
    }

    @Override
    public Boolean hexists(int db,String key, String field) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(db);
        Boolean result = jedis.hexists(key, field);
        jedis.close();
        return result;
    }

    @Override
    public List<String> hvals(int db,String key) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(db);
        List<String> result = jedis.hvals(key);
        jedis.close();
        return result;
    }

    @Override
    public Long del(int db,String key) {
        Jedis jedis = jedisPool.getResource();
        jedis.select(db);
        Long result = jedis.del(key);
        jedis.close();
        return result;
    }

	@Override
	public Double zscore(int db, String key,String member) {
		  Jedis jedis = jedisPool.getResource();
	        jedis.select(db);
	        Double result = jedis.zscore(key, member);
	        jedis.close();
	        return result;
	}
	@Override
	public long zadd(int db, String key,double score,String member) {
		  Jedis jedis = jedisPool.getResource();
	        jedis.select(db);
	        long result  =jedis.zadd(key, score, member);
	        jedis.close();
	        return result;
	}
	@Override
	public List<String> lrange(int db,String key, int start, int stop) {
		  Jedis jedis = jedisPool.getResource();
	        jedis.select(db);
	        List<String> result  =jedis.lrange(key, start, stop);
	        jedis.close();
	        return result;
	}
	@Override
	public Long rpush(int db,String key, String... strings) {
		  Jedis jedis = jedisPool.getResource();
	        jedis.select(db);
	        Long result  =jedis.rpush(key, strings);
	        jedis.close();
	        return result;
	}
	@Override
	public Map<String, String> hgetAll(int db, String key) {
		 Jedis jedis = jedisPool.getResource();
	        jedis.select(db);
	        Map<String,String> result  =jedis.hgetAll(key);
	        jedis.close();
	        return result;
	}
	@Override
	public Set<String> keys(int db, String key) {
		 Jedis jedis = jedisPool.getResource();
	        jedis.select(db);
	        Set<String> result  =jedis.keys(key);
	        jedis.close();
	        return result;
	}
	@Override
	public Set<String> zrevrange(int db, String key, long start,  long stop) {
		 Jedis jedis = jedisPool.getResource();
	        jedis.select(db);
	        Set<String> result=jedis.zrevrange(key,start, stop);
	        jedis.close();
	        return result;
	}
	@Override
	public Long zrevrank(int db, String key,String member) {
		 Jedis jedis = jedisPool.getResource();
	        jedis.select(db);
	        Long result=jedis.zrevrank(key, member);
	        jedis.close();
	        return result;
	}
	@Override
	public Double zincrby(int db, String key,Double increment,String member) {
		Jedis jedis = jedisPool.getResource();
		jedis.select(db);
		Double result= jedis.zincrby(key, increment, member);
		jedis.close();
		return result;
	}
}