package com.agilecrm.stubs;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement
public class Tag
{
	@JsonProperty("tags")
    private List<String> tags;

    @JsonProperty("createdTime")
    private Long createdTime = 0l;

   


	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
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
