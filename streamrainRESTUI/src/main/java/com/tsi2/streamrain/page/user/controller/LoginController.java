package com.tsi2.streamrain.page.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tsi2.streamrain.datatypes.user.UserDto;
import com.tsi2.streamrain.services.user.interfaces.IUserService;

@Controller
public class LoginController {
	
	
	IUserService userService;
	
	private static final String USER_PREFIX = "/user/";

	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String hello(@RequestParam(value="name", required=false, defaultValue="Pepe") String name, Model model) {
        model.addAttribute("name", name);
        userService.saveUser(new UserDto());
        return USER_PREFIX + "login";
    }
	
}
