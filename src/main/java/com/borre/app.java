package com.borre;

import static spark.Spark.get;
import static spark.Spark.port;

import java.net.InetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;

public class app {

    public static void main(String[] args) {

        Logger log = LoggerFactory.getLogger(app.class);
        port(8080);

        get("/", (request, response) -> {
            Long visits = null;
            try {
                Jedis jedis = new Jedis("redis");
                visits = jedis.incr("java_counter");
                jedis.close();
            } catch (Exception e) {
                log.error(e.toString());
            }
            String hostname = InetAddress.getLocalHost().getHostName();
            log.info("Hello from host: " + hostname + " from ip: " + request.ip() + " number of visits: " + visits);
            return "Hello from <br> host: <b>" + hostname + "</b> <br> from ip: <b>" + 
                request.ip() + "</b> <br> number of visits: <b>" + visits + "</b>";
        });

        get("/front",(request, response) -> {
            response.type("text/html"); 
            return "<h1>disco2000</h1>";
        });
    }
}