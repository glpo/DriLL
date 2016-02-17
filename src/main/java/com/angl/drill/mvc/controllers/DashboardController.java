package com.angl.drill.mvc.controllers;

import com.angl.drill.db.entity.DrillHole;
import com.angl.drill.services.ExcavationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/dashboard")
public class DashboardController {

/*    @Autowired
    private ExcavationService excavationService;*/


    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String getDashboard(HttpSession session, ModelMap model){
        DrillHole drillHole = (DrillHole) session.getAttribute("currentHole");
        if(drillHole == null) {
            model.put("message", "Drill-Hole is not selected. Please, select a Drill-Hole");
        }

        return "/dashboard/dashboard";
    }

    @RequestMapping(value = "/d", method = RequestMethod.GET)
    public String getd(){
        //ModelAndView modelAndView = new ModelAndView("dashboard");
        //modelAndView.addObject("excavation", excavationService.getAll());

        //return modelAndView;
        return "/dashboard/d";
    }
}
