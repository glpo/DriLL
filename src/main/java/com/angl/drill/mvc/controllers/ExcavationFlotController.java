package com.angl.drill.mvc.controllers;

import com.angl.drill.db.entity.ExcavationEntity;
import com.angl.drill.services.ExcavationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/excavation")
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

    @RequestMapping(value = "/realtime", method = RequestMethod.GET)
    public String getRealTimeFlot(){
        return "excavation/flot";
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String getExcavationHistory(ModelMap model){

        List<String> history = new ArrayList<String>();
        history.add("Excavation Session #1 20.12.15 15:44 - 456m");
        history.add("Excavation Session #2 20.12.15 16:27 - 401m");
        history.add("Excavation Session #3 20.12.15 16:51 - 456m");
        history.add("Excavation Session #4 21.12.15 10:44 - 731m");
        history.add("Excavation Session #5 21.12.15 13:44 - 496m");
        history.add("Excavation Session #6 21.12.15 11:44 - 886m");
        history.add("Excavation Session #7 22.12.15 12:44 - 1023m");

        model.put("exc_history", history);

        return "excavation/exc_history";
    }
}
