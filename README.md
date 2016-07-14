Agile CRM Java API 
=================

[Agile CRM] (https://www.agilecrm.com/) is a new breed CRM software with sales and marketing automation.

Table of contents
---------------

**[Requirements](#requirements)**

**[Installation](#installation)**

**[1 Contact](#1-contact)**
  * [1 To create a contact](#11-to-create-a-contact)
  * [2 To fetch contact data](#12-to-fetch-contact-data)
  * [3 To delete a contact](#13-to-delete-a-contact)
  * [4 To update a contact](#14-to-update-a-contact)
  * [5 Update lead score by ID](#15-update-lead-score-by-id)
  * [6 Update star value by ID](#16-update-star-value-by-id)
  * [7 Update tags value by ID](#17-update-tags-value-by-id)
  * [8 Delete tags value by ID](#18-delete-tags-value-by-id)
  * [9 Search contacts/companies](#19-search-contactscompanies)
  * [10 Adding tags to a contact based on email](#110-adding-tags-to-a-contact-based-on-email)
  * [11 Delete tags to a contact based on email](#111-delete-tags-to-a-contact-based-on-email)
  * [12 Add score to a contact using email ID](#112-add-score-to-a-contact-using-email-id)
  

**[2. Company](#2-company)**
  * [1 To create a company](#21-to-create-a-company)
  * [2 To update a company](#22-to-update-a-company)
 
**[3. Deal (Opportunity)](#3-deal)**
  * [1 To create a deal](#31-to-create-a-deal)
  * [2 To update a deal](#32-to-update-a-deal)
  * [3 Create deal to a contact using email ID](#33-create-deal-to-a-contact-using-email-id)
  * [4 Get list of deal](#34-get-list-of-deal)
  * [5 Get deal by ID](#35-get-deal-by-id)
  * [6 Delete deal by ID](#36-delete-deal-by-id)

**[4. Note ](#4-note)**
  * [1 Create a note and relate that to contacts](#41-create-a-note-and-relate-that-to-contacts)
  * [2 Add note to a contact using email ID](#42-add-note-to-a-contact-using-email-id)
  * [3 Gets notes related to specific contact](#43-gets-notes-related-to-specific-contact)
  * [4 Delete a specific note from specific contact](#44-delete-a-specific-note-from-specific-contact)
  * [5 Create note to a deal](#45-create-note-to-a-deal)
  * [6 Update note to a deal](#46-update-note-to-a-deal)
  * [7 Gets notes related to specific deal](#47-gets-notes-related-to-specific-deal)

Requirements
------------

1. Java 1.5 and later.

2. Setting Domain Name and Api Key

![Finding Domain name, email and api key] (https://raw.githubusercontent.com/agilecrm/c-sharp-api/master/AgileCRMapi.png)

In the above image, api key is present at the "Api & Analytics" tab at `https://mycompany.agilecrm.com/#account-prefs`.

So you have to update your `https://github.com/agilecrm/java-api/blob/master/AgileCRMJavaAPI/src/com/test/TestAgile.java`

	    String baseUrl = "https://{domain}.agilecrm.com/dev";
	    String userEmail = "your_user_email";
	    String restAPIKey = "***************************";

	    // Create a connection to Agile CRM

Installation
------------

Installation
============

We have all jars required for testing code in Lib folder.
You can manually download the following JARs or latest version compatible with each other:

* jersey-client-1.9.jar
* jersey-core-1.9.jar
* jersey-json-1.9.jar
* jackson-core-asl-1.9.2.jar
* jackson-mapper-asl-1.9.2.jar
* json.jar

Usage
=====

TestAgile.java

	package com.test;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.agilecrm.api.APIManager;
import com.agilecrm.api.ContactAPI;
import com.agilecrm.stubs.Contact;
import com.agilecrm.stubs.Contact.Type;
import com.agilecrm.stubs.ContactField.FieldName;

public class TestAgile
{
    public static void main(String[] args)
    {
	try
	{
	    String baseUrl = "https://{domain}.agilecrm.com/dev";
	    String userEmail = "your_email";
	    String restAPIKey = "your_rest_api";

	    // Create a connection to Agile CRM
	    APIManager apiManager = new APIManager(baseUrl, userEmail, restAPIKey);

	    // Get the Contact API with configured resource
	    ContactAPI contactApi = apiManager.getContactAPI();

	   // ------------------- Adding a person ----------------------------
	    Contact person1 = new Contact();

	    person1.setType(Type.PERSON);
	    person1.setLead_score(3);
	    person1.setContactField(FieldName.FIRST_NAME, "Annie");
	    person1.setContactField(FieldName.LAST_NAME, "Besant");
	    person1.setContactField(FieldName.ORGANIZATION, "London School Board");
	    person1.setContactField(FieldName.EMAIL, "annieds2@henry.com");
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
	    
	    // List of tags to add it to contact
	    List<String> tags;
	    
	    tags = new ArrayList<String>();
	    tags.add("developer");
	    tags.add("subscribe");
	    tags.add("connection");
	    person1.setTags(tags);

	    person1 = contactApi.addContact(person1);
	}
	catch (Exception e)
	{
	    System.out.println("Exception message.. " + e.getMessage());
	    e.printStackTrace();
	}
    }
}


See [TestContact.java](https://github.com/agilecrm/java-api/blob/master/AgileCRMJavaAPI/src/com/test/TestContact.java) for more examples.
