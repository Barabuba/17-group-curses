package com.example.fv;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
		}
	
	public void initContactCreation() {
		click(By.linkText("add new"));
	}


	public void returnToContactList() {
		click(By.linkText("home page"));
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void fillContactForm(ContactData contact) {
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

	public void deleteContact() {
		click(By.xpath("(//input[@name='update'])[2]"));
		
	}

	public void initContactModification(int index) {
		click(By.xpath("//input[@name='selected[]'][" + index + "]"));
		click(By.cssSelector("img[alt=\"Edit\"]"));
		
	}

	public void submitContactModification() {
		click(By.name("update"));
		
	}
		
}