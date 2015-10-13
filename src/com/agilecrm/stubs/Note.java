package com.agilecrm.stubs;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement(name = "note")
public class Note
{
    @JsonProperty("id")
    private Long id;

    @JsonProperty("created_time")
    private Long created_time;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("description")
    private String description;

    @JsonProperty("contact_ids")
    private List<String> contact_ids;

    @JsonProperty("contacts")
    private List<Contact> contacts;

    public Long getId()
    {
	return id;
    }

    public void setId(Long id)
    {
	this.id = id;
    }

    public Long getCreated_time()
    {
	return created_time;
    }

    public void setCreated_time(Long created_time)
    {
	this.created_time = created_time;
    }

    public String getSubject()
    {
	return subject;
    }

    public void setSubject(String subject)
    {
	this.subject = subject;
    }

    public String getDescription()
    {
	return description;
    }

    public void setDescription(String description)
    {
	this.description = description;
    }

    public List<String> getContact_ids()
    {
	return contact_ids;
    }

    public void setContact_ids(List<String> contactIds)
    {
	this.contact_ids = contactIds;
    }

    @Override
    public String toString()
    {
	return id + " " + subject + " " + description + " " + created_time;
    }

    public List<Contact> getContacts()
    {
	return contacts;
    }
    
    @Deprecated
    public void setContacts(List<Contact> contacts)
    {
	this.contacts = contacts;
    }

}
