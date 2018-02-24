package com.alexarkhipov.works.pictorialart.service;

import java.util.List;

import com.alexarkhipov.works.pictorialart.model.Genre;

public interface GenreService {

	List<Genre> getGenres();

	Genre getGenre(Integer id);
}
