Agile CRM Java API 
=================

[Agile CRM] (https://www.agilecrm.com/) is a new breed CRM software with sales and marketing automation.

Table of contents
---------------

**[Requirements](#requirements)**

**[Installation](#installation)**

**[Reference](#reference)**

**[Usage](#usage)**

**[Video Example using Java](#create-contact)**

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

```javascript
package com.test;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.agilecrm.api.APIManager;
import com.agilecrm.api.ContactAPI;
import com.agilecrm.stubs.Contact;
import com.agilecrm.stubs.Contact.Type;
package com.test;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.agilecrm.api.APIManager;
import com.agilecrm.api.ContactAPI;
import com.agilecrm.stubs.Contact;
import com.agilecrm.stubs.Contact.Type;
import com.agilecrm.stubs.ContactField.FieldName;

public class TestAgile {
    public static void main(String[] args) {
	try {
	    String baseUrl = "https://{your_domain}.agilecrm.com/dev";
	    String userEmail = "ghanshyam@.....";
	    String restAPIKey = "your_rest_key";

	    // Create a connection to Agile CRM
	    APIManager apiManager = new APIManager(baseUrl, userEmail,
		    restAPIKey);

	    // Get the Contact API with configured resource
	    ContactAPI contactApi = apiManager.getContactAPI();

	    // ------------------- Adding a person ----------------------------
	    Contact person1 = new Contact();

	    person1.setType(Type.PERSON);
	    person1.setLead_score(3);
	    person1.setContactField(FieldName.FIRST_NAME, "Annie");
	    person1.setContactField(FieldName.LAST_NAME, "Besant");
	    person1.setContactField(FieldName.ORGANIZATION,
		    "London School Board");
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

	    // person1 = contactApi.addContact(person1);

	    // Update a contact
	    // ------------------- Update Contact properties
	    // ---------------------
	    String contactDeailJson = "{\"id\":5745111329669120, "
		    + "\"properties\":["
		    + " {\"type\":\"SYSTEM\", \"name\":\"first_name\", \"value\":\"Jason\"}, "
		    + " {\"type\":\"SYSTEM\", \"name\":\"address\", \"value\":'{\"address\":\"225 George Street\",\"city\":\"NSW\",\"state\":\"Sydney\",\"zip\":\"2000\",\"country\":\"Australia\"}'},"
		    + "{\"type\":\"CUSTOM\", \"name\":\"My custom field of type date\", \"value\":\"1481871525\"}]}";

	    contactApi.updateContactPartialUpdate(contactDeailJson);

	    // ---------Get contacts by filter field------------------
	    // pass type of filter,filter value,page_size,cursor
	    // contactApi.getContactsByDynamicFilter("tags","Lead","5","first_page");

	    // Get list of contacts based on page size and cursor
	    // contactApi.getContacts("10","first_page");

	} catch (Exception e) {
	    System.out.println("Exception message.. " + e.getMessage());
	    e.printStackTrace();
	}
    }
}
```

See [TestContact.java](https://github.com/agilecrm/java-api/blob/master/AgileCRMJavaAPI/src/com/test/TestContact.java) for more examples.

Reference
------------

See [Agile CRM Rest API](https://github.com/agilecrm/java-api/blob/master/AgileCRMJavaAPI/src/com/test/TestContact.java) for more information.


###Create contact:

<a href="https://www.youtube.com/watch?v=-xRqEJvMjfI&feature=youtu.be" target="_blank"><img src="https://github.com/agilecrm/rest-api/blob/master/api/createContact.PNG" 
alt="IMAGE ALT TEXT HERE" width="440" height="180" border="10" /></a>
