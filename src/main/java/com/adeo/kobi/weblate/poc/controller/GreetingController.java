package com.adeo.kobi.weblate.poc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(Model model, Locale locale) {
        model.addAttribute("locale", locale.toLanguageTag());
        return "greeting";
    }
}
