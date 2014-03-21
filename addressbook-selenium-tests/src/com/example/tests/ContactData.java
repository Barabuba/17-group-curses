package com.example.tests;

public class ContactData implements Comparable<ContactData> {
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
		return "ContactData [firstname=" + firstname + "]";
		}

	

	@Override
	public int hashCode() {
		final int prime = 31;
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
	
}