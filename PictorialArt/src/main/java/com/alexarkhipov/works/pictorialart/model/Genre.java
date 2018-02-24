package com.alexarkhipov.works.pictorialart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GENRE")
public class Genre {

	@Id
	@Column(name = "id")
	private int id;

	public Integer getId() {
		return id;
	}

	@Column(name = "Genre", nullable = false)
	private String genre;

	public String getGenre() {
		return genre;
	}

	public void setGenre(String g) {
		genre = g;
	}

}
