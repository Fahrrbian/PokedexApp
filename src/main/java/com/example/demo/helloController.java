package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class helloController {
	 @GetMapping("/test")
	    public String home() {
	        return "home.html"; // name of the HTML file in resources/templates
	    }
}
