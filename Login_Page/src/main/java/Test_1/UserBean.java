package Test_1;

import java.io.*;

@SuppressWarnings("serial")
public class UserBean implements Serializable

{
	private String uname,mid,pword,cmpy,city , ctry;
	private String phno;
	public  UserBean() {   }
	
	public String getUname() {
		return uname;
	}
	public String getCtry() {
		return ctry;
	}
	public void setCtry(String ctry) {
		this.ctry = ctry;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}
	public String getCmpy() {
		return cmpy;
	}
	public void setCmpy(String cmpy) {
		this.cmpy = cmpy;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}	
	
	

}
