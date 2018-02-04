package com.alexarkhipov.works.pictorialart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TYPES")
public class Types {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "Type", nullable = false)
	private String type;

	public String getType() {
		return type;
	}

}
