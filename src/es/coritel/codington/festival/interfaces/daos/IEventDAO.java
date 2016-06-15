package es.coritel.codington.festival.interfaces.daos;

import java.util.List;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.exceptions.DAOException;

public interface IEventDAO {
	
	

	/**
	 * DAO for displaying all the FESTIVALEVENTS in EVENT TABLE
	 * @return collection of all Events
	 * @throws DAOException
	 */
	public List<Event> showAllEvents() throws DAOException ;
	
	


	/**
	 *  DAO for displaying all the FESTIVALEVENTS in EVENT TABLE
	 *             based on eventname from Database
	 * @param eventname
	 * @return
	 * @throws DAOException
	 *            
	 */
	public List<Event> showAllEvents(Event eventname)
			throws DAOException ;
	

	
	/**
	 * This method fetch the event on basis of eventId
	 * @param eventId
	 * @param sessionId
	 * @return
	 * @throws DAOException
	 */
	public Event getEvent(int eventId)
			throws DAOException;

	/**
	 * This method updates the event
	 * @param updateEvent
	 * @return
	 * @throws DAOException
	 */
	public int updateEvent(Event updateEvent) throws DAOException; 

	/**
	 * This method inserts new event in database
	 * @param insertEvent
	 * @return
	 * @throws DAOException
	 */
	public int insertEvent(Event insertEvent) throws DAOException;
	

	/**
	 * This method deletes the event on basis of eventid and eventsessionid from database
	 * @param eventId
	 * @param sessionId
	 * @return
	 * @throws DAOException

	 */
	public int deleteEvent(int eventId)
			throws DAOException;

	
		
	/**
	 * This method decreases the available seats of an event
	 * @param event
	 * @throws DAOException
	 *             DAO for updating FESTIVAL EVENTS after visitor registers for
	 *             event
	 * 
	 */

	public int updateSeatsEventDec(Event event) throws DAOException ;
	
	/**
	 * This method increases the available seats of an event
	 * @param event
	 * @throws DAOException
	 *             DAO for updating FESTIVAL EVENTS after visitor registers for
	 *             event
	 * 
	 */

	public int updateSeatsEventInc(Event event) throws DAOException ;
	
	

}
