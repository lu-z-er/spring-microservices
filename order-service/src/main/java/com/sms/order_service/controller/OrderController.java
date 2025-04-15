package com.sms.order_service.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/info")
    public String getOrderInfo() {
        return "[Response from Order Service Running on Port: "+ serverPort + "]";
    }
}