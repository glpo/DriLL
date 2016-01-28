package com.angl.drill.mvc.controllers;

import com.angl.drill.db.entity.DrillHole;
import com.angl.drill.db.entity.Experiment;
import com.angl.drill.services.DrillHoleService;
import org.apache.commons.lang.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/drillholes")
@SessionAttributes(names = "currentHole")
public class DrillHolesController {

    @Autowired
    DrillHoleService drillHoleService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getDrillHoles(ModelMap map, HttpSession httpSession) {
        List<DrillHole> drillHoles = drillHoleService.getAll();
        map.put("drillHoles", drillHoles);

        return "/drillholes/drillholes";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getDrillHoleCreatePage() {
        return "/drillholes/new_drillhole";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createNewDrillHole(@RequestParam(name = "name") String name,
                                     @RequestParam(name = "location") String location,
                                     RedirectAttributes redirectAttributes) {

        if(StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(location)) {
            DrillHole drillHole = new DrillHole();
            drillHole.setName(name);
            drillHole.setLocation(location);

            drillHoleService.add(drillHole);

            redirectAttributes.addFlashAttribute("message", "New Drill-Hole Successfully Created");
        }
        return "redirect:/drillholes/all";
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public String viewSelectedDrillHole(@PathVariable("id") ObjectId id, ModelMap model){
        DrillHole drillHole = drillHoleService.get(id);

        model.put("drillHole", drillHole);

        return "drillholes/view_drillhole";
    }

    @RequestMapping(value = "/edit/id/{id}", method = RequestMethod.GET)
    public String getDrillHoleForEdit(@PathVariable("id") ObjectId id, ModelMap model){
        DrillHole drillHole = drillHoleService.get(id);

        model.put("hole", drillHole);

        return "drillholes/edit_drillhole";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveDrillHoleAfterEdit(@ModelAttribute("hole") DrillHole drillHole, RedirectAttributes redirectAttributes){
        drillHoleService.update(drillHole);
        redirectAttributes.addFlashAttribute("message", "Drill-Hole " + drillHole.getName() + " Updated Successfully");

        return "redirect:/drillholes/all";
    }


    @RequestMapping(value = "/delete/id/{id}", method = RequestMethod.GET)
    public String deleteSelectedDrillHole(@PathVariable("id") ObjectId id, RedirectAttributes redirectAttributes){
        DrillHole hole = drillHoleService.get(id);
        drillHoleService.remove(id);

        redirectAttributes.addFlashAttribute("message", "Drill Hole " + hole.getName() + " Deleted Successfully");

        return "redirect:/drillholes/all";
    }

    @RequestMapping(value = "/selectPrimary/id/{id}", method = RequestMethod.GET)
    public String selectPrimaryHole(@PathVariable("id") ObjectId id, RedirectAttributes redirectAttributes,
                                    HttpSession httpSession) {
        DrillHole hole = drillHoleService.get(id);

        httpSession.setAttribute("currentHole", hole);
        redirectAttributes.addFlashAttribute("message", hole.getName() + " Selected As Primary");

        return "redirect:/drillholes/all";
    }

    @RequestMapping(value = "/unselectPrimary/id/{id}", method = RequestMethod.GET)
    public String unselectPrimaryHole(@PathVariable("id") ObjectId id, RedirectAttributes redirectAttributes,
                                      SessionStatus sessionStatus) {
        DrillHole hole = drillHoleService.get(id);

        sessionStatus.setComplete();
        redirectAttributes.addFlashAttribute("message", hole.getName() + " UnSelected As Primary");

        return "redirect:/drillholes/all";
    }
}
