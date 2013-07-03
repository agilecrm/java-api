package com.agilecrm.stubs;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement
public class Tag
{
    @JsonProperty("tag")
    private String tag;

    @JsonProperty("createdTime")
    private Long createdTime = 0l;

    public String getTag()
    {
	return tag;
    }

    public void setTag(String tag)
    {
	this.tag = tag;
    }

    public Long getCreatedTime()
    {
	return createdTime;
    }

    public void setCreatedTime(Long created_time)
    {
	this.createdTime = created_time;
    }
}