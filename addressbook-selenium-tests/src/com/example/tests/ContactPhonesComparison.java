package com.example.tests;

import org.openqa.selenium.By;

import com.example.fw.ApplicationManager;
import com.example.fw.HelperBase;

public class ContactPhonesComparison extends HelperBase{

	public ContactPhonesComparison(ApplicationManager manager) {
		super(manager);
		manager.navigateTo().mainPage();
		String[] phones1 = getPhones();
	    
		System.out.println (phones1);
	}
	
	private String[] getPhones() {
		String[] phones1 = new String[6];
		phones1[1] = manager.driver.findElement(
		By.xpath(".//*[@id='maintable']/tbody/tr[2]/td[5]")).getText();
		phones1[2] = manager.driver.findElement(
	    By.xpath(".//*[@id='maintable']/tbody/tr[3]/td[5]")).getText();
		phones1[3] = manager.driver.findElement(
	    By.xpath(".//*[@id='maintable']/tbody/tr[4]/td[5]")).getText();
		phones1[4] = manager.driver.findElement(
		By.xpath(".//*[@id='maintable']/tbody/tr[5]/td[5]")).getText();
		phones1[5] = manager.driver.findElement(
	    By.xpath(".//*[@id='maintable']/tbody/tr[6]/td[5]")).getText();
		phones1[6] = manager.driver.findElement(
	    By.xpath(".//*[@id='maintable']/tbody/tr[7]/td[5]")).getText();
		return phones1;
		
	}

	public static void main(String[] args) {
		 

	}

}
