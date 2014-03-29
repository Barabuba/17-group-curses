package com.example.tests;


import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

public class ContactRemovalTest extends TestBase {
	
	@Test
	
	public void deleteSomeContact() {
				
		//save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size()); 
	    
	    //actions
	    app.getContactHelper().contactRemove(index);
	    
		
		//save new state
	    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
	    
	    //compare states
	    assertThat (newList, equalTo(oldList.without(index)));
	   
	    
	  }
	
	

}
