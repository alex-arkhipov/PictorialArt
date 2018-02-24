package com.alexarkhipov.works.pictorialart.dao;

import java.util.List;

import com.alexarkhipov.works.pictorialart.model.Genre;

public interface GenreDao {
	List<Genre> getGenres();

	Genre getGenre(Integer id);
}
