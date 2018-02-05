/**
 * 
 */
package com.alexarkhipov.works.pictorialart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DESCRIPTION")
public class Description {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "Description", nullable = false)
	private String desc;

	public String getDescription() {
		return desc;
	}

}
