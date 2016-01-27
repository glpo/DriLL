package com.angl.drill.mvc.controllers;

import com.angl.drill.db.entity.DrillHole;
import com.angl.drill.db.entity.Experiment;
import com.angl.drill.services.ExcavationService;
import com.angl.drill.services.ExperimentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/experiment")
public class ExperimentsController {

    @Autowired
    ExperimentService experimentService;

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String getExperimentsHistory(ModelMap model) {
        List<Experiment> experiments = experimentService.getAll();

        model.put("experiments", experiments);

        return "/experiment/experiments";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String getNewExperimentPage(ModelMap model) {
        return "/experiment/new_experiment";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)  //@RequestParams can be replaced with @ModelAttribute
    public String createNewExperiment(@RequestParam(name = "name")              String experimentName,
                                      @RequestParam(name = "breakBy")           String breakBy,
                                      @RequestParam(name = "bitLoad")           int bitLoad,
                                      @RequestParam(name = "bitDeltaLoad")      int bitDeltaLoad,
                                      @RequestParam(name = "costPerHour")       int costPerHour,
                                      @RequestParam(name = "bitCost")           int bitCost,
                                      @RequestParam(name = "descAscTime")       int descAscTime,
                                      @RequestParam(name = "breakParamValue")   int breakParamValue,
                                      ModelMap modelMap) {

        Experiment experiment = new Experiment();
        experiment.setName(experimentName);
        experiment.setBreakBy(breakBy);
        experiment.setBitLoad(bitLoad);
        experiment.setBitDeltaLoad(bitDeltaLoad);
        experiment.setCostPerHour(costPerHour);
        experiment.setBitCost(bitCost);
        experiment.setDescAscTime(descAscTime);
        experiment.setBreakParamValue(breakParamValue);

        experimentService.add(experiment);

        modelMap.put("experiment", experiment);

        return "/experiment/make_experiment";
    }

    @RequestMapping(value = "/edit/id/{id}", method = RequestMethod.GET)
    public String getExperimentForEdit(@PathVariable("id") ObjectId id, ModelMap model){
        Experiment experiment = experimentService.get(id);

        model.put("experiment", experiment);

        return "experiment/edit_experiment";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveExperimentAfterEdit(@ModelAttribute("experiment") Experiment updExperiment, RedirectAttributes redirectAttributes){
        experimentService.update(updExperiment);
        redirectAttributes.addFlashAttribute("message", "Experiment " + updExperiment.getName() + " Updated Successfully");

        return "redirect:/experiment/history";
    }

    @RequestMapping(value = "/delete/id/{id}", method = RequestMethod.GET)
    public String deleteSelectedExperiment(@PathVariable("id") ObjectId id, RedirectAttributes redirectAttributes){
        Experiment experiment = experimentService.get(id);
        experimentService.remove(id);

        redirectAttributes.addFlashAttribute("message", "Experiment " + experiment.getName() + " Deleted Successfully");

        return "redirect:/experiment/history";
    }

}
