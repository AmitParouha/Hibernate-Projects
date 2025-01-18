package com.hibernate.image;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="Cricket_Team")
public class IndianTeam {
	
	@Id
	private int jerseyNo;

	@Column(name="player_name")
	private String name;
	
	@Column(name="role")
	private String role;

	@Lob
	private byte[] image;

	public int getJerseyNo() {
		return jerseyNo;
	}

	public void setJerseyNo(int jerseyNo) {
		this.jerseyNo = jerseyNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "IndianTeam [jerseyNo=" + jerseyNo + ", name=" + name + ", role=" + role + ", image="
				+ Arrays.toString(image) + "]";
	}

	public IndianTeam(int jerseyNo, String name, String role, byte[] image) {
		super();
		this.jerseyNo = jerseyNo;
		this.name = name;
		this.role = role;
		this.image = image;
	}

	public IndianTeam() {
		super();
		// TODO Auto-generated constructor stub
	}



}
