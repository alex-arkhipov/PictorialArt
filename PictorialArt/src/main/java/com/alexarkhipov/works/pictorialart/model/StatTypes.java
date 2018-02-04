package com.alexarkhipov.works.pictorialart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STATTYPES")
public class StatTypes {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "stattype", nullable = false)
	private String stattype;

	public String getStatType() {
		return stattype;
	}

}
