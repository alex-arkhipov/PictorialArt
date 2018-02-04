package com.alexarkhipov.works.pictorialart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexarkhipov.works.pictorialart.dao.AuthorsDao;
import com.alexarkhipov.works.pictorialart.model.Author;
import com.alexarkhipov.works.pictorialart.service.AuthorsService;

@Service
public class AuthorsServiceImpl implements AuthorsService {

	@Autowired
	private AuthorsDao authorsDao;

	@Override
	public List<Author> getAuthors() {
		return authorsDao.getAuthors();
	}

}
