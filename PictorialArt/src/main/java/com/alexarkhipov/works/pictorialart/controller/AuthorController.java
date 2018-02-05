package com.alexarkhipov.works.pictorialart.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alexarkhipov.works.pictorialart.model.Author;
import com.alexarkhipov.works.pictorialart.service.AuthorService;

@Controller
public class AuthorController {

	@Autowired
	private AuthorService authorsService;

	@RequestMapping(value = "/authorslist", method = RequestMethod.GET)
	public ResponseEntity<List<Author>> authors() {

		List<Author> a = authorsService.getAuthors();
		return new ResponseEntity<>(a, HttpStatus.OK);
	}

	@RequestMapping(value = "/authorslastnames", method = RequestMethod.GET)
	public ResponseEntity<List<String>> authorlastnames() {

		List<Author> a = authorsService.getAuthors();
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

}
