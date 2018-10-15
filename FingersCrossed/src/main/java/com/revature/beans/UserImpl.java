package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import com.revature.interfaces.User;

@Entity
@Table(name="users")
@SecondaryTables({
	@SecondaryTable(name="user_credentials", pkJoinColumns= {
			@PrimaryKeyJoinColumn(name="uc_id", referencedColumnName="u_id")})})
public class UserImpl implements User {

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
	
	/*
	 * Constructors 	
	 */
	public UserImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserImpl(Integer id, String uName, String fName, String lName, String eMail, String pWord) {
		super();
		this.id = id;
		this.uName = uName;
		this.fName = fName;
		this.lName = lName;
		this.eMail = eMail;
		this.pWord = pWord;
	}
	
	/*
	 * Getters/Setters
	 */
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
	public void setId(int id) {
		this.id = id;
	}
	
	/*
	 * To string
	 */
	@Override
	public String toString() {
		return "UserImpl [id=" + id + ", uName=" + uName + ", fName=" + fName + ", lName=" + lName + ", eMail=" + eMail
				+ ", pWord=" + pWord + "]";
	}
	public boolean equals(User user) {
		if (this.id != user.getId()) return false;
		if (this.uName != user.getuName()) return false;
		if (this.fName != user.getfName()) return false;
		if (this.lName != user.getlName()) return false;
		if (this.eMail != user.geteMail()) return false;
		if (this.pWord != user.getpWord()) return false;
		if (this.experienced != user.isExperienced()) return false;
		return true;
	}
}
