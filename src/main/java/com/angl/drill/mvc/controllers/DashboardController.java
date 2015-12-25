package com.angl.drill.mvc.controllers;

import com.angl.drill.services.ExcavationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/dashboard")
public class DashboardController {

/*    @Autowired
    private ExcavationService excavationService;*/


    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String getDashboard(){
        //ModelAndView modelAndView = new ModelAndView("dashboard");
        //modelAndView.addObject("excavation", excavationService.getAll());

        //return modelAndView;
        return "/dashboard/dashboard";
    }

    @RequestMapping(value = "/d", method = RequestMethod.GET)
    public String getd(){
        //ModelAndView modelAndView = new ModelAndView("dashboard");
        //modelAndView.addObject("excavation", excavationService.getAll());

        //return modelAndView;
        return "/dashboard/d";
    }
}
