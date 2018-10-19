package com.revature.beans;

import java.beans.ConstructorProperties;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name="users")
@SecondaryTables({
	@SecondaryTable(name="user_credentials", pkJoinColumns= {
			@PrimaryKeyJoinColumn(name="uc_id", referencedColumnName="u_id")}),
	@SecondaryTable(name="user_payment_info", pkJoinColumns= {
			@PrimaryKeyJoinColumn(name="upay_id", referencedColumnName="u_id")}),
	@SecondaryTable(name="current_charge", pkJoinColumns= {
			@PrimaryKeyJoinColumn(name="uchar_id", referencedColumnName="u_id")
	})
})
public class User {

	@Id
	@Column(table="users", name="u_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(table="user_credentials", name="u_name")
	private String uName;
	
	@Column(table="users", name="f_name")	
	private String fName;

	@Column(table="users", name="l_name")
	private String lName;

	@Column(table="users", name="email")
	private String eMail;
	
	@Column(table="user_credentials", name="p_word")
	private String pWord;	

	@Column(table="users", name="experienced")
	private boolean experienced;
	
	@OneToMany
	@JoinColumn(table="user_payment_info", name="ccinfo")
	private Set<String> ccinfo;
	
	@Column(table="current_charge", name="page_count")
	private Integer pageCount;
	
	@Column(table="current_charge", name="total_amount")
	private Double totalCharge;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String uName, String fName, String lName, String eMail, String pWord, boolean experienced,
			Set<String> ccinfo, Integer pageCount, Double totalCharge) {
		super();
		this.id = id;
		this.uName = uName;
		this.fName = fName;
		this.lName = lName;
		this.eMail = eMail;
		this.pWord = pWord;
		this.experienced = experienced;
		this.ccinfo = ccinfo;
		this.pageCount = pageCount;
		this.totalCharge = totalCharge;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uName=" + uName + ", fName=" + fName + ", lName=" + lName + ", eMail=" + eMail
				+ ", pWord=" + pWord + ", experienced=" + experienced + ", ccinfo=" + ccinfo + ", pageCount="
				+ pageCount + ", totalCharge=" + totalCharge + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return obj instanceof User ? this.id == ((User)obj).id : false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getpWord() {
		return pWord;
	}

	public void setpWord(String pWord) {
		this.pWord = pWord;
	}

	public boolean isExperienced() {
		return experienced;
	}

	public void setExperienced(boolean experienced) {
		this.experienced = experienced;
	}

	public Set<String> getCcinfo() {
		return ccinfo;
	}

	public void setCcinfo(Set<String> ccinfo) {
		this.ccinfo = ccinfo;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Double getTotalCharge() {
		return totalCharge;
	}

	public void setTotalCharge(Double totalCharge) {
		this.totalCharge = totalCharge;
	}

}
