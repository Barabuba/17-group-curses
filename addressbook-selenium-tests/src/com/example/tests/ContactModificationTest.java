package com.example.tests;

import static com.example.fw.ContactHelper.MODIFICATION;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactModificationTest extends TestBase {
	
	@Test(dataProvider = "randomValidContactGenerator")
	
	public void modifySomeContact(ContactData contact) {
				
		 //save old state
		SortedListOf<ContactData> oldList = app.getModel().getContacts();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size());
	    
	    //actions
	    app.getContactHelper().contactModification(index, contact, MODIFICATION);
				
		//save new state
	    SortedListOf<ContactData> newList = app.getModel().getContacts();
	    
	    //compare states
	    assertThat (newList, equalTo(oldList.without(index).withAdded(contact)));
	   
	}

}
