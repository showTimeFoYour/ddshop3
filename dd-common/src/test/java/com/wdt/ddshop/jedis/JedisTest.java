package com.wdt.ddshop.jedis;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

public class JedisTest {
  /*  @Test
    public void testJedis1() {
        Jedis jedis = new Jedis("119.23.223.202", 6379);
        jedis.set("name1", "javk");

        System.out.println(jedis.get("name1"));
        jedis.close();
    }

    @Test
    public void testJedis2() {
        JedisPool jedisPool = new JedisPool("119.23.223.202", 6379);
        Jedis jedis = jedisPool.getResource();
          jedis.set("name","哈哈哈");
        System.out.println(jedis.get("name"));
        jedis.close();
jedisPool.close();
    }

    @Test
    public void testJedis3() {
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("119.23.223.202", 9001));
        nodes.add(new HostAndPort("119.23.223.202", 9002));
        nodes.add(new HostAndPort("119.23.223.202", 9003));
        nodes.add(new HostAndPort("119.23.223.202", 9004));
        nodes.add(new HostAndPort("119.23.223.202", 9005));
        nodes.add(new HostAndPort("119.23.223.202", 9006));
        JedisCluster jedisCluster = new JedisCluster(nodes);
        jedisCluster.set("name1", "xdd");
        jedisCluster.set("name2", "习大大");
        System.out.println(jedisCluster.get("name2"));
        jedisCluster.close();
    }
*/
}
