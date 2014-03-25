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

	public GroupHelper submitGroupCreation() {
	click(By.name("submit"));
	return this;
	}

	public GroupHelper fillGroupCreation(GroupData group) {
		type(By.name("group_name"), group.getName());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
		return this;
	
	}

	public GroupHelper returnToGroupsPage() {
	click(By.linkText("group page"));
	return this;
	}

	public GroupHelper initGroupCreation() {
		click(By.name("new"));
		return this;
	}

	public GroupHelper deleteGroup(int index) {
		SelectGroupByIndex(index);
		click(By.name("delete"));
		return this;
	}

	private GroupHelper SelectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
		return this;
	}

	public GroupHelper initGroupModification(int index) {
		SelectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}

	public GroupHelper submitModification() {
		click(By.name("update"));
		return this;
	}

	public List<GroupData> getGroups() {
		List<GroupData> groups = new ArrayList<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");	
			String name = title.substring("Select (".length(), title.length() - ")".length());
			groups.add(new GroupData().withName(name));
		}
		return groups;
	 }
		
	}


