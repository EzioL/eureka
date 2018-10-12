package com.ezio.ribbonconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableAutoConfiguration
public class RibbonConsumerApplication {

    @Bean
    @LoadBalanced ///客户端负载均衡
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(RibbonConsumerApplication.class, args);
    }

    @GetMapping(value = "/")
    public String index() {
        return "HelloRibbonConsumer";
    }

    @GetMapping(value = "/hello")
    public String hello() {

        //restTemplate.getForEntity("")
        //return "HelloRibbonConsumer";

        String url = "http://eureka-client-user/hello";
        String body = restTemplate.getForEntity(url, String.class).getBody();
        return body;
    }

    @GetMapping(value = "/ribbon-consumer")
    public String helloRibbonConsumer() {

        //restTemplate.getForEntity("")
        //return "HelloRibbonConsumer";

        String url = "http://EUREKA-CLIENT-USE";
        String body = restTemplate.getForEntity(url, String.class).getBody();
        return body;
    }

    @GetMapping(value = "/http")
    public ResponseEntity testHttp() {

        String url = "https://api.qingmang.me/v2/article.list?token=c400a7e21688496ca3e7f17c6b0d1846&category_id=p2693E";
        String body = restTemplate.getForEntity(url, String.class).getBody();
        return ResponseEntity.ok(body);
    }
}
