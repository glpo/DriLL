package com.angl.drill.mvc.controllers;

import com.angl.drill.algorithm.identification.MathModelParamsIdentification;
import com.angl.drill.db.entity.DrillHole;
import com.angl.drill.db.entity.Excavation;
import com.angl.drill.db.entity.ExcavationSession;
import com.angl.drill.db.entity.Experiment;
import com.angl.drill.services.ExcavationService;
import com.angl.drill.services.ExperimentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@org.springframework.stereotype.Controller
@RequestMapping(value = "/experiment")
@SessionAttributes(names = "currentHole, excavationSession")
public class ExperimentsController {

    @Autowired
    ExperimentService experimentService;

    @Autowired
    ExcavationService excavationService;

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String getExperimentsHistory(ModelMap model, HttpSession session) {
        DrillHole selectedDrillHole = (DrillHole) session.getAttribute("currentHole");
        if(selectedDrillHole != null) {
            List<Experiment> experiments = experimentService.getAll();

            model.put("experiments", experiments);
        } else {
            model.put("message", "Please, select a Drill-Hole");
        }

        return "/experiment/experiments";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String getNewExperimentPage(ModelMap model, HttpSession session, RedirectAttributes redirectAttributes) {
        DrillHole selectedDrillHole = (DrillHole) session.getAttribute("currentHole");
        if(selectedDrillHole != null) {
            ExcavationSession excavationSession = new ExcavationSession();
            excavationSession.setDrillHoleId(selectedDrillHole.getId());
            excavationSession.setIsExperiment(true);

            excavationService.add(excavationSession);

            session.setAttribute("excavationSession", excavationSession);

            return "/experiment/new_experiment";
        }
        redirectAttributes.addFlashAttribute("message", "Please, select a Drill-Hole.");

        return "redirect:/experiment/history";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)  //@RequestParams can be replaced with @ModelAttribute
    public String createNewExperiment(@RequestParam(name = "name")              String experimentName,
                                      @RequestParam(name = "breakBy")           String breakBy,
                                      @RequestParam(name = "bitLoad")           int bitLoad,
                                      @RequestParam(name = "bitDeltaLoad")      int bitDeltaLoad,
                                      @RequestParam(name = "breakParamValue")   int breakParamValue,
                                      ModelMap modelMap, HttpSession session) {

        ExcavationSession excavationSession = (ExcavationSession) session.getAttribute("excavationSession");

        Experiment experiment = new Experiment();
        experiment.setName(experimentName);
        experiment.setBreakBy(breakBy);
        experiment.setBitLoad(bitLoad);
        experiment.setBitDeltaLoad(bitDeltaLoad);
        experiment.setBreakParamValue(breakParamValue);

        experimentService.add(experiment);

        excavationSession.setExperimentId(experiment.getId());

        excavationService.update(excavationSession);

        modelMap.put("experiment", experiment);
        session.setAttribute("currentExperiment", experiment);

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

    @RequestMapping(value = "/getExperimentResults", method = RequestMethod.GET)
    @ResponseBody
    public List<String> fetchLoadData(HttpSession session){
        DrillHole drillHole = (DrillHole) session.getAttribute("currentHole");
        Experiment experiment = (Experiment) session.getAttribute("currentExperiment");
        ExcavationSession excavationSession1 = (ExcavationSession) session.getAttribute("excavationSession");
        ExcavationSession excavationSession2 = (ExcavationSession) session.getAttribute("excavationSession2");
        ExcavationSession excavationSession3 = (ExcavationSession) session.getAttribute("excavationSession3");

        System.out.println("excavationSession1= " + excavationSession1);
        System.out.println("excavationSession2= " + excavationSession2);
        System.out.println("excavationSession3= " + excavationSession3);

        List<ExcavationSession> experimentSessions = new ArrayList<ExcavationSession>();
        experimentSessions.add(excavationSession1);
        experimentSessions.add(excavationSession2);
        experimentSessions.add(excavationSession3);

        List<String> result = new ArrayList<String>();

        List<ExcavationSession> resultSessions = MathModelParamsIdentification.findMathModelParams(experimentSessions, experiment, drillHole);

        System.out.println("getOptimumBitLoad= " + experiment.getOptimumBitLoad());
        System.out.println("getPredictableDrillCost= " + experiment.getPredictableDrillCost());

        result.add(String.valueOf(experiment.getOptimumBitLoad()));
        result.add(String.valueOf(experiment.getPredictableDrillCost()));

        return result;
    }

}
