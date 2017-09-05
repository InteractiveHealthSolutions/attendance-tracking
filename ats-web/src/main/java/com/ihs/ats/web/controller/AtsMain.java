package com.ihs.ats.web.controller;


import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/index.htm")
public class AtsMain {

	
    @RequestMapping(method = RequestMethod.GET )
    public String printHello(ModelMap model) {
 	   Logger.getLogger(this.getClass().getName()).info("in controller SSSSSSSSSSSSSSSSSSSSSSs");
 	 
       model.addAttribute("message", "Hello Spring MVC Framework!");
 
       return "index";
    }
}
