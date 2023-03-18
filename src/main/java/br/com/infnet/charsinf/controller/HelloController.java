package br.com.infnet.charsinf.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
public class HelloController {
    @GetMapping
    public ResponseEntity hello(){
        return ResponseEntity.ok(Map.of("Message", "HELLO"));
    }
}
