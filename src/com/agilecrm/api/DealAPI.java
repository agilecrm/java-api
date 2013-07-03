package com.agilecrm.api;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.agilecrm.stubs.Deal;
import com.agilecrm.stubs.DealCollection;
import com.agilecrm.utils.StringUtils;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

/**
 * <code>DealAPI</code> class contains methods to add, get, update and delete
 * deals from Agile CRM
 * 
 * @author Tejaswi
 * @since March 2013
 * @see APIManager
 */
public class DealAPI
{
    /**
     * Holds a {@link WebResource} object
     */
    private final WebResource resource;

    /**
     * Initializes the field resource with the configured resource from
     * {@link APIManager}
     * 
     * @param resource
     *            {@link WebResource}
     */
    DealAPI(WebResource resource)
    {
	this.resource = resource;
    }

    /**
     * Adds a deal to Agile CRM with the given {@link Deal} object
     * 
     * @param deal
     *            {@link Deal} to be added
     * @return Added {@link Deal}
     * @throws Exception
     */
    public Deal addDeal(Deal deal) throws Exception
    {
	System.out.println("Adding deal ----------------------------------");

	if (deal == null)
	{
	    throw new Exception("Cannot create a deal without a Deal object");
	}

	deal = resource.path("/api/opportunity")
		.accept(MediaType.APPLICATION_XML).post(Deal.class, deal);

	return deal;
    }

    /**
     * Adds a deal to Agile CRM with the given parameters
     * 
     * @param dealName
     *            {@link String} name of the {@link Deal}
     * @param probability
     *            {@link Integer} probability value of the {@link Deal}
     * @param dealValue
     *            {@link String} value of the {@link Deal}
     * @param mileStone
     *            {@link String} milestone of the {@link Deal}
     * @return Added {@link Deal}
     * @throws Exception
     */
    public Deal addDeal(String dealName, Integer probability, Long dealValue,
	    String mileStone) throws Exception
    {
	System.out.println("Adding deal ----------------------------------");

	if (StringUtils.isNullOrEmpty(new String[] { dealName }))
	    throw new Exception("Please specify name of the deal");

	Deal deal = new Deal();
	deal.setName(dealName);
	deal.setProbability(probability);
	deal.setExpected_value(dealValue);

	if (mileStone != null)
	    deal.setMilestone(mileStone);
	else
	    deal.setMilestone("open");

	deal = resource.path("/api/opportunity")
		.accept(MediaType.APPLICATION_XML).post(Deal.class, deal);

	return deal;
    }

    /**
     * Adds a deal to Agile CRM with the given parameters and relates it to the
     * given list of contact id's.
     * 
     * @param dealName
     *            {@link String} name of the {@link Deal}
     * @param probability
     *            {@link Integer} probability value of the {@link Deal}
     * @param dealValue
     *            {@link String} value of the {@link Deal}
     * @param mileStone
     *            {@link String} milestone of the {@link Deal}
     * @param contactIds
     *            {@link List} of {@link String} contact id's to be related to
     *            {@link Deal}
     * @return Added {@link Deal}
     * @throws Exception
     */
    public Deal addDealToContacts(String dealName, Integer probability,
	    Long dealValue, String mileStone, List<String> contactIds)
	    throws Exception
    {
	System.out.println("Adding deal ----------------------------------");

	if (StringUtils.isNullOrEmpty(contactIds))
	    throw new Exception("Please specify contact ids related to deal");

	Deal deal = new Deal();
	deal.setName(dealName);
	deal.setProbability(probability);
	deal.setExpected_value(dealValue);
	deal.setContact_ids(contactIds);

	if (mileStone != null)
	    deal.setMilestone(mileStone);
	else
	    deal.setMilestone("open");

	deal = resource.path("/api/opportunity")
		.accept(MediaType.APPLICATION_XML).post(Deal.class, deal);

	return deal;
    }

    /**
     * Retrieves all deals from agents Agile CRM account
     * 
     * @return {@link List} of {@link Deal}
     * @throws Exception
     */
    public List<Deal> getDeals()
    {
	System.out.println("Getting deals --------------------------------");

	DealCollection dealCollection = resource.path("/api/opportunity")
		.accept(MediaType.APPLICATION_XML).get(DealCollection.class);

	return dealCollection.getDeals();
    }

    /**
     * Retrieves the {@link Deal} from Agile CRM based on its Id
     * 
     * @param dealId
     *            {@link String} id of the {@link Deal}
     * @return {@link Deal}
     * @throws Exception
     */
    public Deal getDealByDealId(String dealId) throws Exception
    {
	System.out.println("Getting deal by id ---------------------------");

	if (StringUtils.isNullOrEmpty(new String[] { dealId }))
	    throw new Exception("Please specify deal id to get the deal");

	Deal deal = resource.path("api/opportunity/" + dealId)
		.accept(MediaType.APPLICATION_XML).get(Deal.class);

	return deal;
    }

    /**
     * Updates the {@link Deal} with the given {@link Deal} object
     * 
     * @param deal
     *            {@link Deal} with the changes
     * @return Updated {@link Deal}
     * @throws Exception
     */
    public Deal updateDeal(Deal deal)
    {
	System.out.println("Updating deal --------------------------------");

	deal = resource.path("/api/opportunity").put(Deal.class, deal);

	return deal;
    }

    /**
     * Deletes a {@link Deal} in the Agile CRM based on its id
     * 
     * @param dealId
     *            {@link String} id of the existing deal
     * @throws Exception
     */
    public void deleteDealByDealId(String dealId) throws Exception
    {
	System.out.println("Deleting deal --------------------------------");

	if (StringUtils.isNullOrEmpty(new String[] { dealId }))
	    throw new Exception("Please specify deal id to delete the deal");

	resource.path("api/opportunity/" + dealId).delete();
    }

    /**
     * Deletes list of deals in the Agile CRM based on their id's
     * 
     * @param dealIds
     *            {@link List} of {@link String} deal id's to be deleted
     * @throws Exception
     */
    public void deleteDeals(List<String> dealIds) throws Exception
    {
	System.out.println("Bulk delete deals -------------------------");

	if (StringUtils.isNullOrEmpty(dealIds))
	    throw new Exception("Please specify deal ids to be deleted");

	Form form = new Form();
	form.add("model_ids", dealIds);
	resource.path("api/opportunity/bulk")
		.type(MediaType.APPLICATION_FORM_URLENCODED)
		.post(ClientResponse.class, form);

    }
}
