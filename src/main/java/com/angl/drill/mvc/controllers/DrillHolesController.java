package com.angl.drill.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/drillholes")
public class DrillHolesController {

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getDrillHoles(ModelMap map) {

        return "/drillholes/drillholes";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createNewDrillHole(ModelMap map, RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("message", "New Drill-Hole Successfully Created");
        return "redirect:/drillholes/drillholes";
    }
}
