package com.test;

import java.util.ArrayList;
import java.util.List;

import com.agilecrm.api.APIManager;
import com.agilecrm.api.DealAPI;
import com.agilecrm.stubs.Deal;

/**
 * <code>TestDeal</Code> class contains main method to test all the methods in
 * <code>DealAPI</code> class
 * 
 * @author Ghanshyam
 * @since October 2015
 * @see DealAPI
 * 
 */
public class TestDeal
{

    public static void main(String[] args)
    {
	try
	{
	    String baseUrl = "https://ghanshyam.agilecrm.com/dev";
	    String userEmail = "ghanshyam.raut@agilecrm.com";
	    String restAPIKey = "***************************";

	    // Create a connection to Agile CRM
	    APIManager apiManager = new APIManager(baseUrl, userEmail, restAPIKey);

	    // Get the Deal API with configured resource
	    DealAPI dealApi = apiManager.getDealAPI();

	    // List of contact id's to which deals are related
	    List<String> contactIds = new ArrayList<String>();
	    contactIds.add("5749152860340224");
	    contactIds.add("5167711998967808"); // Adding Deal to two contact
						// ids

	    // Adding deal

	    Deal deal1 = new Deal();
	    deal1.setMilestone("New");
	    // Milestone name should be exactly like in website
	    // Example https://{domain}.agilecrm.com/#milestones
	    deal1.setName("Test Deal1");
	    deal1.setProbability(50);
	    deal1.setExpected_value(Double.valueOf("600")); // Epoch time in
							    // second
	    deal1.setContact_ids(contactIds);

	    deal1 = dealApi.addDeal(deal1);

	    System.out.println("Added deal... " + deal1);

	    // Get all deals
	    List<Deal> deals1 = dealApi.getDeals();

	    System.out.println("All deals..." + deals1);

	    // Get deal by id

	    Deal deal3 = dealApi.getDealByDealId("5705327416705024");

	    System.out.println("Got deal..." + deal3);

	    // Update deal

	    deal3.setMilestone("Prospect");
	    deal3.setExpected_value(Double.valueOf("90"));

	    System.out.println("Deal before updating" + deal3);
	    Deal updatedDeal = dealApi.updateDeal(deal3);

	    System.out.println("Updated deal..." + updatedDeal);

	    // Delete deal
	    dealApi.deleteDealByDealId("5069845766864896");
	    System.out.println("Dela is deleted successfully");

	    // Bulk delete deals
	    List<String> dealIds = new ArrayList<String>();
	    dealIds.add("5141023978160128");
	    dealIds.add("5631930015940608");
	    dealIds.add("5633226290757632");

	    dealApi.deleteDeals(dealIds);
	    System.out.println("Three deal deleted successfully");
	}
	catch (Exception e)
	{
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	}

    }
}
