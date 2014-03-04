package com.example.tests;

import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class contactLesson1 extends BaseLesson1 {


  @Test
  public void testNonEmptyContactCreation() throws Exception {
    openMainPage();
    initNewContactCreation();
    ContactData contact = new ContactData();
    contact.firstname = "firstname1";
    contact.lastname = "contact1";
    contact.address1 = "address11";
    contact.homephone = "000000";
    contact.mobilephone = "111111";
    contact.workphone = "222222";
    contact.email1 = "email11";
    contact.email2 = "email21";
    contact.daydate = "1";
    contact.month = "May";
    contact.year = "1990";
    contact.selectedgroup = "group name 1";
    contact.address2 = "address21";
    contact.phone2 = "333333";
	fillInContactForm(contact);
    submitContactCreation();
    returnToHomePage();
  }
  
  @Test
  public void testEmptyContactCreation() throws Exception {
    openMainPage();
    initNewContactCreation();
    submitContactCreation();
    returnToHomePage();
  }

private void returnToHomePage() {
	driver.findElement(By.linkText("home page")).click();
}

private void submitContactCreation() {
	driver.findElement(By.name("submit")).click();
}

private void fillInContactForm(ContactData contact) {
	driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys(contact.firstname);
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys(contact.lastname);
    driver.findElement(By.name("address")).clear();
    driver.findElement(By.name("address")).sendKeys(contact.address1);
    driver.findElement(By.name("home")).clear();
    driver.findElement(By.name("home")).sendKeys(contact.homephone);
    driver.findElement(By.name("mobile")).clear();
    driver.findElement(By.name("mobile")).sendKeys(contact.mobilephone);
    driver.findElement(By.name("work")).clear();
    driver.findElement(By.name("work")).sendKeys(contact.workphone);
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys(contact.email1);
    driver.findElement(By.name("email2")).clear();
    driver.findElement(By.name("email2")).sendKeys(contact.email2);
    new Select(driver.findElement(By.name("bday"))).selectByVisibleText(contact.daydate);
    new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(contact.month);
    driver.findElement(By.name("byear")).clear();
    driver.findElement(By.name("byear")).sendKeys(contact.year);
    new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contact.selectedgroup);
    driver.findElement(By.name("address2")).clear();
    driver.findElement(By.name("address2")).sendKeys(contact.address2);
    driver.findElement(By.name("phone2")).clear();
    driver.findElement(By.name("phone2")).sendKeys(contact.phone2);
}

private void initNewContactCreation() {
	driver.findElement(By.linkText("add new")).click();
  }
}


