package com.angl.drill.mvc.controllers;

import com.angl.drill.db.entity.ExcavationSessionEntity;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/reports")
public class ReportsController {

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getReportsPage(ModelMap map) {

        return "/reports/reports";
    }

    @RequestMapping(value = "/excavation", method = RequestMethod.POST)
    public String generateExcavationReport(ModelMap map, RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("message", "Excavation Report Generated Successfully");
        return "redirect:/reports/all";
    }

    @RequestMapping(value = "/breed", method = RequestMethod.POST)
    public String generateBreedReport(ModelMap map, RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("message", "Breed Report Generated Successfully");
        return "redirect:/reports/all";
    }

    @RequestMapping(value = "/faults", method = RequestMethod.POST)
    public String generateFaultsReport(ModelMap map, RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("message", "Faults Report Generated Successfully");
        return "redirect:/reports/all";
    }

    @RequestMapping(value = "/download/id/{id}", method = RequestMethod.GET)
    public String uploadReport(@PathVariable("id") ObjectId id, ModelMap model){


        return "reports/download";
    }

    @RequestMapping(value = "/delete/id/{id}", method = RequestMethod.GET)
    public String deleteReport(@PathVariable("id") ObjectId id, RedirectAttributes redirectAttributes){


        redirectAttributes.addFlashAttribute("message", "Report " + id + " Deleted Successfully");
        return "redirect:/reports/all";
    }
}