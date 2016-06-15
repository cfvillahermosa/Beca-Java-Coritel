package es.coritel.codington.festival.services;

import java.util.List;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.domain.EventSignUp;
import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.exceptions.DAOException;
import es.coritel.codington.festival.exceptions.ServiceException;
import es.coritel.codington.festival.interfaces.services.IVisitorService;

public class VisitorService implements IVisitorService {
	DAOManager daoManager = new DAOManager();

	@Override
	public boolean createVisitor(Visitor visitor) throws ServiceException {
		boolean creates = false;
		try {
			creates = (daoManager.getVisitorDAO().insertData(visitor));
			daoManager.closeOK();
		} catch (DAOException e) {
			daoManager.closeError();
			throw new ServiceException(e.getMessage());
		}
		return creates;
	}

	@Override
	public Visitor searchVisitor(Visitor visitor) throws ServiceException {
		Visitor visitorAux = null;
		try {
			visitorAux = daoManager.getVisitorDAO().searchUser(visitor);
			daoManager.closeOK();
		} catch (DAOException e) {
			daoManager.closeError();
			throw new ServiceException(e.getMessage());
		}

		return visitorAux;
	}

	@Override
	public List<Event> showRegisteredEvents(Visitor visitor)
			throws ServiceException {
		EventSignUp eventSignUp = new EventSignUp();
		eventSignUp.setIdVisitor(visitor.getVisitorId());
		List<Event> auxList = null;
		try {
			auxList = daoManager.getEventSignUpDAO().registeredEvents(
					eventSignUp);
			daoManager.closeOK();
		} catch (DAOException e) {
			daoManager.closeError();
			throw new ServiceException(e.getMessage());
		}
		return auxList;
	}

	@Override
	public int updateVisitorDetails(Visitor visitor) throws ServiceException {
		int updates = 0;
		try {
			updates = daoManager.getVisitorDAO().updateVisitor(visitor);
			daoManager.closeOK();

		} catch (DAOException e) {
			daoManager.closeError();
			throw new ServiceException(e.getMessage());
		}
		return updates;
	}

	@Override
	public int changePassword(Visitor visitor) throws ServiceException {
		int updates = 0;
		try {
			updates = daoManager.getVisitorDAO().changePassword(visitor);
			daoManager.closeOK();
		} catch (DAOException e) {
			daoManager.closeError();
			throw new DAOException(e.getMessage());
		}
		return updates;
	}
}
