package com.qlktx.qlktx.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("")
public class checkHealthy {
    @GetMapping("")
    public String get() {
        return "server is running...";
    }

}
