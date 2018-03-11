package com.alexarkhipov.works.pictorialart.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alexarkhipov.works.pictorialart.model.Author;
import com.alexarkhipov.works.pictorialart.service.AuthorService;

@Controller
@RequestMapping(value = "/author")
public class AuthorController {
	private static final Logger logger = LoggerFactory.getLogger(AuthorController.class);
	public static final String AUTHOR_ATTR = "author";
	public static final String AUTHOR = "author";
	public static final String NEW_AUTHOR = "new";
	public static final String INFO_AUTHOR = "info";
	public static final String SLASH = "/";
	
	@Autowired
	private AuthorService authorService;

	@RequestMapping(value = "/authorslist", method = RequestMethod.GET)
	public ResponseEntity<List<Author>> authors() {

		List<Author> a = authorService.getAuthors();
		return new ResponseEntity<>(a, HttpStatus.OK);
	}

	@RequestMapping(value = "/authorslastnames", method = RequestMethod.GET)
	public ResponseEntity<List<String>> authorlastnames() {

		List<Author> a = authorService.getAuthors();
		List<String> arr = new ArrayList<>();
		for (Author a1 : a) {
			arr.add(a1.getFullname());
		}
		return new ResponseEntity<>(arr, HttpStatus.OK);
	}

	@RequestMapping(value = "/authortest", method = RequestMethod.GET)
	public ResponseEntity<String> authorstest() {
		return new ResponseEntity<>("Test string", HttpStatus.OK);
	}
	
	@RequestMapping(value = SLASH + NEW_AUTHOR, method = RequestMethod.GET)
	public String newAuthor(@ModelAttribute(AUTHOR_ATTR) Author author, Model model) {

		List<Author> aus = authorService.getAuthors();
		model.addAttribute("authors", aus);

		return AUTHOR + SLASH + NEW_AUTHOR;
	}

	@RequestMapping(value = SLASH + NEW_AUTHOR, method = RequestMethod.POST)
	public String newAuthorProcess(Model m, RedirectAttributes model,
			@ModelAttribute(AUTHOR_ATTR) @Valid Author author, BindingResult errors) {

		if (errors.hasErrors()) {
			return AUTHOR + SLASH + NEW_AUTHOR;
		}

		author.setFullname();
		authorService.save(author);
		logger.info("New author added: {}", author.getFullname());
		
		model.addFlashAttribute(AUTHOR_ATTR, author);

		return "redirect:" + SLASH + AUTHOR + SLASH + author.getId();
	}

	@RequestMapping(value = "/{authorid}", method = RequestMethod.GET)
	public String showProductionInfo(@PathVariable Integer authorid, Model model) {
		if (!model.containsAttribute(AUTHOR_ATTR)) {
			Author author = authorService.getAuthor(authorid);
			model.addAttribute(AUTHOR_ATTR, author);
		}

		return AUTHOR + SLASH + INFO_AUTHOR;
	}

}
