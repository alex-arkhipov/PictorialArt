package com.alexarkhipov.works.pictorialart.controller;

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

import com.alexarkhipov.works.pictorialart.GenreRepository;
import com.alexarkhipov.works.pictorialart.model.Genre;

@Controller
@RequestMapping(value = "/genre")
public class GenreController {
	private static final Logger logger = LoggerFactory.getLogger(GenreController.class);
	public static final String GENRE_ATTR = "genre";
	public static final String GENRE = "genre";
	public static final String NEW_GENRE = "new";
	public static final String INFO_GENRE = "info";
	public static final String SLASH = "/";

	@Autowired
	private GenreRepository genreRepository;

	@RequestMapping(value = "/genreslist", method = RequestMethod.GET)
	public ResponseEntity<List<Genre>> genres() {

		List<Genre> g = genreRepository.findAll();
		return new ResponseEntity<>(g, HttpStatus.OK);
	}

	@RequestMapping(value = SLASH + NEW_GENRE, method = RequestMethod.GET)
	public String newGenre(@ModelAttribute(GENRE_ATTR) Genre genre, Model model) {

		List<Genre> gs = genreRepository.findAll();
		model.addAttribute("genres", gs);

		return GENRE + SLASH + NEW_GENRE;
	}

	@RequestMapping(value = SLASH + NEW_GENRE, method = RequestMethod.POST)
	public String newGenreProcess(Model m, RedirectAttributes model, @ModelAttribute(GENRE_ATTR) @Valid Genre genre,
			BindingResult errors) {

		if (errors.hasErrors()) {
			return GENRE + SLASH + NEW_GENRE;
		}

		genreRepository.save(genre);
		logger.info("New genre added: {}", genre.getGname());

		model.addFlashAttribute(GENRE_ATTR, genre);

		return "redirect:" + SLASH + GENRE + SLASH + genre.getId();
	}

	@RequestMapping(value = "/{genreid}", method = RequestMethod.GET)
	public String showProductionInfo(@PathVariable Integer genreid, Model model) {
		if (!model.containsAttribute(GENRE_ATTR)) {
			Genre genre = genreRepository.findById(genreid);
			model.addAttribute(GENRE_ATTR, genre);
		}

		return GENRE + SLASH + INFO_GENRE;
	}

}
