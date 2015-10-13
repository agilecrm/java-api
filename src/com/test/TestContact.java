package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

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
 * @author Ghanshyam
 * @since October 2013
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
	    company.setContactField(FieldName.COMPANY, "ClickDesk");
	    company.setContactField(FieldName.URL, "https://www.clickdesk.com");

	    tags = new ArrayList<String>();
	    tags.add("Product based");
	    tags.add("Service based");
	    company.setTags(tags);

	    company = contactApi.addContact(company);

	    System.out.println("Added company... " + company);
	    
	    // -------------------- Adding a company end ------------------------

	    // ------------------- Adding a person ----------------------------
	    Contact person1 = new Contact();

	    person1.setType(Type.PERSON);
	    person1.setLead_score(3);
	    person1.setContactField(FieldName.FIRST_NAME, "Annie");
	    person1.setContactField(FieldName.LAST_NAME, "Besant");
	    person1.setContactField(FieldName.ORGANIZATION, "London School Board");
	    person1.setContactField(FieldName.EMAIL, "annie@henry.com");
	    person1.setContactField(FieldName.TITLE, "socialist");
	    person1.setContactField(FieldName.PHONE, "+48624981");
	    person1.setContactField(FieldName.WEBSITE,
		    "http://agile-crm-cloud.appspot.com");
	    JSONObject address = new JSONObject();
	    address.put("city", "Clapham");
	    address.put("state", "London");
	    address.put("country", "United Kingdom");
	    person1.setContactField(FieldName.ADDRESS, address.toString());
	    
	    person1.setCustomField("Date Of Joining", "Test Add Custom Field");
	    
	    tags = new ArrayList<String>();
	    tags.add("developer");
	    tags.add("subscribe");
	    tags.add("connection");
	    person1.setTags(tags);

	    person1 = contactApi.addContact(person1);

	    System.out.println("Added person... " + person1);

	   // -------------- Another method to add person --------------------
	    Contact person2 = new Contact();

	    person2 = contactApi.addContact("Fname_Mark", "Lname_Henry", "AgileCRM",
		    "mark@henry.com", "boxer", "+1687621786",
		    "http://www.wwe.com");

	    System.out.println("Added person... " + person2);
	    
	    // ------------------- Adding a person end--------------------------

	    // --------------------- Get contacts -----------------------------
	     List<Contact> contacts = contactApi.getContacts();

	    System.out.println("All contacts.." + contacts);
	    
	    // ----------------- Get contact by contact id --------------------
	    Contact contact = new Contact();

	    contact = contactApi.getContact(String.valueOf(person2.getId()));

	    System.out.println("Got contact by id... " + contact);

	    // ---------------- Get contact from email ------------------------
	    Contact contact1 = contactApi.getContactFromEmail("annie@henry.com");

	    System.out.println("Got contact by email... " + contact1);

	    // -------------------- update contact ----------------------------
	    // Note : here first we are getting contact by email or id and then 
	    // updating only required filed like last name, score and one custom field
	    contact1.setContactField(FieldName.LAST_NAME, "Besant1");
	    contact1.setLead_score(5);
	    contact1.setCustomField("Date Of Joining", "Test Add Custom Field3");//Text filed example
	    contact1.setCustomField("DOP","1444632846"); // Epoch time in second, Date field example

	    contact1 = contactApi.updateContact(contact1);

	    System.out.println("updated contact... " + contact1);

	    // ------------ Adding tag to contact based on email -------------
	    Tag tag = new Tag();
	    tags = new ArrayList<String>();
	    tags.add("alfa1");
	    tags.add("alfa2");
	    tags.add("alfa3");
	    tag.setTags(tags);
	    

	    contactApi.addTagsToEmail(tag, "mark@henry.com");

	    System.out.println("Added tag based on email..............");
	    
	    // ---------Delete tags to contact based on email ------------------
	    Tag tag1 = new Tag();
	    tags = new ArrayList<String>();
	    tags.add("alfa2");
	    tags.add("alfa4");
	    tag1.setTags(tags);
		contactApi.deleteTags(tag1, "mark@henry.com");
		System.out.println("Delete tag based on email..............");

	    // ------------ delete contact by contact id --------------------
	    contactApi.deleteContact("5170081277411328");

	    // ------------- delete bulk contacts ------------------------
	    List<String> contactIds;
	    contactIds = new ArrayList<String>();
	    contactIds.add("5655368558444544");
	    contactIds.add("5769320147714048");

	    contactApi.deleteBulkContacts(contactIds);

	    // ---------Add Score to a Contact using Email-ID------------------
	 	contactApi.addScoreToEmail("5", "mark@henry.com");
	 	System.out.println("Addedd score based on email..............");
	}
	catch (Exception e)
	{
	    System.out.println("message" + e.getMessage());
	    e.printStackTrace();
	}
    }
}
