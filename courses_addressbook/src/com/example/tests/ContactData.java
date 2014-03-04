package com.example.tests;

public class ContactData {
	
	public String firstname;
	public String lastname;
	public String address1;
	public String homephone;
	public String mobilephone;
	public String workphone;
	public String email1;
	public String email2;
	public String daydate;
	public String month;
	public String year;
	public String selectedgroup;
	public String address2;
	public String phone2;

	public ContactData() {
	}
	
	public ContactData(String firstname, String lastname, String address1,
			String homephone, String mobilephone, String workphone,
			String email1, String email2, String daydate, String month,
			String year, String selectedgroup, String address2, String phone2) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address1 = address1;
		this.homephone = homephone;
		this.mobilephone = mobilephone;
		this.workphone = workphone;
		this.email1 = email1;
		this.email2 = email2;
		this.daydate = daydate;
		this.month = month;
		this.year = year;
		this.selectedgroup = selectedgroup;
		this.address2 = address2;
		this.phone2 = phone2;
	}
}