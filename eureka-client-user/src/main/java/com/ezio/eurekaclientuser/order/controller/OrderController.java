package com.ezio.eurekaclientuser.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Here be dragons
 * Created by haotian on 2018/9/21 下午1:37
 */
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/")
    public String index() {
        return "Hello EUREKA-CLIENT-USER";
    }



    @GetMapping(value = "/user/orders")
    public String getUserOrders(@RequestParam int userId) {
        String url = "http://EUREKA-CLIENT-ORDER/user/orders?userId" + userId;
        String body = restTemplate.getForEntity(url, String.class).getBody();
        return body;
    }
}
