package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    //creata a mapping for "/hello"
    @GetMapping("/hello")
    public String sayHello(Model theModel) {//model la doi tuong duoc spring su dung de truyen du lieu giua controller va view
        theModel.addAttribute("theDate", java.time.LocalDateTime.now());//them thuoc tinh theDate vao model
        return "helloworld";
    }
}
