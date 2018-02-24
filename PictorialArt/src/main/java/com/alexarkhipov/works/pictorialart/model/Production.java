/**
 * 
 */
package com.alexarkhipov.works.pictorialart.model;

import java.util.Map;
import java.util.TreeMap;

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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PRODUCTION")
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

	public void setAuthor(Author a) {
		author = a;
	}

	@MapsId
	@OneToOne
	@JoinColumn(name = "descriptionID")
	private Description description;

	public Description getDescription() {
		return description;
	}

	public void setDescription(Description d) {
		description = d;
	}

	@NotNull
	@Size(min = 3, max = 200)
	@Column(nullable = false, length = 255)
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String t) {
		title = t;
	}

	@Column
	private Integer cyear;

	public Integer getCyear() {
		return cyear;
	}

	public void setCyear(Integer cy) {
		cyear = cy;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "genreID")
	private Genre genre;

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre g) {
		genre = g;
	}

	@Column(nullable = false, length = 255)
	private String filename;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String f) {
		filename = f;
	}

	@Column
	private Integer popularity;

	public Integer getPopularity() {
		return popularity;
	}

	public void setPopularity(Integer p) {
		popularity = p;
	}

	@Override
	public String toString() {
		return title;
	}

	// *****************//
	// Transient block //
	@Transient
	private Integer authorNameId;

	public Integer getAuthorNameId() {
		return authorNameId;
	}

	public void setAuthorNameId(Integer id) {
		authorNameId = id;
	}

	@Transient
	private Integer genreNameId;

	public Integer getGenreNameId() {
		return genreNameId;
	}

	public void setGenreNameId(Integer id) {
		genreNameId = id;
	}

	public static Map<Integer, String> getPopularities() {
		Map<Integer, String> m = new TreeMap<>();
		m.put(1, "Everybody knows");
		m.put(2, "Very famouse");
		m.put(3, "Popular");
		m.put(4, "Not very popular");
		m.put(5, "Only specialist knows");
		return m;
	}

}
