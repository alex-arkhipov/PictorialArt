package com.alexarkhipov.works.pictorialart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexarkhipov.works.pictorialart.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
	Genre findById(Integer id);

	List<Genre> findAll();
}
