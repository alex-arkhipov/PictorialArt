package com.alexarkhipov.works.pictorialart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexarkhipov.works.pictorialart.dao.AuthorDao;
import com.alexarkhipov.works.pictorialart.model.Author;
import com.alexarkhipov.works.pictorialart.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDao authorsDao;

	@Override
	public List<Author> getAuthors() {
		return authorsDao.getAuthors();
	}

	@Override
	public Author getAuthor(Integer id) {
		return authorsDao.getAuthor(id);
	}

	@Override
	public void save(Author a) {
		authorsDao.save(a);
	}
	
}
