package com.revature.interfaces;

public interface User {

	public Integer getId();
	
	public void setId(Integer id);
	
	public String getuName();
	
	public void setuName(String uName);
	
	public String getfName();
	
	public void setfName(String fName);
	
	public String getlName();
	
	public void setlName(String lName);
	
	public String geteMail();
	
	public void seteMail(String eMail);
	
	public String getpWord();
	
	public void setpWord(String pWord);
	
	public boolean equals(User user);
	
	public boolean isExperienced();
	
	public void setExperienced(boolean experienced);
}
