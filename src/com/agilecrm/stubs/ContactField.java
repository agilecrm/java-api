package com.agilecrm.stubs;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement
public class ContactField
{

    public static enum FieldName
    {
	FIRST_NAME("first_name"), LAST_NAME("last_name"), EMAIL("email"), ORGANIZATION(
		"company"), TITLE("title"), COMPANY("name"), URL("url"), PHONE(
		"phone"), WEBSITE("website");

	private String fieldName;

	FieldName(String fieldName)
	{
	    this.fieldName = fieldName;
	}

	public String getFieldName()
	{
	    return fieldName;
	}
    }

    public static enum FieldType
    {
	SYSTEM, CUSTOM
    };

    @JsonProperty("name")
    private String name;

    @JsonProperty("subtype")
    private String subtype;

    @JsonProperty("value")
    private String value;

    @JsonProperty("type")
    private FieldType type;

    public String getName()
    {
	return name;
    }

    public void setName(String name)
    {
	this.name = name;
    }

    public String getSubtype()
    {

	return subtype;
    }

    public void setSubtype(String subtype)
    {
	this.subtype = subtype;
    }

    public String getValue()
    {
	return value;
    }

    public void setValue(String value)
    {
	this.value = value;
    }

    public FieldType getType()
    {
	return type;
    }

    public void setType(FieldType type)
    {
	this.type = type;
    }

}
