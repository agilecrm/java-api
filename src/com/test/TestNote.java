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
 * @author Tejaswi
 * @since March 2013
 * @see NoteAPI
 */
public class TestNote
{

    public static void main(String[] args)
    {
	try
	{
	    // Create a connection to Agile CRM
	    APIManager apiManager = AgileConnection.getConnection();

	    // Get the Note API with configured resource
	    NoteAPI noteApi = apiManager.getNoteAPI();

	    // List of contact id's to which notes are added
	    List<String> contactIds = new ArrayList<String>();
	    contactIds.add("967");
	    contactIds.add("968");
	    contactIds.add("969");

	    // Adding note
	    Note note1 = new Note();

	    note1.setSubject("Test Note1");
	    note1.setDescription("Testing to add note1");

	    note1 = noteApi.addNoteToContactIds(note1, contactIds);

	    System.out.println("Added note..." + note1);

	    // Another method to add note
	    Note note2 = new Note();

	    note2 = noteApi.addNoteToContactIds("Test Note2",
		    "Testing to add note2", contactIds);

	    System.out.println("Added note..." + note2);

	    // Get notes of a contact
	    List<Note> notes = noteApi.getNotesByContactId(contactIds.get(0));

	    System.out.println("All notes of contact.. " + notes);

	    // Delete note of a contact by note id
	    String noteId = String.valueOf(notes.get(0).getId());

	    noteApi.deleteNoteByContactId(contactIds.get(0), noteId);

	    System.out.println("Deleted note.. " + noteId + " "
		    + contactIds.get(0));

	    notes = noteApi.getNotesByContactId(contactIds.get(0));

	    System.out.println("All notes of contact.. " + notes);

	}
	catch (Exception e)
	{
	    System.out.println(e.getMessage());
	    e.printStackTrace();
	}

    }
}
