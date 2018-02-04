package com.alexarkhipov.works.pictorialart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WORKS")
public class Works {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;

	@MapsId
	@OneToOne
	@JoinColumn(name = "authorID")
	private Author author;

	@MapsId
	@OneToOne
	@JoinColumn(name = "TextID")
	private Texts text;

	@MapsId
	@OneToOne
	@JoinColumn(name = "TypeID")
	private Types type;

	@MapsId
	@OneToOne
	@JoinColumn(name = "GenreID")
	private Genre genre;

	@Column(name = "CYear")
	private int cYear;

	@Column(name = "Title", nullable = false, length = 255)
	private String title;

	public String getTitle() {
		return title;
	}

}
