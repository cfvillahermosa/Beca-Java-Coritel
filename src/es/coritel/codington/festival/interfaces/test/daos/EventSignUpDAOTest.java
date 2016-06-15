package es.coritel.codington.festival.interfaces.test.daos;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import es.coritel.codington.festival.daos.EventDAO;
import es.coritel.codington.festival.daos.EventSignUpDAO;
import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.domain.EventSignUp;
import es.coritel.codington.festival.exceptions.DAOException;
import es.coritel.codington.festival.interfaces.daos.IEventDAO;
import es.coritel.codington.festival.interfaces.daos.IEventSignUpDAO;
import es.coritel.codington.festival.utils.FERSDataConnection;
import junit.framework.TestCase;

public class EventSignUpDAOTest extends TestCase {
	EventSignUp eventSignUp = new EventSignUp();
	Connection conn = FERSDataConnection.getConnection();
	IEventSignUpDAO eventSignUpDAO = new EventSignUpDAO(conn);
	List<Event> myList = new ArrayList<Event>();
	IEventDAO eventDAO = new EventDAO(conn);
	protected void setUp() throws Exception {
		super.setUp();
		eventSignUp.setId(1);
		eventSignUp.setIdEvent(1);
		eventSignUp.setIdVisitor(1);
		eventSignUpDAO.registerVisitorToEvent(eventSignUp);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		conn.rollback();
	}


	public void testCheckEventsofVisitor() {		
		assertEquals(eventSignUpDAO.checkEventsofVisitor(eventSignUp),true);
	}

	public void testUnregisterVisitorToEvent() {
		eventSignUpDAO.unregisterVisitorToEvent(eventSignUp);
	}



	public void testDeleteEventSignUp() {
		try {
			eventSignUpDAO.deleteEventSignUp(eventSignUp.getId());

		} catch (DAOException e) {
			fail("no ha lanzado la DAO exeption");
		}
		
	}
	public void testRegisteredEvents() {
		myList.add(eventDAO.getEvent(eventSignUp.getId()));
		assertEquals(eventSignUpDAO.registeredEvents(eventSignUp), myList);
	}
}
