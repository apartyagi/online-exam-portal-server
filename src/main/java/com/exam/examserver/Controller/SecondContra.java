package com.exam.examserver.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/sec")
public class SecondContra {

    @GetMapping("/home")
    public String home(){

        return "This is Home Page";
    }

    @GetMapping("/about")
    public String about(){

        return "This is About Page";
    }
    @GetMapping("/sett")
    public String setting(){

        return "This is Setting Page";
    }

}
