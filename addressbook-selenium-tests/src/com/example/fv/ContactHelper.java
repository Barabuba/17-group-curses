package com.example.fv;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

	public void fillContactForm(ContactData contact, boolean hasGroupSelector) {
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
	    if (hasGroupSelector) {
	    	//selectByText(By.name("new_group"), contact.chosengroup);
	    } else {
	    	if (driver.findElements(By.name("group name 1")).size() != 0) {
	    		throw new Error ("Group selector exist in modification form");
	    	}
	    }
	    
	    type (By.name("address2"),contact.address2);
	    type (By.name("phone2"),contact.phone2);
	  	}

	public void deleteContact() {
		click(By.xpath("(//input[@name='update'])[2]"));
		
	}

	public void initContactModification(int index) {
		click(By.xpath(".//*[@id='maintable']/tbody/tr[" + (index +1) + "]/td[7]/a"));
		
	}

	public void submitContactModification() {
		click(By.name("update"));
		
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> checkboxes = driver.findElements (By.name("selected[]"));
		for (int i = 0; i < checkboxes.size(); i++) {
			ContactData tempContact = new ContactData();
			tempContact.lastname = manager.driver.findElement(
			By.xpath(".//*[@id='maintable']/tbody/tr[" + (i + 2)
			+ "]/td[2]")).getText();
			tempContact.firstname = manager.driver.findElement(
			By.xpath(".//*[@id='maintable']/tbody/tr[" + (i + 2)
			+ "]/td[3]")).getText();
			contacts.add(tempContact);
			}
			return contacts;
			}
		
}