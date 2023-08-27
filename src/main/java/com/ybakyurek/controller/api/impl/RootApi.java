package com.ybakyurek.controller.api.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/root")


//root'a yani index'e yonlendirmek icin bunu yazmamiz gerekiyor
public class RootApi {
    @GetMapping({"/","/index"})

    public ResponseEntity<String> getRoot(){
        return ResponseEntity.ok("index");
    }
}
