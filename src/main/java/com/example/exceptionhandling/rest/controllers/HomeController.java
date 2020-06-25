package com.example.exceptionhandling.rest.controllers;

import com.example.exceptionhandling.rest.dto.request.PersonRequestDto;
import com.example.exceptionhandling.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/")
    public String hello() {
        return "Hello World..";
    }

    @GetMapping("/{num}")
    public String demo(@PathVariable("num") int num) {
        return homeService.demo(num);
    }

    @PostMapping("/person")
    public String savePerson(@Validated @RequestBody PersonRequestDto requestDto) {
        return "Person saved.";
    }
}
