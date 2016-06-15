package es.coritel.codington.festival.interfaces.test.daos;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import es.coritel.codington.festival.daos.EventDAO;
import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.exceptions.DAOException;
import es.coritel.codington.festival.interfaces.daos.IEventDAO;
import es.coritel.codington.festival.utils.FERSDataConnection;
import junit.framework.TestCase;

public class EventDAOTest extends TestCase {
	Event event = new Event();
	Connection conn = FERSDataConnection.getConnection();
	IEventDAO eventDAO = new EventDAO(conn);
	List<Event> myList = new ArrayList<Event>();
	List<Event> myList2 = new ArrayList<Event>();

	protected void setUp() throws Exception {
		super.setUp();
		event.setEventId(4);
		event.setName("nombre4");
		event.setDescription("descripcion4");
		event.setDuration("duracion4");
		event.setEventType("eventtype4");
		event.setPlace("placeevent4");
		event.setSeatsAEvent(4);
		eventDAO.insertEvent(event);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		FERSDataConnection.rollback(conn);
	}

	public void testShowAllEvents() {
		// caso lista llena
		myList.add(eventDAO.getEvent(1));
		myList.add(eventDAO.getEvent(2));
		myList.add(eventDAO.getEvent(4));
		assertEquals(eventDAO.showAllEvents(), myList);
		// caso lista vacia
		eventDAO.deleteEvent(1);
		eventDAO.deleteEvent(2);
		eventDAO.deleteEvent(4);
		assertNull(eventDAO.showAllEvents());
	}

	public void testShowAllEventsEvent() {
		// caso no vacio
		myList = new ArrayList<Event>();
		myList.add(eventDAO.getEvent(1));
		assertEquals(eventDAO.showAllEvents(eventDAO.getEvent(1)), myList);
		assertNull(eventDAO.showAllEvents(eventDAO.getEvent(5)));

	}

	public void testGetEvent() {
		// Caso encontrado
		assertEquals(event, eventDAO.getEvent(4));
		// Caso no encontrado
		assertNull(eventDAO.getEvent(5));
	}

	public void testUpdateEvent() {
		try {
			eventDAO.updateEvent(event);
			fail("no ha lanzado la DAO exeption");

		} catch (DAOException e) {
			
		}
	}

	public void testInsertEvent() {
		try {
			eventDAO.insertEvent(event);
			fail("no ha lanzado la DAO exeption");
		} catch (DAOException e) {
			// OK
		}
	}

	public void testDeleteEvent() {

		try {
			eventDAO.deleteEvent(eventDAO.getEvent(1).getEventId());
			

		} catch (DAOException e) {
			fail("no ha lanzado la DAO exeption");
		}
	}

	public void testUpdateSeatsEventDec() {
		try {
			eventDAO.updateSeatsEventDec(eventDAO.getEvent(1));

		} catch (DAOException e) {
			fail("no ha lanzado la DAO exeption");
		}
	}

	public void testUpdateSeatsEventInc() {
		try {
			eventDAO.updateSeatsEventInc(eventDAO.getEvent(1));

		} catch (DAOException e) {
			fail("no ha lanzado la DAO exeption");
		}
	}

}
