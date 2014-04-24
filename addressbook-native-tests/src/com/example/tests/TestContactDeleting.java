package com.example.tests;

import org.testng.annotations.Test;

public class TestContactDeleting extends TestBase{
	
	private Object contact;
	
	@Test
	public void shouldDeleteContact() {
    app.getContactHelper().getSelectSomeContact();
    app.getContactHelper().deleteContact(contact);
	}

}
