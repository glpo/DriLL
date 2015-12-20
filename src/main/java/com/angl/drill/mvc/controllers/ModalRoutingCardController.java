package com.angl.drill.mvc.controllers;

import com.angl.drill.db.entity.ModalRoutingCardEntity;
import com.angl.drill.services.ModalRoutingCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
@RequestMapping("/routing")
public class ModalRoutingCardController {

    @Autowired
    ModalRoutingCardService modalRoutingCardService;

    @RequestMapping(value = "/card", method = RequestMethod.GET)
    public ModelAndView getRoutingCard () {
        //ModalRoutingCardEntity routingCard = modalRoutingCardService.get();
        ModalRoutingCardEntity entity = new ModalRoutingCardEntity();

        entity.setDepth(Arrays.asList(100, 200, 300, 400, 500, 600, 700));
        entity.setLitology(null);
        entity.setConstans(Arrays.asList("K,470", "K2,1", "J 1690", "T, 2445", "P1, 2675", "C, 3120"));
        entity.setConstraction(Arrays.asList("426 mm", "324 mm", "245 mm", "146 mm", "148 mm"));
        entity.setComplications(Arrays.asList("Poglinannya 23423423", "Osipannya 34535345", "4353453535", "3453453543", "345345345345", "345345345345345435", "3453453453454353534534"));
        entity.setBitSize(Arrays.asList("23423", "324234", "234234", "23423432", "53533"));
      /*  entity.set
        entity.set
        entity.set
        entity.set
        entity.set
        entity.set
        entity.set*/

        return new ModelAndView("/routing/routing_card", "routingCards", entity);
    }
}
