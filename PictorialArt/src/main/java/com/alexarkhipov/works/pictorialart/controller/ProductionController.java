package com.alexarkhipov.works.pictorialart.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alexarkhipov.works.pictorialart.AmazonS3Helper;
import com.alexarkhipov.works.pictorialart.model.Author;
import com.alexarkhipov.works.pictorialart.model.Genre;
import com.alexarkhipov.works.pictorialart.model.Production;
import com.alexarkhipov.works.pictorialart.service.AuthorService;
import com.alexarkhipov.works.pictorialart.service.GenreService;
import com.alexarkhipov.works.pictorialart.service.ProductionService;

@Controller
@RequestMapping(value = "/production")
public class ProductionController {
	private static final Logger logger = LoggerFactory.getLogger(ProductionController.class);
	public static final String PRODUCTION_ATTR = "production";
	public static final String PRODUCTION = "production";
	public static final String NEW_PRODUCTION = "new";
	public static final String INFO_PRODUCTION = "info";
	public static final String SLASH = "/";

	@Autowired
	private AmazonS3Helper s3Helper;

	@Autowired
	private ProductionService productionService;

	@Autowired
	private GenreService genreService;

	@Autowired
	private AuthorService authorService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<Production>> productions() {

		List<Production> a = productionService.getProductions();
		return new ResponseEntity<>(a, HttpStatus.OK);
	}

	@RequestMapping(value = "/productionsauthors", method = RequestMethod.GET)
	public ResponseEntity<List<String>> authorlastnames() {

		List<Production> p = productionService.getProductions();
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

	@RequestMapping(value = SLASH + NEW_PRODUCTION, method = RequestMethod.GET)
	public String newProduction(@ModelAttribute(PRODUCTION_ATTR) Production production, Model model) {

		List<Genre> gs = genreService.getGenres();
		model.addAttribute("genres", gs);

		List<Author> aus = authorService.getAuthors();
		model.addAttribute("authors", aus);

		Map<Integer, String> popularities = Production.getPopularities();
		model.addAttribute("popularities", popularities);

		return SLASH + PRODUCTION + SLASH + NEW_PRODUCTION;
	}

	@RequestMapping(value = SLASH + NEW_PRODUCTION, method = RequestMethod.POST)
	public String newProductionProcess(Model m, RedirectAttributes model,
			@RequestParam("fileData") MultipartFile fileData,
			@ModelAttribute(PRODUCTION_ATTR) @Valid Production production, BindingResult errors) {

		if (errors.hasErrors()) {
			return SLASH + PRODUCTION + SLASH + NEW_PRODUCTION;
		}

		// Get author
		production.setAuthor(authorService.getAuthor(production.getAuthorNameId()));

		// Get Genre
		production.setGenre(genreService.getGenre(production.getGenreNameId()));

		if (!s3Helper.saveFile(fileData)) {
			return "error/filesaving";
		}

		productionService.saveProduction(production);
		model.addFlashAttribute(PRODUCTION_ATTR, production);

		logger.info("New production added: " + production.getTitle());

		return "redirect:" + SLASH + PRODUCTION + SLASH + production.getId();
	}

	@RequestMapping(value = "/{productionid}", method = RequestMethod.GET)
	public String showProductionInfo(@PathVariable Integer productionid, Model model) {
		if (!model.containsAttribute(PRODUCTION_ATTR)) {
			Production prod = productionService.getProductionEx(productionid);
			model.addAttribute(PRODUCTION_ATTR, prod);
		}

		return SLASH + PRODUCTION + SLASH + INFO_PRODUCTION;
	}
}
