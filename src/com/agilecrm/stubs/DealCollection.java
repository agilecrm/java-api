package com.agilecrm.stubs;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "collection")
public class DealCollection
{
    private List<Deal> deals;

    public List<Deal> getDeals()
    {
	return deals;
    }

    @XmlElement(name = "opportunity")
    public void setDeals(List<Deal> deals)
    {
	this.deals = deals;
    }
}
