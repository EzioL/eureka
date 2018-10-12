package com.ezio.ribbonconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class RibbonConsumerApplication {

    @Bean
    @LoadBalanced
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

    @GetMapping(value = "/ribbon-consumer")
    public String helloRibbonConsumer() {

        //restTemplate.getForEntity("")
        //return "HelloRibbonConsumer";


        String url = "http://EUREKA-CLIENT-USE";
        String body = restTemplate.getForEntity(url, String.class).getBody();
        return body;
    }
}
