package com.angl.drill.mvc.controllers;

import com.angl.drill.db.entity.ModalRoutingCardEntity;
import com.angl.drill.services.ModalRoutingCardService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/routing")
public class ModalRoutingCardController {

    @Autowired
    ModalRoutingCardService modalRoutingCardService;

    @RequestMapping(value = "/card", method = RequestMethod.GET)
    public ModelAndView getRoutingCard () {
        //ModalRoutingCardEntity routingCard = modalRoutingCardService.get();
        ModalRoutingCardEntity entity = new ModalRoutingCardEntity();

        entity.setName("Routing Card #1 loollffooolo 324423 asdada");
      /*  entity.setDepth(Arrays.asList(100, 200, 300, 400, 500, 600, 700));
        entity.setLitology(null);
        entity.setConstans(Arrays.asList("K,470", "K2,1", "J 1690", "T, 2445", "P1, 2675", "C, 3120"));
        entity.setConstruction(Arrays.asList("426 mm", "324 mm", "245 mm", "146 mm", "148 mm"));
        entity.setComplications(Arrays.asList("Poglinannya 23423423", "Osipannya 34535345", "4353453535", "3453453543", "345345345345", "345345345345345435", "3453453453454353534534"));
        entity.setBitSize(Arrays.asList("23423", "324234", "234234", "23423432", "53533"));
        entity.set
        entity.set
        entity.set
        entity.set
        entity.set
        entity.set
        entity.set*/

        return new ModelAndView("/routing/routing_card", "card", Collections.singletonList(entity));
    }

    @RequestMapping(value = "/allCards", method = RequestMethod.GET)
    public ModelAndView getAllRoutingCards() {
        //List<ModalRoutingCardEntity> routingCards = modalRoutingCardService.getAll();

        return new ModelAndView("/routing/all_cards", "routingCards", null);
    }

    @RequestMapping(value = { "/edit/id/{id}"}, method = RequestMethod.GET)
    public String editDevice(@PathVariable("id") ObjectId id, Model model) {
        model.addAttribute("card", modalRoutingCardService.get(id));
        model.addAttribute("isEdit", true);

        return "/routing/routing_card";
    }


    @RequestMapping(value = { "/delete/id/{id}"}, method = RequestMethod.GET)
    public String deleteDevice(@PathVariable("id") ObjectId id, HttpServletRequest request,
                               RedirectAttributes redirectAttributes) {
        modalRoutingCardService.remove(id);
        String referer = request.getHeader("Referer");
        redirectAttributes.addFlashAttribute("message", "Device deleted successfully!");
        return "redirect:" + referer;
    }
}
