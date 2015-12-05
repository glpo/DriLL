package com.angl.drill.mvc.controllers;

import com.angl.drill.db.entity.ExcavationEntity;
import com.angl.drill.services.ExcavationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ExcavationFlotController {

    @Autowired
    ExcavationService excavationService;

    @RequestMapping(value = "/exc", method = RequestMethod.GET)
    public String getExcavation(){
        return "excavation";
    }

    @RequestMapping(value = "/getexc", method = RequestMethod.GET)
    @ResponseBody
    public List<ExcavationEntity> getExcavationData() {
        return excavationService.getAll();
    }

    @RequestMapping(value = "/flot", method = RequestMethod.GET)
    public String getFlot(){
        return "flot";
    }
}
