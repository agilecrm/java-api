package com.agilecrm.api;

import java.util.List;

import com.agilecrm.stubs.Contact;
import com.agilecrm.stubs.Note;
import com.agilecrm.stubs.NoteCollection;
import com.agilecrm.utils.StringUtils;
import com.sun.jersey.api.client.WebResource;

/**
 * <code>NoteAPI</code> contains methods to add, get and delete notes from Agile
 * CRM
 * 
 * @author Tejaswi
 * @since March 2013
 * @see APIManager
 */
public class NoteAPI
{
    /**
     * Holds a {@link WebResource} object
     */
    private final WebResource resource;

    /**
     * Initializes the field resource with the configured resource from
     * {@link APIManager}
     * 
     * @param resource
     *            {@link WebResource}
     */
    NoteAPI(WebResource resource)
    {
	this.resource = resource;
    }

    /**
     * Adds note to the list of contact id's in the Agile CRM based on the given
     * parameters
     * 
     * @param subject
     *            {@link String} subject of the {@link Note}
     * @param description
     *            {@link String} description of the {@link Note}
     * @param contactIds
     *            {@link List} of {@link String} id's of the {@link Contact} to
     *            which note is added
     * @return Added {@link Note}
     * @throws Exception
     */
    public Note addNoteToContactIds(String subject, String description,
	    List<String> contactIds) throws Exception
    {
	System.out.println("Adding note ---------------------------------");

	if (StringUtils.isNullOrEmpty(new String[] { subject, description }))
	    throw new Exception("subject or description of note is empty");

	if (StringUtils.isNullOrEmpty(contactIds))
	    throw new Exception("Please specify contacts ids to add note");

	Note note = new Note();
	note.setSubject(subject);
	note.setDescription(description);
	note.setContact_ids(contactIds);

	note = resource.path("/api/notes").post(Note.class, note);

	return note;
    }

    /**
     * Adds a note to Agile CRM with the given {@link Note} object
     * 
     * @param note
     *            {@link Note} object to be added
     * @param contactIds
     *            {@link List} of {@link String} id's of the {@link Contact}
     * @return Added {@link Note}
     * @throws Exception
     */
    public Note addNoteToContactIds(Note note, List<String> contactIds)
	    throws Exception
    {
	System.out.println("Adding note ---------------------------------");

	if (note == null)
	    throw new Exception("Cannot add a note without note object");

	if (StringUtils.isNullOrEmpty(contactIds))
	    throw new Exception("Please specify contacts ids to add note");

	note.setContact_ids(contactIds);

	note = resource.path("/api/notes").post(Note.class, note);

	return note;
    }

    /**
     * Retrieves a {@link Note} from Agile CRM based on the id of the
     * {@link Contact} to which note is related.
     * 
     * @param contactId
     *            {@link String} id of the {@link Contact}
     * @return {@link Note}
     * @throws Exception
     */
    public List<Note> getNotesByContactId(String contactId) throws Exception
    {
	System.out.println("Getting notes by contact id --------------------");

	if (StringUtils.isNullOrEmpty(new String[] { contactId }))
	    throw new Exception("Please specify contact Id to get the notes");

	NoteCollection notecollection = resource.path(
		"/api/contacts/" + contactId + "/notes").get(
		NoteCollection.class);

	return notecollection.getNotes();
    }

    /**
     * Deletes a {@link Note} in Agile CRM based on its id and id of the
     * {@link Contact} to which it is related.
     * 
     * @param contactId
     *            {@link String} id of the {@link Contact}
     * @param noteId
     *            {@link String} id of the {@link Note}
     * @throws Exception
     */
    public void deleteNoteByContactId(String contactId, String noteId)
	    throws Exception
    {
	System.out.println("Deleting note --------------------------------");

	if (StringUtils.isNullOrEmpty(new String[] { contactId, noteId }))
	    throw new Exception(
		    "Please specify contact id and note id to delete the notes");

	resource.path("/api/contacts/" + contactId + "/notes/" + noteId)
		.delete();
    }
}
