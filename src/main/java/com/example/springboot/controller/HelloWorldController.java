package com.example.springboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloWorldController {

    // new a controller method to show the initial HTML form
    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // new a controller method to process the HTML form
    @GetMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @GetMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Yo! " + theName;

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

    @GetMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
        // read the request parameter from the HTML form


        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Hey My Friend from v3! " + theName;

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
