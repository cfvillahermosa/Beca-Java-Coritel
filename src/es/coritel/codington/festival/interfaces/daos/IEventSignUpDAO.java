package es.coritel.codington.festival.interfaces.daos;

import java.util.List;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.domain.EventSignUp;
import es.coritel.codington.festival.exceptions.DAOException;

public interface IEventSignUpDAO {
	
	/**
	 * DAO for checking visitor has already registered for EVENT or
	 * not. Sends boolean values about status.
	 * @param visitor
	 * @param event
	 * @return
	 * @throws DAOException
	 *             
	 */
	public boolean checkEventsofVisitor(EventSignUp eventSignUp) throws DAOException;
	
	/**
	 *  DAO method to unregister visitor for particular events
	 * @param visitor
	 * @param event
	 * @return num rows updated
	 * @throws ClassNotFoundException
	 * @throws DAOexception
	 *
	 */
	public int unregisterVisitorToEvent(EventSignUp eventSignUp)
			throws DAOException ;
	
	/**
	 * DAO method to register visitor to specific event and checking about status
	 * of visitor to particular event.
	 * @param visitor
	 * @param eventid
	 * @return num rows updated
	 * @throws DAOException
	 *
	 */
	public int registerVisitorToEvent(EventSignUp eventSignUp)
			throws DAOException ;
	
	/**
	 * This method deletes the event on basis of eventid from database
	 * @param eventId
	 * @return
	 * @throws DAOException
	 */
	int deleteEventSignUp(int eventId) throws DAOException;
	
	/**
	 * DAO method to display all the events registered by particular visitor
	 * 
	 * @param visitor
	 * @return
	 * @throws DAOException
	 */
	public List<Event> registeredEvents(EventSignUp eventSignUp)
			throws DAOException;

}
