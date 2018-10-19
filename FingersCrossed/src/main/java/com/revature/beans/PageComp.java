package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="page_comp")
public class PageComp {
	
	@Id
	@Column(name="pc_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer pcId;
	
	@ManyToOne
	@Column(name="comp_id")
	private DefinedComp comp;
	
	@Column(name="page_id")
	private Integer pageId;
	
	@Column(name="parent_id")
	private Integer parentId;
	
	@Column(name="comp_details")
	private String compDetails;
	
	@Column(name="style_id")
	private Integer styleId;

	
	/*@ManyToOne
	@JoinColumn(name="BEAR_HOME")
	private Cave bearHome*/;
	
	
	
	public PageComp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageComp(Integer pcId, DefinedComp compId, Integer pageId, Integer parentId, String compDetails,
			Integer styleId) {
		super();
		this.pcId = pcId;
		this.comp = compId;
		this.pageId = pageId;
		this.parentId = parentId;
		this.compDetails = compDetails;
		this.styleId = styleId;
	}

	public Integer getPcId() {
		return pcId;
	}

	public void setPcId(Integer pcId) {
		this.pcId = pcId;
	}

	public DefinedComp getComp() {
		return comp;
	}

	public void setCompId(DefinedComp compId) {
		this.comp = compId;
	}

	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getCompDetails() {
		return compDetails;
	}

	public void setCompDetails(String compDetails) {
		this.compDetails = compDetails;
	}

	public Integer getStyleId() {
		return styleId;
	}

	public void setStyleId(Integer styleId) {
		this.styleId = styleId;
	}

	@Override
	public String toString() {
		return "PageComp [pcId=" + pcId + ", compId=" + comp + ", pageId=" + pageId + ", parentId=" + parentId
				+ ", compDetails=" + compDetails + ", styleId=" + styleId + "]";
	}

}