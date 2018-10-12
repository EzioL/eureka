package com.ezio.eurekaclientorder.order.controller;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Here be dragons
 * Created by haotian on 2018/9/21 下午3:26
 */
@RestController
public class OrderController {

    @GetMapping(value = "/")
    public String index() {
        return "Hello EUREKA-CLIENT-ORDER";
    }

    @GetMapping(value = "/user/orders")
    public String getUserOrders(@RequestParam int userId) {
        List<String> orders = Lists.newArrayList();
        for (int i = 0; i < 6; i++) {
            orders.add("userId-->" + userId + "  orderId-->" + i);
        }
        return new Gson().toJson(orders);
    }
}
