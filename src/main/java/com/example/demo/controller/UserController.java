package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Controller
public class UserController {
    @GetMapping("/user")
    public ModelAndView getHome(){
        ModelAndView modelAndView = new ModelAndView("user");
        return modelAndView;
    }

}
