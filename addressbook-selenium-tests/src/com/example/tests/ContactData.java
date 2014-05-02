package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String id;
	private String firstname;
	private String lastname;
	private String firstaddress;
	private String homephone;
	private String mobilephone;
	private String workphone;
	private String email1;
	private String email2;
	private String daydate;
	private String monthname;
	private String year;
	private String chosengroup;
	private String address2;
	private String phone2;

	public ContactData() {
		
	}
	
	public ContactData(String firstname, String lastname, String firstaddress,
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

	
	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + ", lastname=" + lastname
				+ "]";
	}

	@Override
	public int hashCode() {
		//final int prime = 31;
		int result = 1;
		//result = prime * result
				//+ ((firstname == null) ? 0 : firstname.hashCode());
		//result = prime * result
				//+ ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	 @Override
	 public int compareTo(ContactData other) {
	 //return this.contactsName.toLowerCase().compareTo(
	 //other.contactsName.toLowerCase());

	 int firstnameComparison = this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase());
	 int lastnameComparison = this.lastname.toLowerCase().compareTo(other.lastname.toLowerCase());

	 if (lastnameComparison != 0) {
	 return lastnameComparison;
	 }
	 else{
	 return firstnameComparison;
	 }
	 }

	 public ContactData withId(String id) {
			this.id = id;
			return this;
		}
	 
	public void setId(String id) {
			this.id = id;
		}
		
	public String getId() {
			return id;
		}
		
	public ContactData withFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setFirstaddress(String firstaddress) {
		this.firstaddress = firstaddress;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public void setWorkphone(String workphone) {
		this.workphone = workphone;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public void setDaydate(String daydate) {
		this.daydate = daydate;
	}

	public void setMonthname(String monthname) {
		this.monthname = monthname;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setChosengroup(String chosengroup) {
		this.chosengroup = chosengroup;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public ContactData withLastname(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public ContactData withFirstaddress(String firstaddress) {
		this.firstaddress = firstaddress;
		return this;
	}

	public ContactData withHomephone(String homephone) {
		this.homephone = homephone;
		return this;
	}

	public ContactData withMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
		return this;
	}

	public ContactData withWorkphone(String workphone) {
		this.workphone = workphone;
		return this;
	}

	public ContactData withEmail1(String email1) {
		this.email1 = email1;
		return this;
	}
	
	public ContactData withEmail2(String email2) {
		this.email2 = email2;
		return this;
	}

	public ContactData withDaydate(String daydate) {
		this.daydate = daydate;
		return this;
	}

	public ContactData withMonthname(String monthname) {
		this.monthname = monthname;
		return this;
	}

	public ContactData withYear(String year) {
		this.year = year;
		return this;
	}

	public ContactData withChosengroup(String chosengroup) {
		this.chosengroup = chosengroup;
		return this;
	}

	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getFirstaddress() {
		return firstaddress;
	}

	public String getHomephone() {
		return homephone;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public String getWorkphone() {
		return workphone;
	}

	public String getEmail1() {
		return email1;
	}

	public String getEmail2() {
		return email2;
	}

	public String getDaydate() {
		return daydate;
	}

	public String getMonthname() {
		return monthname;
	}

	public String getYear() {
		return year;
	}

	public String getChosengroup() {
		return chosengroup;
	}

	public String getAddress2() {
		return address2;
	}

	public String getPhone2() {
		return phone2;
	}
	
}