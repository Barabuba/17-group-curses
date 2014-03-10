package com.example.fv;

import org.openqa.selenium.By;

import com.example.tests.GroupData;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
		}

	public void submitGroupCreation() {
	click(By.name("submit"));
	}

	public void fillGroupCreation(GroupData group) {
		type(By.name("group_name"), group.name);
		type(By.name("group_header"), group.header);
		type(By.name("group_footer"), group.footer);
	
	}

	public void returnToGroupsPage() {
	click(By.linkText("group page"));
	}

	public void initGroupCreation() {
		click(By.name("new"));
	}

	public void deleteGroup(int index) {
		SelectGroupByIndex(index);
		click(By.name("delete"));
		
	}

	private void SelectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + index + "]"));
	}

	public void initGroupModification(int index) {
		SelectGroupByIndex(index);
		click(By.name("edit"));
	}

	public void submitGroupModification() {
		click(By.name("update"));
		
	}

}
