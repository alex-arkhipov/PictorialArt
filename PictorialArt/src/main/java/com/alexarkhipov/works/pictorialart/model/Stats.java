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
@Table(name = "STATS")
public class Stats {

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@MapsId
	@OneToOne
	@JoinColumn(name = "StattypeID")
	private StatTypes stattype;

	@MapsId
	@OneToOne
	@JoinColumn(name = "AuthorID")
	private Author author;

	@MapsId
	@OneToOne
	@JoinColumn(name = "PlayerID")
	private Players player;

	@MapsId
	@OneToOne
	@JoinColumn(name = "WorkID")
	private Works work;

	@Column(name = "Correct")
	private int correct;

	@Column(name = "Played")
	private int played;

}
