package org.fzl.dto;

import java.sql.Date;

public class EmployeeDTO {

	private int id;
	private String fName;
	private String lName;
	private String gender;
	private String mStatus;
	private Date dob;
	private String email;
	private String password;
	private long phNum;
	private String degn;
	
	
	//setter & getter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getmStatus() {
		return mStatus;
	}
	public void setmStatus(String mStatus) {
		this.mStatus = mStatus;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getPhNum() {
		return phNum;
	}
	public void setPhNum(long phNum) {
		this.phNum = phNum;
	}
	public String getDegn() {
		return degn;
	}
	public void setDegn(String degn) {
		this.degn = degn;
	}
	
	// toString
	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", fName=" + fName + ", lName=" + lName + ", gender=" + gender + ", mStatus="
				+ mStatus + ", dob=" + dob + ", email=" + email + ", password=" + password + ", phNum=" + phNum
				+ ", degn=" + degn + "]";
	}
	
	
}//class
