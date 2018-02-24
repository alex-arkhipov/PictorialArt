package com.alexarkhipov.works.pictorialart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexarkhipov.works.pictorialart.dao.GenreDao;
import com.alexarkhipov.works.pictorialart.model.Genre;
import com.alexarkhipov.works.pictorialart.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreDao genreDao;

	@Override
	public List<Genre> getGenres() {
		return genreDao.getGenres();
	}

	@Override
	public Genre getGenre(Integer id) {
		return genreDao.getGenre(id);
	}

}
