package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.revature.interfaces.DefinedComp;

@Entity
@Table(name="defined_comp")
public class DefinedCompImpl implements DefinedComp {

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
	public DefinedCompImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DefinedCompImpl(Integer id, String compName, String compType) {
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