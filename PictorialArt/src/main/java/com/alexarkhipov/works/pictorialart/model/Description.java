/**
 * 
 */
package com.alexarkhipov.works.pictorialart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DESCRIPTION")
public class Description {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Description", nullable = false)
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String d) {
		description = d;
	}

}
