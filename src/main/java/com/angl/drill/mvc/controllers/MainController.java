package com.angl.drill.mvc.controllers;

import com.angl.drill.db.entity.User;
import com.angl.drill.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    private User userEntity;

   @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String init(ModelMap map){
        ///userEntity = new User();
        //map.put("user", userEntity);

        return "login";
    }
}
