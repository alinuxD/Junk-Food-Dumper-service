package com.techpathy.JunkFoodDumperservice.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.techpathy.JunkFoodDumperservice.entity.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class HelloWorldController {
    private static final String template = "Heool, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello-world")
    public Greeting sayHello(@RequestParam(name = "name",required = false,
    defaultValue = "Stranger") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
