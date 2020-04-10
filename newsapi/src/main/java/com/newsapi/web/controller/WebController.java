package com.newsapi.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

	@RequestMapping("/")
	ModelAndView home(ModelAndView modelAndView, HttpServletRequest request) {
		modelAndView.setViewName("home");
		return modelAndView;
	}
}