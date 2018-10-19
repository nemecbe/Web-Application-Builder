package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="unpub_page")
public class PublishedPage {

	@Id
	@Column(name="published_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer publishedId;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="page_id")
	private Integer pageId;
	
	@Column(name="page_name")
	private String pageName;
	
	@Column(name="active")
	private boolean active;

	public PublishedPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PublishedPage(Integer publishedId, Integer user, Integer pageId, String pageName, boolean active) {
		super();
		this.publishedId = publishedId;
		this.userId = user;
		this.pageId = pageId;
		this.pageName = pageName;
		this.active = active;
	}

	public Integer getPublishedId() {
		return publishedId;
	}

	public void setPublishedId(Integer publishedId) {
		this.publishedId = publishedId;
	}

	public Integer getUser() {
		return userId;
	}

	public void setUser(Integer user) {
		this.userId = user;
	}

	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
