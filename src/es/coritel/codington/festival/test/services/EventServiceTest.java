package es.coritel.codington.festival.test.services;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.interfaces.services.IEventService;
import es.coritel.codington.festival.services.EventService;
import es.coritel.codington.festival.utils.FERSDataConnection;
import junit.framework.TestCase;

public class EventServiceTest extends TestCase {
	List<Event> myList;
	Event event;
	Event event2;
	IEventService eventService;
	Connection con;
	
	protected void setUp() throws Exception {
		super.setUp();
		con = FERSDataConnection.getConnection();
		eventService = new EventService();
		myList = new ArrayList<Event>();
		event = new Event();
		event2 = new Event();
		//inicialización e inserción de mi evento de prueba 1
		event.setEventId (1);
		event.setName("Evento 1");
		event.setDescription("Descripcion Evento 1");
		event.setPlace("Place 1");
		event.setDuration("0900-1100");
		event.setEventType("Type 1");
		event.setSeatsAEvent(10);
		myList.add(event);
		//inicialización e inserción de mi evento de prueba 2
		event2.setEventId(2);
		event2.setName("Evento 2");
		event2.setDescription("Descripcion Evento 2");
		event2.setPlace("Place 2");
		event2.setDuration("1100-1200");
		event2.setEventType("Type 2");
		event2.setSeatsAEvent(2);
		myList.add(event2);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetAllEvents() {
		assertEquals(eventService.getAllEvents(),myList);
		eventService.deleteEvent(1);
		eventService.deleteEvent(2);
		assertNull(eventService.getAllEvents());
		eventService.insertEvent(event);
		eventService.insertEvent(event2);
	}

	public void testGetAllEventsEvent() {
		fail("Not yet implemented");
	}

	public void testGetEvent() {
		fail("Not yet implemented");
	}

	public void testUpdateEvent() {
		fail("Not yet implemented");
	}

	public void testDeleteEvent() {
		fail("Not yet implemented");
	}

	public void testInsertEvent() {
		fail("Not yet implemented");
	}

	public void testUnregisterEvent() {
		fail("Not yet implemented");
	}

	public void testRegisterEvent() {
		fail("Not yet implemented");
	}

}
