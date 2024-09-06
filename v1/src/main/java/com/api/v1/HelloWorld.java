package com.api.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello-world")
class HelloWorld {

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    String thrownHelloWorld() {
        return "Hello World";
    }

}
