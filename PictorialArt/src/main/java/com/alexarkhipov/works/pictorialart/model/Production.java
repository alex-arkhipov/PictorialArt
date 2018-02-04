/**
 * 
 */
package com.alexarkhipov.works.pictorialart.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTIONS")
public class Production {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public int getId() {
		return id;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "authorID")
	private Author author;

	public Author getAuthor() {
		return author;
	}

	@MapsId
	@OneToOne
	@JoinColumn(name = "descriptionID")
	private Description description;

	@Column(nullable = false, length = 255)
	private String title;

	public String getTitle() {
		return title;
	}

	@Column
	private Integer cyear;

	public Integer cyear() {
		return cyear;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "genreID")
	private Genre genre;

	public String getGenre() {
		return genre.getGenre();
	}

	@Column(nullable = false, length = 255)
	private String filename;

	public String getFilename() {
		return filename;
	}

	@Column
	private Integer popularity;

	public Integer getPopularity() {
		return popularity;
	}

	@Override
	public String toString() {
		return title;
	}

}
