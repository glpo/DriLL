package com.angl.drill.mvc.controllers;

import com.angl.drill.db.entity.ExcavationSession;
import com.angl.drill.db.entity.Notification;
import com.angl.drill.db.utils.NotificationType;
import com.angl.drill.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;


@Controller
@RequestMapping(value = "/notification")
public class NotificationsController {

    @Autowired
    NotificationService notificationService;

    @RequestMapping(value = "/createNotification", method = RequestMethod.GET)
    public void fetchExcavationData(@RequestParam(name = "type") String type,
                                    @RequestParam(name = "text") String text,
                                    HttpSession session){
        ExcavationSession excavationSession = (ExcavationSession) session.getAttribute("excavationSession");
        if(excavationSession != null) {
            Notification notification = new Notification();
            notification.setText(text);
            notification.setDate(new Date());
            notification.setSessionId(excavationSession.getId());

            if ("information".equals(type)) {
                notification.setType(NotificationType.INFORMATION);
            } else if ("upload".equals(type)) {
                notification.setType(NotificationType.UPLOAD);
            } else if ("bolt".equals(type)) {
                notification.setType(NotificationType.BOLT);
            } else if ("warning".equals(type)) {
                notification.setType(NotificationType.WARNING);
            }

            notificationService.add(notification);
        }
    }
}

