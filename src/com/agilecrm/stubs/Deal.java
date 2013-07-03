package com.agilecrm.stubs;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement(name = "opportunity")
public class Deal
{
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("expected_value")
    private Long expected_value;

    @JsonProperty("milestone")
    private String milestone;

    @JsonProperty("probability")
    private Integer probability;

    @JsonProperty("close_date")
    private Long close_date;

    @JsonProperty("created_time")
    private Long created_time;

    @JsonProperty("contacts")
    private List<Contact> contacts;

    @JsonProperty("contact_ids")
    private List<String> contact_ids;

    @JsonProperty("owner")
    private User owner;

    @JsonProperty("owner_id")
    private Long owner_id;

    @JsonProperty("prefs")
    private String prefs;

    public User getOwner()
    {
	return owner;
    }

    public void setOwner(User owner)
    {
	this.owner = owner;
	this.owner_id = owner.getId();
    }

    public Integer getId()
    {
	return id;
    }

    public void setId(Integer id)
    {
	this.id = id;
    }

    public String getName()
    {
	return name;
    }

    public void setName(String name)
    {
	this.name = name;
    }

    public String getDescription()
    {
	return description;
    }

    public void setDescription(String description)
    {
	this.description = description;
    }

    public Long getExpected_value()
    {
	return expected_value;
    }

    public void setExpected_value(Long expected_value)
    {
	this.expected_value = expected_value;
    }

    public String getMilestone()
    {
	return milestone;
    }

    public void setMilestone(String milestone)
    {
	this.milestone = milestone;
    }

    public Integer getProbability()
    {
	return probability;
    }

    public void setProbability(Integer probability)
    {
	this.probability = probability;
    }

    public Long getClose_date()
    {
	return close_date;
    }

    public void setClose_date(Long close_date)
    {
	this.close_date = close_date;
    }

    public Long getCreated_time()
    {
	return created_time;
    }

    public void setCreated_time(Long created_time)
    {
	this.created_time = created_time;
    }

    public Long getOwner_id()
    {
	return owner_id;
    }

    public String getPrefs()
    {
	return prefs;
    }

    public void setPrefs(String prefs)
    {
	this.prefs = prefs;
    }

    public void setContacts(List<Contact> contacts)
    {
	this.contacts = contacts;
    }

    public List<Contact> getContacts()
    {
	return contacts;
    }

    public List<String> getContact_ids()
    {
	return contact_ids;
    }

    public void setContact_ids(List<String> contact_ids)
    {
	this.contact_ids = contact_ids;
    }

    public String toString()
    {
	return id + " " + name + " " + expected_value + " " + milestone + " "
		+ created_time + " " + contact_ids;
    }
}
