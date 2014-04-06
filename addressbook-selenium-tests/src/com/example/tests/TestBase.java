package com.example.tests;

import static com.example.tests.ContactDataGenerator.generateRandonContacts;
import static com.example.tests.GroupDataGenerator.generateRandonGroups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;


public class TestBase {
	
	protected static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
	app = new ApplicationManager();
	    
	 }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	    
	  }
	
	@DataProvider
	public Iterator<Object[]> randomValidGroupsGenerator() {
		return wrapGroupsForDataProvider(generateRandonGroups(5)).iterator();
	}
	
	public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group : groups) {
			list.add(new Object[]{group});
		}
		return list;
	}

	
	@DataProvider
	public Iterator<Object[]> randomValidContactsGenerator() {
		return wrapContactsForDataProvider(generateRandonContacts(5)).iterator();
	}
	
	public static List<Object[]> wrapContactsForDataProvider(List<ContactData> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (ContactData contact : contacts) {
			list.add(new Object[]{contact});
		}
		return list;
	}
		
}
