package com.alexarkhipov.works.pictorialart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEXTS")
public class Texts {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "Text", nullable = false)
	private String text;

	public String getText() {
		return text;
	}

}
