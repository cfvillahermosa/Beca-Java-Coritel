package es.coritel.codington.festival.services;

import java.util.List;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.domain.EventSignUp;
import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.exceptions.DAOException;
import es.coritel.codington.festival.exceptions.ServiceException;
import es.coritel.codington.festival.interfaces.services.IEventService;

public class EventService implements IEventService {

	@Override
	public List<Event> getAllEvents() throws ServiceException {
		DAOManager daoManager = new DAOManager();
		List<Event> myList = null;
		try {
			myList = daoManager.getEventDAO().showAllEvents();
			daoManager.closeOK();
		} catch (DAOException e) {
			daoManager.closeError();
			throw new ServiceException(e.getMessage());
		}
		return myList;
	}

	@Override
	public List<Event> getAllEvents(Event eventName) throws ServiceException {
		DAOManager daoManager = new DAOManager();
		List<Event> myList = null;
		try {
			myList = daoManager.getEventDAO().showAllEvents(eventName);
			daoManager.closeOK();
		} catch (DAOException e) {
			daoManager.closeError();
			throw new ServiceException(e.getMessage());
		}
		return myList;
	}

	@Override
	public Event getEvent(int eventId) throws ServiceException {
		DAOManager daoManager = new DAOManager();
		Event event = null;
		try {
			event = daoManager.getEventDAO().getEvent(eventId);
			daoManager.closeOK();
		} catch (DAOException e) {
			daoManager.closeError();
			throw new ServiceException(e.getMessage());
		}
		return event;
	}

	@Override
	public int updateEvent(Event event) throws ServiceException {
		DAOManager daoManager = new DAOManager();
		int updates = 0;
		try {
			updates = daoManager.getEventDAO().updateEvent(event);
			daoManager.closeOK();
		} catch (DAOException e) {
			daoManager.closeError();
			throw new ServiceException(e.getMessage());
		}
		return updates;
	}

	@Override
	public int deleteEvent(int eventId) throws ServiceException {
		DAOManager daoManager = new DAOManager();
		int deletes = 0;
		try {
			deletes = daoManager.getEventDAO().deleteEvent(eventId);
			daoManager.closeOK();
		} catch (DAOException e) {
			daoManager.closeError();
			throw new ServiceException(e.getMessage());
		}
		return deletes;
	}

	@Override
	public int insertEvent(Event event) throws ServiceException {
		DAOManager daoManager = new DAOManager();
		int inserts = 0;
		try {
			inserts = daoManager.getEventDAO().insertEvent(event);
			daoManager.closeOK();
		} catch (DAOException e) {
			daoManager.closeError();
			throw new ServiceException(e.getMessage());
		}
		return inserts;
	}

	@Override
	public void unregisterEvent(Visitor visitor, Event event)
			throws ServiceException {
		DAOManager daoManager = new DAOManager();
		EventSignUp eventSignUp = new EventSignUp();
		eventSignUp.setIdVisitor(visitor.getVisitorId());
		eventSignUp.setIdEvent(event.getEventId());
		int unregisters = daoManager.getEventSignUpDAO()
				.unregisterVisitorToEvent(eventSignUp);
		if (unregisters > 0) {
			daoManager.closeOK();
		} else
			daoManager.closeError();
	}

	@Override
	public void registerEvent(Visitor visitor, Event event)
			throws ServiceException {
		DAOManager daoManager = new DAOManager();
		EventSignUp eventSignUp = new EventSignUp();
		eventSignUp.setIdEvent(event.getEventId());
		eventSignUp.setIdVisitor(visitor.getVisitorId());
		try {
			daoManager.getEventSignUpDAO().registerVisitorToEvent(eventSignUp);
			daoManager.closeOK();
		} catch (DAOException e) {
			daoManager.closeError();
			throw new ServiceException(e.getMessage());
		}

	}

}
