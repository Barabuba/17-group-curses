package com.example.fv;

import org.openqa.selenium.By;

import com.example.tests.ConactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
		}

	public void returnToContactList() {
		click(By.name("submit"));
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void fillContactForm(ConactData contact) {
	    type (By.name("firstname"),contact.firstname);
	    type (By.name("lastname"),contact.lastname);
	    type (By.name("address"),contact.firstaddress);
	    type (By.name("home"),contact.homephone);
	    type (By.name("mobile"),contact.mobilephone);
	    type (By.name("work"),contact.workphone);
	    type (By.name("email"),contact.email1);
	    type (By.name("email2"),contact.email2);
	    selectByText(By.name("bday"), contact.daydate);
	    selectByText(By.name("bmonth"), contact.monthname);
	    type (By.name("byear"),contact.year);
	    selectByText(By.name("new_group"), contact.chosengroup);
	    type (By.name("address2"),contact.address2);
	    type (By.name("phone2"),contact.phone2);
	  	}

	public void initContactCreation() {
		click(By.name("submit"));
	}

}
