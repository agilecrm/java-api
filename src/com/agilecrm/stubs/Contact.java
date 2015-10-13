package com.agilecrm.stubs;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.json.JSONObject;

import com.agilecrm.stubs.ContactField.FieldName;
import com.agilecrm.stubs.ContactField.FieldType;

@XmlRootElement
public class Contact
{
    @JsonProperty("id")
    private Long id;

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("owner_key")
    private String owner_key;

    @JsonProperty("widget_properties")
    private String widget_properties = null;

    @JsonProperty("type")
    private Type type;

    @JsonProperty("tags")
    private List<String> tags;

    @JsonProperty("lead_score")
    private Integer lead_score;

    @JsonProperty("star_value")
    private Short star_value;

    @JsonProperty("properties")
    private List<ContactField> properties;

    @JsonProperty("created_time")
    private String created_time;

    @JsonProperty("updated_time")
    private String updated_time;

    @JsonProperty("tags_with_time_json")
    private JSONObject tags_with_time_json;

    @JsonProperty("domainUser")
    private JSONObject domainUser;

    public static enum Type
    {
	PERSON, COMPANY
    };

    public Long getId()
    {
	return id;
    }

    public void setId(Long id)
    {
	this.id = id;
    }

    public Type getType()
    {

	return type;
    }

    public void setType(Type type)
    {
	this.type = type;
    }

    public List<String> getTags()
    {
	return tags;
    }

    public void setTags(List<String> tags)
    {
	this.tags = tags;
    }

    public Integer getLead_score()
    {
	return lead_score;
    }

    public void setLead_score(Integer lead_score)
    {
	this.lead_score = lead_score;
    }

    public Short getStar_value()
    {
	return star_value;
    }

    public void setStar_value(Short star_value)
    {
	this.star_value = star_value;
    }

    public List<ContactField> getProperties()
    {
	return properties;
    }

    public void setProperties(List<ContactField> properties)
    {
	this.properties = properties;
    }

    public String getCreated_time()
    {
	return created_time;
    }

    public void setCreated_time(String created_time)
    {
	this.created_time = created_time;
    }

    public String getUpdated_time()
    {
	return updated_time;
    }

    public void setUpdated_time(String updated_time)
    {
	this.updated_time = updated_time;
    }

    public JSONObject getTags_with_time_json()
    {
	return tags_with_time_json;
    }

    public void setTags_with_time_json(JSONObject tags_with_time_json)
    {
	this.tags_with_time_json = tags_with_time_json;
    }

    public JSONObject getDomainUser()
    {
	return domainUser;
    }

    public void setDomainUser(JSONObject domainUser)
    {
	this.domainUser = domainUser;
    }

    public Integer getCount()
    {
	return count;
    }

    public void setCount(Integer count)
    {
	this.count = count;
    }

    public String getOwner_key()
    {
	return owner_key;
    }

    public void setOwner_key(String owner_key)
    {
	this.owner_key = owner_key;
    }

    /**
     * Does some thing in old style.
     *
     * @deprecated not using any more.  
     */
    @Deprecated
    public String getWidget_properties()
    {
	return widget_properties;
    }

    /**
     * Does some thing in old style.
     *
     * @deprecated not using any more.  
     */
    @Deprecated
    public void setWidget_properties(String widget_properties)
    {
	this.widget_properties = widget_properties;
    }

    public void setContactField(FieldName name, String value)
    {
	if (properties == null)
	    properties = new ArrayList<ContactField>();

	for (ContactField property : properties)
	{
	    if (name.getFieldName().equalsIgnoreCase(property.getName()))
	    {
		property.setValue(value);
		return;
	    }
	}

	ContactField contactField = new ContactField();
	contactField.setType(FieldType.SYSTEM);
	contactField.setName(name.getFieldName());
	contactField.setValue(value);

	properties.add(contactField);
    }

    public void setCustomField(String fieldName, String fieldValue)
    {
	if (properties == null)
	    properties = new ArrayList<ContactField>();
	
	for (ContactField property : properties)
	{
	    if (property.getName().equalsIgnoreCase(fieldName))
	    {
		property.setValue(fieldValue);
		return;
	    }
	}

	ContactField contactField = new ContactField();
	contactField.setName(fieldName);
	contactField.setValue(fieldValue);
	contactField.setType(FieldType.CUSTOM);
	properties.add(contactField);
    }

	@Override
	public String toString() {
		return "Contact [id=" + id + ", count=" + count + ", owner_key="
				+ owner_key + ", widget_properties=" + widget_properties
				+ ", type=" + type + ", tags=" + tags + ", lead_score="
				+ lead_score + ", star_value=" + star_value + ", properties="
				+ properties + ", created_time=" + created_time
				+ ", updated_time=" + updated_time + ", tags_with_time_json="
				+ tags_with_time_json + ", domainUser=" + domainUser + "]";
	}



}
