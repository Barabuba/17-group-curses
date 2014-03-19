package com.example.fv;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
	}

	public void initGroupModification(int index) {
		SelectGroupByIndex(index);
		click(By.name("edit"));
	}

	public void submitModification() {
		click(By.name("update"));
		
	}

	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			GroupData group = new GroupData();
			String title = checkbox.getAttribute("title");	
			group.name = title.substring("Select (".length(), title.length() - ")".length());
			groups.add(group);
		}
		return groups;
	 }
		
	}


