package com.agilecrm.stubs;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "collection")
public class ContactCollection implements Serializable
{
    private static final long serialVersionUID = 1L;

    private List<Contact> contacts;

    // @JsonProperty("contact")
    public List<Contact> getContacts()
    {
	return contacts;
    }

    // @JsonProperty("contact")
    @XmlElement(name = "contact")
    public void setContacts(List<Contact> contacts)
    {
	this.contacts = contacts;
    }

}
