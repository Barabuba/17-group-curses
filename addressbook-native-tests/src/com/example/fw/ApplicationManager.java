package com.example.fw;

import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {
	

	private ContactHelper contactHelper;
	private Properties properties;

	private Object processHelper;
	private AutoItHelper autoItHelper;


	
	public ApplicationManager(Properties properties) {
	this.properties = properties;
	}
	
	public void start() throws IOException {
		getProcessHelper().startAppUnderTest();	
	 }
	
	public void stop() {
		getProcessHelper().stopAppUnderTest();	
	 }
	
	public void setProperties(Properties properties) {
	this.properties = properties;	
	}
	
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
	
	public String getProperty(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}

	public ContactHelper getContactHelper() {
		if (contactHelper == null) {
			contactHelper = new ContactHelper(this);
		}
		return (ContactHelper) contactHelper;
	}
	
	public ProcessHelper getProcessHelper() {
		if (processHelper == null) {
			processHelper = new ProcessHelper(this);
		}
		return (ProcessHelper) processHelper;
	}

public AutoItHelper getAutoItHelper() {
	if (autoItHelper == null) {
		autoItHelper = new AutoItHelper(this);
	}
	return (AutoItHelper) autoItHelper;
}


}
	
	
	

	


