Agile CRM Java API 
=================

[Agile CRM] (https://www.agilecrm.com/) is a new breed CRM software with sales and marketing automation.

Requirements
============
Java 1.5 and later.


Installation
============
You can manually download the following JARs:

	http://www.java2s.com/Code/Jar/j/Downloadjerseyclient115jar.htm
	http://www.java2s.com/Code/Jar/j/Downloadjsonjar.htm
	http://www.java2s.com/Code/Jar/j/Downloadjacksoncoreasl192jar.htm

* jersey-client-1.15.jar
* jersey-core-1.15.jar
* jersey-json-1.15.jar
* jackson-core-asl-1.9.2.jar
* jackson-mapper-asl-1.9.2.jar
* json.jar

Usage
=====

TestAgile.java

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

See [TestContact.java](https://github.com/agilecrm/java-api/blob/master/src/com/test/TestContact.java) for more examples.
