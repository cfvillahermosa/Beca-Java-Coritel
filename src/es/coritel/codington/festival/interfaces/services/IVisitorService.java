package es.coritel.codington.festival.interfaces.services;

import java.util.List;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.exceptions.ServiceException;
/**
 * VISITORFACADE INTERFACE for defining abstract for VISITORSERVICEIMPLEMENTATION 
 */
public interface IVisitorService {

	/** 
	 * This service creates a new Visitor
	 * if the visitor already exists returns false
	 * else it creates the visitor and returns true 
	 * @param visitor
	 * @return
	 * @throws ServiceException
	 */
	public boolean createVisitor(Visitor visitor) throws ServiceException;;
	
	/**
	 * This method search a Visitor by username
	 * @param visitor
	 * @return
	 * @throws ServiceException
	 */
	public Visitor searchVisitor(Visitor visitor) throws ServiceException;;
	
	
	/**
	 * This method gets the list of registered events for the visitor
	 * @param visitor
	 * @return
	 * @throws ServiceException
	 */
	public List<Event> showRegisteredEvents(Visitor visitor) throws ServiceException;;
	
	/**
	 * This service updates the visitor information
	 * @param visitor
	 * @return
	 * @throws ServiceException
	 */
	public int updateVisitorDetails(Visitor visitor) throws ServiceException;;
	
	
	/**
	 * This service updates the visitor password
	 * @param visitor
	 * @return
	 * @throws ServiceException
	 */
	public int changePassword(Visitor visitor) throws ServiceException;
}
