package com.cointer.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;

public interface IJedisClient {
	int getNumWaiters();

	int getNumActive();

	int getNumIdle();
	
    Jedis getJedis();
    
    void returnJedis(Jedis jedis);
    
    
    
    
    
    
    String set(int db,String key, String value);

    String get(int db,String key);

    Boolean exists(int db,String key);

    Long expire(int db,String key, int seconds);

    Long ttl(int db,String key);

    Long incr(int db,String key);

    Long hset(int db,String key, String field, String value);
    
    String hmset(int db,String key,Map<String,String> map);

    String hget(int db,String key, String field);
    
    List<String> hmget(int db, String key, String... fields);

    Map<String,String> hgetAll(int db, String key);
    
    Long hdel(int db,String key, String... field);

    Boolean hexists(int db,String key, String field);

    List<String> hvals(int db,String key);

    Long del(int db,String... key);
    
    Double zscore(int db,String key,String member);
    
    long zadd(int db, String key,double score,String member);

	List<String> lrange(int db, String key, int start, int stop);

	Set<String> keys(int db, String key);

	Long rpush(int db, String key, String... strings);
	
	Long lpush(int db, String key, String... strings);
	
	String ltrim(int db, String key, long start, long stop);
	
	Set<String> zrevrange(int db, String key, long start, long stop);

	Long zrevrank(int db, String key, String member);

	Double zincrby(int db, String key, Double increment, String member);

	long sadd(int db, String key, String... members);

	Set<String> smembers(int db, String key);

	Long hincrBy(int db, String key, String field, long value);

	Long llen(int db, String key);

	String lindex(int db, String key, long index);

	String lpop(int db, String key);

	long srem(int db, String key, String... members);

	

    

	
}