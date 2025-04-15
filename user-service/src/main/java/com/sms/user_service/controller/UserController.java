package com.sms.user_service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {

    private final RestTemplate restTemplate;

    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/orders")
    public String getOrders() {
        String response = restTemplate.getForObject("http://order-service/order/info", String.class);
        return "[ User Service Running on Port: "+ serverPort + " ]" + " Calling -> " + response;
    }
}