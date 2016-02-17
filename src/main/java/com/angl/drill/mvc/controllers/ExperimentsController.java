package com.angl.drill.mvc.controllers;

import com.angl.drill.db.entity.DrillHole;
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
import java.util.List;

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

        if(excavationSession != null) {
            Experiment experiment = new Experiment();
            experiment.setName(experimentName);
            experiment.setBreakBy(breakBy);
            experiment.setBitLoad(bitLoad);
            experiment.setBitDeltaLoad(bitDeltaLoad);
            experiment.setBreakParamValue(breakParamValue);
            experiment.setSessionId(excavationSession.getId());

            experimentService.add(experiment);

            modelMap.put("experiment", experiment);
        }

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
