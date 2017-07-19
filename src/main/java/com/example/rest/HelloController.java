package com.example.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

import static java.util.Map.*;

/**
 * Created by venkateswara on 7/16/17.
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> helloWorld() {
        Map<String, Object> response = of("Hello", "World");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
