package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.revature.interfaces.Page;

@Entity
@Table(name="page")
public class PageImpl implements Page {

	@Id
	@Column(name="p_id")
	private Integer pId;
	
	@Column(name="p_u_id")
	private Integer puId;
	
	@Column(name="p_name")
	private String pName;
	
	@Column(name="active")
	private Boolean active;

	/*
	 * constructors
	 */
	public PageImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageImpl(Integer pId, Integer puId, String pName, Boolean active) {
		super();
		this.pId = pId;
		this.puId = puId;
		this.pName = pName;
		this.active = active;
	}

	/*
	 * getters/setters
	 */
	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public Integer getPuId() {
		return puId;
	}

	public void setPuId(Integer puId) {
		this.puId = puId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}

