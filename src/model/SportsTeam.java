package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Rumbi Chinhamhora rchinhamhora
 * CIS 175 - Spring 2021
 * Feb 13, 2021
 */
@Entity
@Table(name="teams")
public class SportsTeam {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="CITY")
	private String city;
	@Column(name="NAME")
	private String name;
	@Column(name="SPORT")
	private String sport;

	public SportsTeam() { super(); }

	public SportsTeam(String city, String name, String sport) {
		super();
		this.city = city;
		this.name = name;
		this.sport = sport;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	
	@Override
	public String toString() {
		return city + " " + name + ", " + sport;
	}
	
	
}
