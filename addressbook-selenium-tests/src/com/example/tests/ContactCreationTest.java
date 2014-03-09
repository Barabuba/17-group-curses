package com.example.tests;


public class ContactCreationTest extends TestBase {


  @org.testng.annotations.Test
  public void NonEmptyContactCreation() throws Exception {
    openMainPage();
    initContactCreation();
    ConactData contact = new ConactData();
	contact.firstname = "Jack";
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
	contact.chosengroup = "group 1";
	contact.address2 = "address2";
	contact.phone2 = "444444";
    fillContactForm(contact);
    submitContactCreation();
    returnToContactList();
  }
  
  @org.testng.annotations.Test
  public void EmptyContactCreation() throws Exception {
    openMainPage();
    initContactCreation();
    submitContactCreation();
    returnToContactList();
  }
}



 
