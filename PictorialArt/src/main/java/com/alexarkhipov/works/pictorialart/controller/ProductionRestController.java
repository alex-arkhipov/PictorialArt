package com.alexarkhipov.works.pictorialart.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alexarkhipov.works.pictorialart.model.Production;
import com.alexarkhipov.works.pictorialart.service.ProductionService;

@RestController
@RequestMapping("/rest/production")
public class ProductionRestController {

	@Autowired
	private ProductionService productionService;

	@RequestMapping(method = RequestMethod.GET, value="/all")
	Collection<Production> readProductions() {
		return productionService.getProductions();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/one/{prodId}")
	Production readProduction(@PathVariable Integer prodId) {
		return productionService.getProductionEx(prodId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/few/{number}")
	Collection<Production> readProductions(@PathVariable Integer number) {
		return productionService.getProductions(number);
	}

	
}
