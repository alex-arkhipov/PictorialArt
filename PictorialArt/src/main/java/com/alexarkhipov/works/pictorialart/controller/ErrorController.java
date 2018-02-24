package com.alexarkhipov.works.pictorialart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/error")
public class ErrorController {

	@RequestMapping(value = "/filesaving", method = RequestMethod.GET)
	public String s3saveError(Model model) {
		model.addAttribute("error", "Error during file saving");
		return "error";
	}
}
