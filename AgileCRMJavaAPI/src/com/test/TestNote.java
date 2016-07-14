package com.test;

import java.util.ArrayList;
import java.util.List;

import com.agilecrm.api.APIManager;
import com.agilecrm.api.NoteAPI;
import com.agilecrm.stubs.Note;

/**
 * <code>TestNote</code> class contains main method to test the methods in
 * <code>NoteAPI</code> class.
 * 
 * @author Ghanshyam
 * @since October 2015
 * @see NoteAPI
 */
public class TestNote
{

    public static void main(String[] args)
    {
	try
	{
	    String baseUrl = "https://ghanshyam.agilecrm.com/dev";
	    String userEmail = "ghanshyam.raut@agilecrm.com";
	    String restAPIKey = "***************************";

	    // Create a connection to Agile CRM
	    APIManager apiManager = new APIManager(baseUrl, userEmail, restAPIKey);

	    // Get the Note API with configured resource
	    NoteAPI noteApi = apiManager.getNoteAPI();

	    // List of contact id's to which notes are added
	    List<String> contactIds = new ArrayList<String>();
	    contactIds.add("5648063825707008");
	    contactIds.add("5692387351330816");
	    contactIds.add("5645452888244224");

	    // Adding note
	    Note note1 = new Note();

	    note1.setSubject("Test Note1");
	    note1.setDescription("Testing to add note1");

	    note1 = noteApi.addNoteToContactIds(note1, contactIds);

	    System.out.println("Added note..." + note1);

	    // Get notes of a contact
	    List<Note> notes = noteApi.getNotesByContactId(contactIds.get(0));

	    System.out.println("All notes of contact.. " + notes);

	    // Delete note of a contact by note id
	    String noteId = String.valueOf(notes.get(0).getId());

	    noteApi.deleteNoteByContactId(contactIds.get(0), noteId);

	    System.out.println("Deleted note.. " + noteId + " "
		    + contactIds.get(0));

	}
	catch (Exception e)
	{
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	}

    }
}
