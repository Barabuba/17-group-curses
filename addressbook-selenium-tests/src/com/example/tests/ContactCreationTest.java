package com.example.tests;

import static com.example.fw.ContactHelper.CREATION;
import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.example.utils.SortedListOf;


public class ContactCreationTest extends TestBase {
	
	@DataProvider
	public Iterator<Object[]> contactsFromFile() throws IOException{
		return wrapContactsForDataProvider(loadContactsFromCsvFile(new File("contacts.txt"))).iterator();
	}


 @org.testng.annotations.Test(dataProvider = "contactsFromFile")
  public void ContactCreationWithValidData(ContactData contact) throws Exception {
        
    //save old state
	SortedListOf<ContactData> oldList 
	 = new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());
    
    //actions
    app.getContactHelper().contactCreation(contact, CREATION);
       
    //save new state
    SortedListOf<ContactData> newList 
    = new SortedListOf<ContactData>(app.getHibernateHelper().listContacts());
    
    //compare states
    assertThat (newList, equalTo(oldList.withAdded(contact)));
       
  }
  
 }



 
