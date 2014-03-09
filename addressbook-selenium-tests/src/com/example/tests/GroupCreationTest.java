package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
    openMainPage();
    openGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData();
    group.name = "group name 1";
    group.header = "header 1";
    group.footer = "footer 1";
	fillGroupCreation(group);
    submitGroupCreation();
    returnToGroupsPage();
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
    openMainPage();
    openGroupsPage();
    initGroupCreation();
    fillGroupCreation(new GroupData("", "", ""));
    submitGroupCreation();
    returnToGroupsPage();
  }
}
