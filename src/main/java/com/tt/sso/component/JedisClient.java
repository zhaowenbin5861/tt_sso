package com.tt.sso.component;
/**
 * 
 * 创建一个redis操作的接口。分别创建两个实现类对应redis 的单机版和集群版。
 * 当使用单机版redis时，配置单机版的实现类，当使用集群版本的时候，配置集群版的实现类
 * @author zwb
 *
 */
public interface JedisClient {

	public String set(String key,String value);
	public String get(String key);
	
	public Long hset(String key,String item,String value);
	public String hget(String key,String item);
	
	public Long incr(String key);
	public Long decr(String key);
	
	public Long expire(String key,int second);
	public Long ttl(String key);
	
	public Long hdel(String key,String item);
}
