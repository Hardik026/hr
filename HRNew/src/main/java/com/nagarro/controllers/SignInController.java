package com.nagarro.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.dto.User;
import com.nagarro.services.UserService;

@Controller
public class SignInController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "signin", method = RequestMethod.GET)
	public String authenticate(HttpServletRequest request) {
		ModelAndView modelView = new ModelAndView();
		String response;
        HttpSession httpSession = request.getSession(false);
        if (httpSession != null && httpSession.getAttribute("username") != null) {
            response = "redirect:/employees";
        } else {
            response = "index";
            modelView.addObject("msg", "");
        }
        return response;
	}

	@RequestMapping(value = "signin", method = RequestMethod.POST)
	public String authenticate(@RequestParam("username") String username, @RequestParam("password") String password,
			ModelAndView model, HttpServletRequest request) {
		User user = userService.validateUser(username, password);
		String response;
		if (user == null) {
			model.addObject("msg", "Username or Password Incorrect");
			model.setViewName("index");
			response = "index";
		} else {
			model.addObject("username", user.getUsername());
			model.setViewName("redirect:/employees");
			request.getSession().setAttribute("username", user.getUsername());
			response = "redirect:/employees";
		}
		return response;
	}

	/**
	 * POST for Logout
	 * 
	 * @param request
	 * @return Login JSP
	 */
	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public String logout(HttpServletRequest request) {
		request.getSession(false).removeAttribute("username");
		return "redirect:/signin";
	}

}