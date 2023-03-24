package by.asalalaiko.apiuser.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/test")
    public String test(Authentication authentication){
        return "Test user API:" + "User - "+authentication.getName();
    }
}
