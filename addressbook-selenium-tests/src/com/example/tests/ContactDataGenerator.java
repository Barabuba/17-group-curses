package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		if (args.length < 3) {
			System.out.println("Specify parameters: <amount of test data> <file> <format>");
	        return;
		}
			int amount = Integer.parseInt(args[0]);
			File file = new File(args[1]);
			String format = args[2];
			
			if (file.exists()) {
				System.out.println("File exist, please remote it manually" + file);
				return;
			}
	  
			List<ContactData> contacts = generateRandonContacts(amount);
			if ("csv".equals(format)){
			saveContactsToCsvFile(contacts, file);	
			} else if ("xml".equals(format)) {
			saveContactsToXmlFile(contacts, file);
			} else {
				System.out.println("Unknown format" + format);
				return;
			}
		}

	private static void saveContactsToXmlFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
		}
	
		public static List<ContactData> loadContactsFromXmlFile(List<ContactData> contacts, File file) {
			XStream xstream = new XStream();
			xstream.alias("contact", ContactData.class);
			return (List<ContactData>) xstream.fromXML(file);
		}

		private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
			FileWriter writer = new FileWriter(file);
			for (ContactData contact : contacts) {
				writer.write(contact.getFirstname() + "," + contact.getLastname() + ",!" + "\n");
			}
			writer.close();
		}
		 
		public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
			List<ContactData> list = new ArrayList<ContactData>();
			FileReader reader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(reader);
			String line = bufferedReader.readLine();
			while (line != null) {
				String[] part = line.split(",");
				ContactData contact = new ContactData()
				.withFirstname(part[0])
				.withLastname(part[1]);
				list.add(contact);
			line = bufferedReader.readLine();
			}		
			bufferedReader.close();
			return list;
		}
			
		
		public static List<ContactData> generateRandonContacts(int amount) {
			List<ContactData> list = new ArrayList<ContactData>();
			for (int i = 0; i < amount; i++) {
				ContactData contact = new ContactData()
				.withFirstname("name" + generateRandomString2())
				.withLastname("lastname" + generateRandomString2())
				.withFirstaddress("firstaddress" + generateRandomString2())
				.withHomephone(generateRandomString2())
				.withMobilephone(generateRandomString2())
				.withWorkphone(generateRandomString2())
				.withEmail1("firstemail" + generateRandomString2())
				.withEmail2("secondemail" + generateRandomString2())
				.withDaydate("5")
				.withMonthname("May")
				.withYear("1995")
				.withChosengroup("group name 1")
				.withAddress2("secondaddress" + generateRandomString2())
				.withPhone2(generateRandomString2());
			    list.add(contact);
		    }
			return list;
		}
		public static String generateRandomString2() {
			Random rnd = new Random();
			if (rnd.nextInt(7) == 0) {
				return "";
			} else {
				return "" + Math.abs(rnd.nextInt());
			}	
		

	}

}