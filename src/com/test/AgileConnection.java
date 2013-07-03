package com.test;

import com.agilecrm.api.APIManager;

/**
 * <code>AgileConnection</code> contains method to create and test connection
 * with Agile CRM
 * 
 * @author Tejaswi
 * @since March 2013
 * @see APIManager
 * 
 */
public class AgileConnection
{

    /**
     * Creates a connection to the Agile CRM and configures the resource in
     * {@link APIManager} class
     * 
     * @return Instance of {@link APIManager}
     * @throws Exception
     */
    public static APIManager getConnection() throws Exception
    {
	String baseUrl = "https://<yourdomain>.agilecrm.com/dev";
	String userName = "AgileCRM username";
	String apiKey = "AgileCRM apikey";

	// Configures a resource with AGILE CRM credentials
	APIManager apiManager = new APIManager(baseUrl, userName, apiKey);

	return apiManager;
    }

    public static void main(String[] args)
    {
	try
	{
	    AgileConnection.getConnection();
	}
	catch (Exception e)
	{
	    System.out.println("Exception " + e.getMessage());
	}
    }
}
