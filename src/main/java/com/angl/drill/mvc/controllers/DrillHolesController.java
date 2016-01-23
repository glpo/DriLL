package com.angl.drill.mvc.controllers;

import com.angl.drill.db.entity.DrillHole;
import com.angl.drill.services.DrillHoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/drillholes")
@SessionAttributes(names = "currentHole")
public class DrillHolesController {

    @Autowired
    DrillHoleService drillHoleService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getDrillHoles(ModelMap map) {
        List<DrillHole> drillHoles = drillHoleService.getAll();
        map.put("drillHoles", drillHoles);

        return "/drillholes/drillholes";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getDrillHoleCreatePage() {
        return "/drillholes/new_drillhole";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createNewDrillHole(ModelMap map, RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("message", "New Drill-Hole Successfully Created");
        return "redirect:/drillholes/drillholes";
    }
}
