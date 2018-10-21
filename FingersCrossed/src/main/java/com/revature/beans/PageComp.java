package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@JoinColumn(name="comp_id")
	private DefinedComp compId;
	
	@Column(name="page_id")
	private Integer pageId;
	
	@Column(name="parent_id")
	private Integer parentId;
	
	@Column(name="comp_details")
	private String compDetails;
	
	@Column(name="style_id")
	private Integer styleId;
	
	@Column(name="x_cord")
	private Integer xPos;
	
	@Column(name="y_cord")
	private Integer yPos;

	
	/*@ManyToOne
	@JoinColumn(name="BEAR_HOME")
	private Cave bearHome*/;
	
	
	
	public PageComp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageComp(Integer pcId, DefinedComp compId, Integer pageId, Integer parentId, String compDetails,
			Integer styleId, Integer xPos, Integer yPos) {
		super();
		this.pcId = pcId;
		this.compId = compId;
		this.pageId = pageId;
		this.parentId = parentId;
		this.compDetails = compDetails;
		this.styleId = styleId;
		this.xPos = xPos;
		this.yPos = yPos;
	}

	public Integer getPcId() {
		return pcId;
	}

	public void setPcId(Integer pcId) {
		this.pcId = pcId;
	}

	public DefinedComp getCompId() {
		return compId;
	}

	public void setCompId(DefinedComp compId) {
		this.compId = compId;
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

	public Integer getxPos() {
		return xPos;
	}

	public void setxPos(Integer xPos) {
		this.xPos = xPos;
	}

	public Integer getyPos() {
		return yPos;
	}

	public void setyPos(Integer yPos) {
		this.yPos = yPos;
	}

	@Override
	public String toString() {
		return "PageComp [pcId=" + pcId + ", compId=" + compId + ", pageId=" + pageId + ", parentId=" + parentId
				+ ", compDetails=" + compDetails + ", styleId=" + styleId + ", xPos=" + xPos + ", yPos=" + yPos + "]";
	}

}