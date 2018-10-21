package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="defined_comp")
public class DefinedComp {

	@Override
	public String toString() {
		return "DefinedComp [id=" + id + ", compName=" + compName + ", compType=" + compType + "]";
	}

	@Id
	@Column(name="dc_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="comp_name")
	private String compName;
	
	@Column(name="comp_type")
	private String compType;

	/*
	 * constructors
	 */
	public DefinedComp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DefinedComp(Integer id, String compName, String compType) {
		super();
		this.id = id;
		this.compName = compName;
		this.compType = compType;
	}

	/*
	 * getters/setters
	 */
	public Integer getId() {
		//
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompType() {
		return compType;
	}

	public void setCompType(String compType) {
		this.compType = compType;
	}
}