package com.recommender.recommenderAlgorithm.controllers;

import com.recommender.recommenderAlgorithm.services.SerialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path="api/serials")
public class SerialController {
    private final SerialService serialService;
    @Autowired
    public SerialController(SerialService serialService) {
        this.serialService = serialService;
    }

    @GetMapping()
    public String getAllSerials(Model model){
        model.addAttribute("serials", serialService.getSerials());
        return "serialsPage";
    }

    @GetMapping("/{id}")
    public String getCurrentSerial(@PathVariable("id") int id, Model model){
        model.addAttribute("serial", serialService.getById((long)id));
        return "serialInfoPage";
    }
}
