package com.angl.drill.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ParamsController {

    @RequestMapping(value = "/params", method = RequestMethod.GET)
    public ModelAndView getParams () {

        return new ModelAndView("/params/params", "params", null);
    }
}
