package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends WebDriverHelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
		}
	
	//--------------------------High level methods-------------------------------------------------------------------------
	
	

	public SortedListOf<GroupData> getUiGroups() {
		SortedListOf<GroupData> groups = new SortedListOf<GroupData>();
			
			manager.navigateTo().groupsPage();
			List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
			for (WebElement checkbox : checkboxes) {
				String title = checkbox.getAttribute("title");	
				String name = title.substring("Select (".length(), title.length() - ")".length());
				groups.add(new GroupData().withName(name));
			}
			return groups;		
		}
	
	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupCreation();
		fillGroupCreation(group);
		submitGroupCreation();
		returnToGroupsPage();
		//update model
		manager.getModel().addGroup(group);
		return this;
	}
	
	public GroupHelper modifyGroup(int index, GroupData group) {
	    initGroupModification(index); 
		fillGroupCreation(group);
		submitGroupModification();
		returnToGroupsPage();
		manager.getModel().removeGroup(index).addGroup(group);
		return this;
	}
	
	public GroupHelper deleteGroup(int index) {
		SelectGroupByIndex(index);
		submitGroupDeletion();
		returnToGroupsPage();
		manager.getModel().removeGroup(index);
		return this;
	}

		
	//--------------------------Low level methods-------------------------------------------------------------------------
	
	
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

	
	private GroupHelper SelectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
		return this;
	}

	public GroupHelper initGroupModification(int index) {
		SelectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}
	
	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		return this;
		}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		return this;
	}

	private void submitGroupDeletion() {
		click(By.name("delete"));
	}
			
}


