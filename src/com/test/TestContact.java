package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.agilecrm.api.APIManager;
import com.agilecrm.api.ContactAPI;
import com.agilecrm.stubs.Contact;
import com.agilecrm.stubs.Contact.Type;
import com.agilecrm.stubs.ContactField.FieldName;
import com.agilecrm.stubs.Tag;

/**
 * <code>TestContact</code> class contains main method to test all the methods
 * in <code>ContactAPI</code> class
 * 
 * @author Tejaswi
 * @since March 2013
 * @see ContactAPI
 * 
 */
public class TestContact
{

    public static void main(String[] args)
    {

	try
	{
	    // Create a connection to Agile CRM
	    APIManager apiManager = AgileConnection.getConnection();

	    // Get the Contact API with configured resource
	    ContactAPI contactApi = apiManager.getContactAPI();

	    // List of tags to add it to contact
	    List<String> tags;

	    // -------------------- Adding a company --------------------------
	    Contact company = new Contact();

	    company.setType(Type.COMPANY);
	    company.setContactField(FieldName.COMPANY, "AgileCRM");
	    company.setContactField(FieldName.URL, "http://www.agilecrm.com");

	    tags = new ArrayList<String>();
	    tags.add("Product based");
	    company.setTags(tags);

	    company = contactApi.addContact(company);

	    System.out.println("Added company... " + company);

	    // ------------------- Adding a person ----------------------------
	    Contact person1 = new Contact();

	    person1.setType(Type.PERSON);
	    person1.setLead_score(3);
	    person1.setContactField(FieldName.FIRST_NAME, "Test");
	    person1.setContactField(FieldName.LAST_NAME, "Add1");
	    person1.setContactField(FieldName.ORGANIZATION, "Agile");
	    person1.setContactField(FieldName.EMAIL, "test1@agilecrm.com");
	    person1.setContactField(FieldName.TITLE, "Software developer");
	    person1.setContactField(FieldName.PHONE, "+48624981");
	    person1.setContactField(FieldName.WEBSITE,
		    "http://agile-crm-cloud.appspot.com");
	    person1.setCustomField("Test", "Test Add Custom Field");

	    tags = new ArrayList<String>();
	    tags.add("developer");
	    person1.setTags(tags);

	    person1 = contactApi.addContact(person1);

	    System.out.println("Added person... " + person1);

	    // -------------- Another method to add person --------------------
	    Contact person2 = new Contact();

	    person2 = contactApi.addContact("Test", "Add2", "AgileCRM",
		    "test2@agilecrm.com", "Quality Analyst", "+1687621786",
		    "http://www.agilecrm.com");

	    System.out.println("Added person... " + person2);

	    // --------------------- Get contacts -----------------------------
	    List<Contact> contacts = contactApi.getContacts();

	    System.out.println("All contacts.." + contacts);

	    // ----------------- Get contact by contact id --------------------
	    Contact contact = new Contact();

	    contact = contactApi.getContact(String.valueOf(person2.getId()));

	    System.out.println("Got contact by id... " + contact);

	    // ---------------- Get contact from email ------------------------
	    contact = contactApi.getContactFromEmail("test1@agilecrm.com");

	    System.out.println("Got contact by email... " + contact);

	    // -------------------- update contact ----------------------------
	    contact.setContactField(FieldName.LAST_NAME, "Update1");

	    contact = contactApi.updateContact(contact);

	    System.out.println("updated contact... " + contact);

	    // --------------- update contact by id ----------------------------
	    Map<FieldName, String> contactFields = new HashMap<FieldName, String>();
	    contactFields.put(FieldName.TITLE, "software engineer");
	    contactFields.put(FieldName.LAST_NAME, "Update2");

	    // Adding custom fields to contact -----------------
	    Map<String, String> customFields = new HashMap<String, String>();
	    customFields.put("Test custom field", "Test");

	    contact = contactApi.updateContact(String.valueOf(person2.getId()),
		    contactFields, customFields);

	    System.out.println("updated contact... " + contact);

	    // ----------- Adding tags to contacts based on contact id's ------
	    tags = new ArrayList<String>();
	    tags.add("Professor");
	    tags.add("Consultant");
	    tags.add("Dealer");

	    List<String> contactIds = new ArrayList<String>();
	    contactIds.add(String.valueOf(person1.getId()));
	    contactIds.add(String.valueOf(person2.getId()));

	    contactApi.addTagsToContacts(tags, contactIds);

	    System.out.println("Added tags to contact ids............");

	    // ------------ Adding tag to contact based on email -------------
	    Tag tag = new Tag();
	    tag.setTag("CEO");

	    contactApi.addTagsToEmail(tag, "test2@agilecrm.com");

	    System.out.println("Added tag based on email..............");

	    // ------------ delete contact by contact id --------------------
	    contactApi.deleteContact(String.valueOf(person2.getId()));

	    // ------------- delete bulk contacts ------------------------
	    contactIds = new ArrayList<String>();
	    contactIds.add(String.valueOf(person1.getId()));
	    contactIds.add(String.valueOf(company.getId()));

	    contactApi.deleteBulkContacts(contactIds);
	}
	catch (Exception e)
	{
	    System.out.println("message" + e.getMessage());
	    e.printStackTrace();
	}
    }
}
