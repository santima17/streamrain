package com.tsi2.streamrain.page.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	
	private static final String USER_PREFIX = "/user/";

	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String hello(@RequestParam(value="name", required=false, defaultValue="Pepe") String name, Model model) {
        model.addAttribute("name", name);
        return USER_PREFIX + "login";
    }
	
}
