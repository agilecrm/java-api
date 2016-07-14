package com.agilecrm.stubs;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "collection")
public class NoteCollection implements Serializable
{

    private static final long serialVersionUID = 1L;

    private List<Note> notes;

    // @JsonProperty("note")
    public List<Note> getNotes()
    {
	return notes;
    }

    // @JsonProperty("note")
    @XmlElement(name = "note")
    public void setNotes(List<Note> notes)
    {
	this.notes = notes;
    }
}
