package com.angl.drill.mvc.controllers;

import com.angl.drill.algorithm.layer.LayersChangingIdentification;
import com.angl.drill.db.entity.DrillHole;
import com.angl.drill.db.entity.Excavation;
import com.angl.drill.db.entity.ExcavationSession;
import com.angl.drill.services.ExcavationService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Controller
@RequestMapping(value = "/excavation")
public class ExcavationFlotController {

    @Autowired
    ExcavationService excavationService;

    @RequestMapping(value = "/exc", method = RequestMethod.GET)
    public String getExcavation(){
        return "excavation";
    }

    @RequestMapping(value = "/realtime", method = RequestMethod.GET)
    public String getRealTimeFlot(HttpSession session, ModelMap model){
        DrillHole drillHole = (DrillHole) session.getAttribute("currentHole");

        if(drillHole == null) {
            model.put("message", "Drill-Hole is not selected. Please, select a Drill-Hole.");
        } else {
            ExcavationSession excavationSession = new ExcavationSession();
            excavationSession.setDrillHoleId(drillHole.getId());
            excavationSession.setIsExperiment(false);

            excavationService.add(excavationSession);

            session.setAttribute("excavationSession", excavationSession);
        }

        return "excavation/realtime_excavation";
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String getExcavationHistory(ModelMap model){
        List<ExcavationSession> excavationSessions = excavationService.getAll();

        model.put("exc_history", excavationSessions);
        return "excavation/exc_history";
    }

    @RequestMapping(value = "genTestExcavation", method = RequestMethod.GET)
    public String generateTestExcavation() {
        for(int i = 0; i < 5; i++) {
            List<Excavation> excavation = new ArrayList<Excavation>(20);

            for (int j = 0; j < 20; j++) {
                excavation.add(new Excavation(ThreadLocalRandom.current().nextInt(0, 15 + 1), new Date()));
                try {
                    Thread.currentThread().sleep(350);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            ExcavationSession excavationSession = new ExcavationSession();
            excavationSession.setExcavation(excavation);
            excavationSession.setIsExperiment(true);
            excavationSession.setSessionNumber(i);

            excavationService.add(excavationSession);
        }

        return "redirect:/dashboard/dashboard";
    }

    @RequestMapping(value = "/edit/id/{id}", method = RequestMethod.GET)
    public String getExcavationSessionForEdit(@PathVariable("id") ObjectId id, ModelMap model){
        ExcavationSession sessionEntity = excavationService.get(id);

        model.put("id", sessionEntity.getId());
        model.put("sessionNumber", sessionEntity.getSessionNumber());
        model.put("isExperiment", sessionEntity.isExperiment());
        model.put("excavation", sessionEntity.getExcavation());

        return "excavation/exc_edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveExcavationAfterEdit(HttpServletRequest request, ModelMap model){
        String idStr = request.getParameter("id");
        ObjectId id = new ObjectId(idStr);
        String[] excs = request.getParameterValues("exc");

        ExcavationSession excavationSession = excavationService.get(id);

        if(excavationSession != null) {
            List<Excavation> excavation = excavationSession.getExcavation();
            for(int i = 0; i < excavation.size(); i++) {
                Excavation exc = excavation.get(i);
                exc.setExc(Integer.parseInt(excs[i]));
            }

            excavationSession.setExcavation(excavation);
            excavationService.update(excavationSession);

            int sessionNumber = excavationSession.getSessionNumber();
            model.put("id", excavationSession.getId());
            model.put("sessionNumber", sessionNumber);
            model.put("isExperiment", excavationSession.isExperiment());
            model.put("excavation", excavationSession.getExcavation());
            model.put("message", "Excavation Session#" + sessionNumber + " Updated Successfully");
        }

        return "excavation/exc_edit";
    }

    @RequestMapping(value = "/check_layer", method = RequestMethod.POST)
    public String checkLayer(ModelMap model){
        ExcavationSession sessionEntity = excavationService.getAll().get(0);
        boolean isChange = LayersChangingIdentification.idefPlast(sessionEntity.getExcavation());
        model.put("isChange", isChange);

        return "excavation/realtime_excavation";
    }

    @RequestMapping(value = "/fetchData", method = RequestMethod.GET)
    @ResponseBody
    public List<String> fetchData(HttpSession session){
        DrillHole drillHole = (DrillHole) session.getAttribute("currentHole");
        ExcavationSession excavationSession = (ExcavationSession) session.getAttribute("excavationSession");

        List<String> result = new ArrayList<String>();

        if(drillHole != null && excavationSession != null) {
            //List<Excavation> excavation = excavationService.get ... ;
            result.add("14.4");
            result.add("30.7");
            result.add("45.8");
            result.add("8.6");
            result.add("20.5");
            result.add("45.6");
            result.add("50.9");
            result.add("28.8");
            result.add("54.4");
            result.add("32.7");
            result.add("12.8");
            result.add("88.6");
            result.add("25.5");
            result.add("5.6");
            result.add("50.9");
            result.add("68.8");

            return result;
        }

        //return "[[1, 14.4], [2, 30.7], [3, 45.8], [4, 8.6], [5, 20.5], [6, 45.6], [7, 50.9], [8, 28.8], [9, 65.0], [10, 8.1], [11, 100], [12, 10]]";
        return Collections.EMPTY_LIST;
    }
}
