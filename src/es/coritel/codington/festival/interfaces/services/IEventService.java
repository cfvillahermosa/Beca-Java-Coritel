package es.coritel.codington.festival.interfaces.services;

import java.util.List;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.exceptions.ServiceException;
/**
 * EVENTFACADE INTERFACE for defining abstract for EVENTSERVICEIMPLEMENTATION 
 */
public interface IEventService {

	/**
	 * Service for displaying all the FESTIVALEVENTS 
	 * @return collection of all Events
	 * @throws ServiceException
	 */
	public List<Event> getAllEvents() throws ServiceException;
	/**
	 *  Service for displaying all the FESTIVALEVENTS 
	 *             based on eventname 
	 * @return collection of all Events
	 * @throws ServiceException
	 */
	public List<Event> getAllEvents(Event eventName) throws ServiceException;
	

	
	/**
	 * This service fetch the event on basis of eventId
	 * @param eventId
	 * @param sessionId
	 * @return
	 * @throws ServiceException
	 */
	public Event getEvent(int eventId) throws ServiceException;
	
	/**
	 * This service updates the event
	 * @param updateEvent
	 * @return
	 * @throw ServiceException
	 */
	public int updateEvent(Event event) throws ServiceException;
	
	/**
	 * This service deletes the event on basis of eventid and eventsessionid from database
	 * @param eventId
	 * @param sessionId
	 * @return
	 * @throws ServiceException

	 */
	public int deleteEvent(int eventId) throws ServiceException;
	
	/**
	 * This service inserts new event in database
	 * @param insertEvent
	 * @return
	 * @throws Servicexception
	 */
	public int insertEvent(Event event) throws ServiceException;
	

	/**
	 * This service unregister a Visitor to an event and increases the number of available seats of the event
	 * @param visitor
	 * @param event
	 * @return
	 * @throws Servicexception
	 */
	public void unregisterEvent(Visitor visitor, Event event) throws ServiceException;
	/**
	 * This service register a Visitor to an event: 
	 * if the visitor is already registered or the event doesn't have any available seat its throws a ServiceException
	 * the method  increases the number of available seats of the event after the register
	 * @param visitor
	 * @param event
	 * @return
	 * @throws Servicexception
	 */
	public void registerEvent(Visitor visitor, Event event) throws ServiceException;
}
