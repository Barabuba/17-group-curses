package com.example.tests;

public class ConactData {
	public String firstname;
	public String lastname;
	public String firstaddress;
	public String homephone;
	public String mobilephone;
	public String workphone;
	public String email1;
	public String email2;
	public String daydate;
	public String monthname;
	public String year;
	public String chosengroup;
	public String address2;
	public String phone2;

	public ConactData() {
		
	}
	
	public ConactData(String firstname, String lastname, String firstaddress,
			String homephone, String mobilephone, String workphone,
			String email1, String email2, String daydate, String monthname,
			String year, String chosengroup, String address2, String phone2) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.firstaddress = firstaddress;
		this.homephone = homephone;
		this.mobilephone = mobilephone;
		this.workphone = workphone;
		this.email1 = email1;
		this.email2 = email2;
		this.daydate = daydate;
		this.monthname = monthname;
		this.year = year;
		this.chosengroup = chosengroup;
		this.address2 = address2;
		this.phone2 = phone2;
	}
}