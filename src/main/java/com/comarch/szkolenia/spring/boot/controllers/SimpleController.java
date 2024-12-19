package com.comarch.szkolenia.spring.boot.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SimpleController {

    @RequestMapping(path = "/test1", method = RequestMethod.GET)
    public String test1(HttpSession session) {
        System.out.println("Cos zadzialalo !!");

        if(session.getAttribute("user") == null) {
            System.out.println("to jest nowy client");
            session.setAttribute("user", "janusz");
        } else {
            System.out.println("to jest stary klient !!");
        }
        return "test1";
    }

    @RequestMapping(path = "/test2", method = RequestMethod.GET)
    public String test2(@RequestParam(name = "imie", required = false) String name,
                        @RequestParam("nazwisko") String surname,
                        @RequestParam("wiek") int age,
                        @RequestHeader("user-agent") String header) {
        System.out.println(name);
        System.out.println(surname);
        System.out.println(age);
        System.out.println(header);
        return "test1";
    }

    @RequestMapping(path = "/test3/{name}/{surname}/{age}", method = RequestMethod.GET)
    public String test3(@PathVariable("name") String name,
                        @PathVariable("surname") String surname,
                        @PathVariable("age") int age) {
        System.out.println(name);
        System.out.println(surname);
        System.out.println(age);
        return "test1";
    }

    @RequestMapping(path = "/test3/{surname}/{age}", method = RequestMethod.GET)
    public String test4(@PathVariable("surname") String surname,
                        @PathVariable("age") int age) {
        System.out.println(surname);
        System.out.println(age);
        return "test1";
    }

    @RequestMapping(path = "/form", method = RequestMethod.GET)
    public String form() {
        return "form";
    }

    @RequestMapping(path = "/form", method = RequestMethod.POST)
    public String form(@RequestParam("imie") String imie,
                       @RequestParam("haslo") String haslo) {
        System.out.println(imie);
        System.out.println(haslo);
        return "test1";
    }
}
