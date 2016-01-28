package com.angl.drill.mvc.controllers;

import com.angl.drill.db.entity.Excavation;
import com.angl.drill.db.entity.ExcavationSession;
import com.angl.drill.services.ExcavationService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
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
    public String getRealTimeFlot(){
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
}
