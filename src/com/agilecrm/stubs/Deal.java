package com.agilecrm.stubs;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement(name = "opportunity")
public class Deal
{
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("expected_value")
    private Double expected_value;

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

    @JsonProperty("owner_id")
    private Long owner_id;
    
    // Newly added field
    
    @JsonProperty("custom_data")
    private List<CustomFieldData> custom_data;
    
    @JsonProperty("track")
    private String track;
    
    @JsonProperty("deal_source_id")
    private Long deal_source_id;
    
    @JsonProperty("note_ids")
    private List<String> note_ids;
    
    @JsonProperty("pipeline_id")
    private Long pipeline_id;
    
    public Long getId()
    {
	return id;
    }

    public void setId(Long id)
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

    public Double getExpected_value()
    {
	return expected_value;
    }

    public void setExpected_value(Double expected_value)
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

    public List<Contact> getContacts() {
		return contacts;
	}
    
    @Deprecated
	public void setContacts(List<Contact> contacts) {
    	this.contacts = contacts;
	}

	public List<String> getContact_ids()
    {
	return contact_ids;
    }

    public void setContact_ids(List<String> contact_ids)
    {
	this.contact_ids = contact_ids;
    }
    
    public Long getOwner_id()
    {
	return owner_id;
    }
    
    public void setOwner_id(Long owner_id) {
		this.owner_id = owner_id;
	}
    
    public List<CustomFieldData> getCustom_data() {
		return custom_data;
	}

	public void setCustom_data(List<CustomFieldData> custom_data) {
		this.custom_data = custom_data;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	public Long getDeal_source_id() {
		return deal_source_id;
	}

	public void setDeal_source_id(Long deal_source_id) {
		this.deal_source_id = deal_source_id;
	}

	public List<String> getNote_ids() {
		return note_ids;
	}

	public void setNote_ids(List<String> note_ids) {
		this.note_ids = note_ids;
	}
	
	public Long getPipeline_id() {
		return pipeline_id;
	}

	public void setPipeline_id(Long pipeline_id) {
		this.pipeline_id = pipeline_id;
	}

	@Override
	public String toString() {
		return "Deal [id=" + id + ", name=" + name + ", description="
				+ description + ", expected_value=" + expected_value
				+ ", milestone=" + milestone + ", probability=" + probability
				+ ", close_date=" + close_date + ", created_time="
				+ created_time + ", contact_ids=" + contact_ids + ", owner_id="
				+ owner_id + ", pipeline_id=" + pipeline_id + ", custom_data="
				+ custom_data + ", track=" + track + ", deal_source_id="
				+ deal_source_id + ", note_ids=" + note_ids + "]";
	}


}
