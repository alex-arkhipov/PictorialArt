package com.alexarkhipov.works.pictorialart.dao;

import java.util.List;

import com.alexarkhipov.works.pictorialart.model.Author;

public interface AuthorsDao {
	List<Author> getAuthors();
}
