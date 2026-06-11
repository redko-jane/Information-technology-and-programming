package org.example.spring_lab3_notifications.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Привет, Spring Boot!";
    }

    @GetMapping("/user")
    public String userInfo(@RequestParam String name, @RequestParam int age) {
        return "Пользователь: " + name + ", возраст: " + age;
    }
}
