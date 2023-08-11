package com.models;

public class Model {
      private String name;
      private String dob;
      private String usid;
      private String pwd;
      private String email;
      private long phone;
      private String utype;
    
	public void setName(String name) {
		this.name = name;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setUsid(String usid) {
		this.usid = usid;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public void setUtype(String utype) {
		this.utype = utype;
	}
	
	public String getName() {
		return name;
	}
	public String getDob() {
		return dob;
	}
	public String getUsid() {
		return usid;
	}
	public String getPwd() {
		return pwd;
	}
	public String getEmail() {
		return email;
	}
	public long getPhone() {
		return phone;
	}
	public String getUtype() {
		return utype;
	}
	
	@Override
	public String toString() {
		return "Model [name=" + name + ", dob=" + dob + ", usid=" + usid + ", pwd=" + pwd + ", email=" + email
				+ ", phone=" + phone + ", utype=" + utype +  "]";
	}
     
      
}
