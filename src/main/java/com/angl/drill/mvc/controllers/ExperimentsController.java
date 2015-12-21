package com.angl.drill.mvc.controllers;

import com.angl.drill.services.ExcavationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/experiment")
public class ExperimentsController {

    @Autowired
    ExcavationService excavationService;

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String getExperimentsHistory(ModelMap model) {
        //
        //model.put("experiments", null);

        return "/experiment/experiments";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newExperiment(ModelMap model) {

        return "/experiment/new_experiment";
    }
}
