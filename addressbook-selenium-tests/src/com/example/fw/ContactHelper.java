package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends WebDriverHelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
		}
	
		
	//--------------------------High level methods-------------------------------------------------------------------------

	private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null) {
			rebuildCache();
		}
		return cachedContacts;
	}
		
	
	private void rebuildCache() {
		cachedContacts = new SortedListOf<ContactData>();
		
		manager.navigateTo().mainPage();
		List<WebElement> checkboxes = driver.findElements (By.name("selected[]"));
		for (int i = 0; i < checkboxes.size(); i++) {
			String lastname = manager.driver.findElement(
			By.xpath(".//*[@id='maintable']/tbody/tr[" + (i + 2)
			+ "]/td[2]")).getText();
			String firstname = manager.driver.findElement(
			By.xpath(".//*[@id='maintable']/tbody/tr[" + (i + 2)
			+ "]/td[3]")).getText();
			cachedContacts.add(new ContactData().withLastname(lastname).withFirstname(firstname));
			}
		
	}

	public ContactHelper contactCreation(ContactData contact, boolean cREATION2) {
		    manager.navigateTo().mainPage();
		    initContactCreation();
		    fillContactForm(contact, CREATION);
		    submitContactCreation();
		    returnToContactList();
		    rebuildCache();
		    return this;
	}
	
	public ContactHelper contactModification(int index, ContactData contact,
			boolean mODIFICATION2) {
		initContactModification(index);
		fillContactForm(contact, MODIFICATION);
		submitContactModification();
		returnToContactList();
		rebuildCache();
		return this;
		
	}
	
	public ContactHelper contactRemove(int index) {
		initContactModification(index);
		deleteContact();
		returnToContactList();
		rebuildCache();
		return this;
	}
	
	//--------------------------Low level methods-------------------------------------------------------------------------
	
	public ContactHelper initContactCreation() {
		click(By.linkText("add new"));
		return this;
	}
	
	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
	    type (By.name("firstname"),contact.getFirstname());
	    type (By.name("lastname"),contact.getLastname());
	    type (By.name("address"),contact.getFirstaddress());
	    type (By.name("home"),contact.getHomephone());
	    type (By.name("mobile"),contact.getMobilephone());
	    type (By.name("work"),contact.getWorkphone());
	    type (By.name("email"),contact.getEmail1());
	    type (By.name("email2"),contact.getEmail2());
	    selectByText(By.name("bday"), contact.getDaydate());
	    selectByText(By.name("bmonth"), contact.getMonthname());
	    type (By.name("byear"),contact.getYear());
	    if (formType == CREATION) {
	    	//selectByText(By.name("new_group"), contact.chosengroup);
	    } else {
	    	if (driver.findElements(By.name("group name 1")).size() != 0) {
	    		throw new Error ("Group selector exist in modification form");
	    	}
	    }
	    
	    type (By.name("address2"),contact.getAddress2());
	    type (By.name("phone2"),contact.getPhone2());
	    return this;
	  	}

	public ContactHelper returnToContactList() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
		return this;
	}
	
	public ContactHelper deleteContact() {
		click(By.xpath("(//input[@name='update'])[2]"));
		cachedContacts = null;
		return this;
	}

	public ContactHelper initContactModification(int index) {
		click(By.xpath(".//*[@id='maintable']/tbody/tr[" + (index +2) + "]/td[7]/a"));
		return this;
	}

	public ContactHelper submitContactModification() {
		click(By.name("update"));
		cachedContacts = null;
		return this;
	}

	
		
}