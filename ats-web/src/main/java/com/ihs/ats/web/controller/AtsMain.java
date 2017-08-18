package com.ihs.ats.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index")
public class AtsMain {

	
    @RequestMapping(method = RequestMethod.GET )
    public String printHello(ModelMap model) {
 	   
 	   
       model.addAttribute("message", "Hello Spring MVC Framework!");
 
       return "index";
    }
}