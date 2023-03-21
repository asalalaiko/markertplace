package by.asalalaiko.apiadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {



    @GetMapping("/admin")
    public String Home (Model model){
        model.addAttribute("title", "Main page");
        return "index.html";

    }
}