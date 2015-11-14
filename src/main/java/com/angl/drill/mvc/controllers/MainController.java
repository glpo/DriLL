package com.angl.drill.mvc.controllers;

import com.angl.drill.db.entity.UserEntity;
import com.angl.drill.services.ExcavationService;
import com.angl.drill.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private ExcavationService excavationService;

    private UserEntity userEntity;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getStartPage(){
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String init(ModelMap map){
        userEntity = new UserEntity();
        map.put("user", userEntity);

        return "login";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView getDashboard(){
        ModelAndView modelAndView = new ModelAndView("dashboard");
        modelAndView.addObject("excavation", excavationService.getAll());

        return modelAndView;
    }
}
