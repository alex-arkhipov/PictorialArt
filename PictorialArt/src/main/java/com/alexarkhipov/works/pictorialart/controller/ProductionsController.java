package com.alexarkhipov.works.pictorialart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alexarkhipov.works.pictorialart.model.Production;
import com.alexarkhipov.works.pictorialart.service.ProductionsService;

@Controller
public class ProductionsController {

	@Autowired
	private ProductionsService productionsService;

	@RequestMapping(value = "/productionslist", method = RequestMethod.GET)
	public ResponseEntity<List<Production>> productions() {

		List<Production> a = productionsService.getProductions();
		return new ResponseEntity<>(a, HttpStatus.OK);
	}

	@RequestMapping(value = "/productionsauthors", method = RequestMethod.GET)
	public ResponseEntity<List<String>> authorlastnames() {

		List<Production> p = productionsService.getProductions();
		List<String> arr = new ArrayList<>();
		for (Production p1 : p) {
			arr.add(p1.toString());
		}
		return new ResponseEntity<>(arr, HttpStatus.OK);
	}

	@RequestMapping(value = "/productiontest", method = RequestMethod.GET)
	public ResponseEntity<String> authorstest() {
		return new ResponseEntity<>("Test string", HttpStatus.OK);
	}

}
