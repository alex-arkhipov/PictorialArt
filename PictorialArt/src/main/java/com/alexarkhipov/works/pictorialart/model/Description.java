/**
 * 
 */
package com.alexarkhipov.works.pictorialart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DESCRIPTIONS")
public class Description {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "Description", nullable = false)
	private String description;

	public String getDescription() {
		return description;
	}

}
