package com.example.tests;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

public class lesson1addressbook extends BaseLesson1 {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	  openMainPage();
      goToGroupsPage();
      initNewGroupCreation();
      GroupData group = new GroupData();
      group.name = "group name 1"; 
      group.header = "header 1";
      group.footer = "footer 1";
	  fillInGroupForm(group);
      submitGroupCreation();
      returnToGroupList();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	  openMainPage();
      goToGroupsPage();
      initNewGroupCreation();
      fillInGroupForm(new GroupData("", "", ""));
      submitGroupCreation();
      returnToGroupList();
  }

private void returnToGroupList() {
	    driver.findElement(By.linkText("group page")).click();
}

private void submitGroupCreation() {
	    driver.findElement(By.name("submit")).click();
}

private void fillInGroupForm(GroupData group) {
	    driver.findElement(By.name("group_name")).clear();
    driver.findElement(By.name("group_name")).sendKeys(group.name);
    driver.findElement(By.name("group_header")).clear();
    driver.findElement(By.name("group_header")).sendKeys(group.header);
    driver.findElement(By.name("group_footer")).clear();
    driver.findElement(By.name("group_footer")).sendKeys(group.footer);
}

private void initNewGroupCreation() {
	    driver.findElement(By.name("new")).click();
}

private void goToGroupsPage() {
	    driver.findElement(By.linkText("groups")).click();
}
}
