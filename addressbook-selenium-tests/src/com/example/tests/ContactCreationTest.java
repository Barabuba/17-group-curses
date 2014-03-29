package com.example.tests;

import static com.example.fw.ContactHelper.CREATION;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import com.example.utils.SortedListOf;


public class ContactCreationTest extends TestBase {
	
	


  @org.testng.annotations.Test(dataProvider = "randomValidContactGenerator")
  public void ContactCreationWithValidData(ContactData contact) throws Exception {
        
    //save old state
	SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
    
    //actions
    app.getContactHelper().contactCreation(contact, CREATION);
       
    //save new state
    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
    
    //compare states
    assertThat (newList, equalTo(oldList.withAdded(contact)));
       
  }
  
 }



 
