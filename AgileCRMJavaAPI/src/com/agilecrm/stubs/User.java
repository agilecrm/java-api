package com.agilecrm.stubs;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement(name = "owner")
public class User
{

    @JsonProperty("id")
    private Long id;

    @JsonProperty("domain")
    private String domain;

    @JsonProperty("email")
    private String email;

    public Long getId()
    {
	return id;
    }

    public void setId(Long id)
    {
	this.id = id;
    }

    public String getDomain()
    {
	return domain;
    }

    public void setDomain(String domain)
    {
	this.domain = domain;
    }

    public String getEmail()
    {
	return email;
    }

    public void setEmail(String email)
    {
	this.email = email;
    }

}
