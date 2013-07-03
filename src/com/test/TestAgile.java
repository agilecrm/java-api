package com.test;

import java.util.List;

import com.agilecrm.api.APIManager;
import com.agilecrm.api.ContactAPI;
import com.agilecrm.stubs.Contact;

public class TestAgile
{
    public static void main(String[] args)
    {
	try
	{
	    String baseUrl = "https://<Your Domain>.agilecrm.com/dev";
	    String userName = "AgileCRM username";
	    String apiKey = "AgileCRM apikey";

	    // Create a connection to Agile CRM
	    APIManager apiManager = new APIManager(baseUrl, userName, apiKey);

	    // Get the Contact API with configured resource
	    ContactAPI contactApi = apiManager.getContactAPI();

	    // --------------------- Get contacts -----------------------------
	    List<Contact> contacts = contactApi.getContacts();
	    System.out.println("All contacts.. " + contacts);
	}
	catch (Exception e)
	{
	    System.out.println("Exception message.. " + e.getMessage());
	    e.printStackTrace();
	}
    }
}
