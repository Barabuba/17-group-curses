package com.example.tests;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class ContactCreationTest extends TestBase {


  @org.testng.annotations.Test
  public void NonEmptyContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    
    //save old state
    List<ContactData> oldList = app.getContactHelper().getContacts();
    
    //actions
    
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
	contact.firstname = "Josh";
	contact.lastname = "Jackson";
	contact.firstaddress = "address1";
	contact.homephone = "111111";
	contact.mobilephone = "222222";
	contact.workphone = "333333";
	contact.email1 = "email1@";
	contact.email2 = "email2@";
	contact.daydate = "5";
	contact.monthname = "May";
	contact.year = "1995";
	contact.chosengroup = "group name 1";
	contact.address2 = "address2";
	contact.phone2 = "444444";
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToContactList();
    
    //save new state
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare states
    assertEquals(newList.size(), oldList.size() + 1);
    
    oldList.add(contact);
    Collections.sort(oldList);
    assertEquals(newList, oldList);
    
  }
  
  //@org.testng.annotations.Test
  public void EmptyContactCreation() throws Exception {
    app.getNavigationHelper().openMainPage();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToContactList();
  }
}



 
