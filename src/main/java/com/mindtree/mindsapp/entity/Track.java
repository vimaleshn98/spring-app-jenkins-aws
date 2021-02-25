package com.mindtree.mindsapp.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Track {
	@Id
	private int id;
	private  String name;
	private  String strength;
	public Track(int id, String name, String strength) {
		super();
		this.id = id;
		this.name = name;
		this.strength = strength;
	}
	
	
	
	public Track() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStrength() {
		return strength;
	}
	public void setStrength(String strength) {
		this.strength = strength;
	}
	

}
