package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {
	
	@Test 
	
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModification(1);
		ContactData contact = new ContactData();
		contact.lastname = "Bat";
		app.getContactHelper().fillContactForm(contact);
		app.getGroupHelper().submitModification();
		app.getContactHelper().returnToContactList();
		
	}

}
