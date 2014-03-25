package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fv.ApplicationManager;


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
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			GroupData group = new GroupData()
			.withName(generateRandomString())
			.withHeader(generateRandomString())
			.withFooter(generateRandomString());
		    list.add(new Object[]{group});
	    }
		return list.iterator();
	}
	
	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}	
	}
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List <Object[]> list = new ArrayList<Object[]>();
			for (int i = 0; i < 2; i++){
			ContactData contact = new ContactData();
			contact.firstname = generateRandomString2();
			contact.lastname = generateRandomString2();
			contact.firstaddress = generateRandomString2();
			contact.homephone = generateRandomString2();
			contact.mobilephone = generateRandomString2();
			contact.workphone = generateRandomString2();
			contact.email1 = generateRandomString2();
			contact.email2 = generateRandomString2();
			contact.daydate = "5";
			contact.monthname = "May";
			contact.year = "1995";
			contact.chosengroup = "group name 1";
			contact.address2 = generateRandomString2();
			contact.phone2 = generateRandomString2();
			list.add(new Object[]{contact});
		}
		//....
		return list.iterator();
	}
	
	public String generateRandomString2(){
		Random rnd = new Random();
		if (rnd.nextInt(7) == 0) {
			return "";
		}else {
			return "testdata" + rnd.nextInt();
				
		}
		
	}
}
