package com.angl.drill.mvc.controllers;

import com.angl.drill.services.ExcavationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/experiment")
public class ExperimentsController {

    @Autowired
    ExcavationService excavationService;

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String getExperimentsHistory(ModelMap model) {
        //
        List<String> experiments = new ArrayList<String>();
        experiments.add("Experiment #1.1 20.12.15 15:44");
        experiments.add("Experiment #1.2 20.12.15 16:27");
        experiments.add("Experiment #1.3 20.12.15 16:51");
        experiments.add("Experiment #2.1 21.12.15 10:44");
        experiments.add("Experiment #2.2 21.12.15 13:44");
        experiments.add("Experiment #2.3 21.12.15 11:44");
        experiments.add("Experiment #3.1 22.12.15 12:44");

        model.put("experiments", experiments);

        return "/experiment/experiments";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newExperiment(ModelMap model) {

        return "/experiment/new_experiment";
    }
}
