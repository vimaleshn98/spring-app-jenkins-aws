package com.mindtree.mindsapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Mind {
	@Id
	private int id;
	private String name;
	private String track;
	private String role;
	private String phone;
	
	@OneToOne
	Track track2;
	
	public Track getTrack2() {
		return track2;
	}
	public void setTrack2(Track track2) {
		this.track2 = track2;
	}
	public Mind() {
		// TODO Auto-generated constructor stub
	}
	public Mind(int id, String name, String track, String role, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.track = track;
		this.role = role;
		this.phone = phone;
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
	public String getTrack() {
		return track;
	}
	public void setTrack(String track) {
		this.track = track;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
