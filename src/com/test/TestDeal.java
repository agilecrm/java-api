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
 * @author Tejaswi
 * @since March 2013
 * @see DealAPI
 * 
 */
public class TestDeal
{

    public static void main(String[] args)
    {
	try
	{
	    // Create a connection to Agile CRM
	    APIManager apiManager = AgileConnection.getConnection();

	    // Get the Deal API with configured resource
	    DealAPI dealApi = apiManager.getDealAPI();

	    // List of contact id's to which deals are related
	    List<String> contactIds = new ArrayList<String>();
	    contactIds.add("967");
	    contactIds.add("968");
	    contactIds.add("969");

	    // Adding deal
	    Deal deal1 = new Deal();

	    deal1.setMilestone("open");
	    deal1.setName("Test Deal1");
	    deal1.setProbability(50);
	    deal1.setExpected_value(738295723l);
	    deal1.setContact_ids(contactIds);

	    deal1 = dealApi.addDeal(deal1);

	    System.out.println("Added deal... " + deal1);

	    // other method to add deal
	    Deal deal2 = new Deal();

	    deal2 = dealApi.addDeal("Test Deal2", 67, 3682965l, "open");

	    System.out.println("Added deal... " + deal2);

	    // Relating deal to contacts
	    Deal deal3 = new Deal();

	    deal3 = dealApi.addDealToContacts("Test Deal3", 76, 36865l, "lost",
		    contactIds);

	    System.out.println("Added deal... " + deal3);

	    // Get all deals
	    List<Deal> deals = dealApi.getDeals();

	    System.out.println("All deals..." + deals);

	    // Get deal by id
	    deal1 = dealApi.getDealByDealId(String.valueOf(deal1.getId()));

	    System.out.println("Got deal..." + deal1);

	    // Update deal
	    deal1.setMilestone("won");
	    deal1.setExpected_value(54263532l);

	    deal1 = dealApi.updateDeal(deal1);

	    System.out.println("Updated deal..." + deal1);

	    // Delete deal
	    dealApi.deleteDealByDealId(String.valueOf(deal1.getId()));

	    // Bulk delete deals
	    List<String> dealIds = new ArrayList<String>();
	    dealIds.add(String.valueOf(deal2.getId()));
	    dealIds.add(String.valueOf(deal3.getId()));

	    dealApi.deleteDeals(dealIds);
	}
	catch (Exception e)
	{
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	}

    }

}
