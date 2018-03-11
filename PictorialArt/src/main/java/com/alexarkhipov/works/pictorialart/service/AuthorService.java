package com.alexarkhipov.works.pictorialart.service;

import java.util.List;

import com.alexarkhipov.works.pictorialart.model.Author;

public interface AuthorService {

	List<Author> getAuthors();

	Author getAuthor(Integer id);
	
	void save(Author a);
}
