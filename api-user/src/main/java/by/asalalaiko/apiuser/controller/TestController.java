package by.asalalaiko.apiuser.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class TestController {


    @GetMapping("/test")
    public String test(){
        return "Test user API";
    }
}
