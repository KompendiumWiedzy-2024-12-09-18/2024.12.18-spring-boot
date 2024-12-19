package com.comarch.szkolenia.spring.boot.controllers;

import com.comarch.szkolenia.spring.boot.services.INamesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Random;

@Controller
@RequiredArgsConstructor
public class NewController {

    private final INamesService namesService;

    @RequestMapping(value = "/imiona", method = RequestMethod.GET)
    public String imiona(Model model) {

        model.addAttribute("imie", this.namesService.getRandomName());
        model.addAttribute("imiona", this.namesService.getAllNames());

        return "imiona";
    }
}
