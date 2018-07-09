package redis;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");

        System.out.println("connect success");
        System.out.println("redis-server working:" + jedis.ping());

        jedis.set("first","hello world");
        System.out.println(jedis.get("first"));

        //存储数据到列表中
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }
    }
}
