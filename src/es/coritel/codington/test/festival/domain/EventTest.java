package es.coritel.codington.test.festival.domain;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.exceptions.DomainException;
import junit.framework.TestCase;

public class EventTest extends TestCase {

	Event event;
	public static final int VALID_ID_EVENT = 01;

	public static final String VALID_NAME = "extremusica";

	public static final String VALID_DESCRIPTION = "buena musica buen ambiente";
																	

	public static final String VALID_PLACE = "Caceres";

	public static final String VALID_DURATION = "3";

	public static final String VALID_EVENT_TYPE = "musicavariada";

	public static final int EVENT_PLACES = 500;

	protected void setUp() throws Exception {
		super.setUp();
		event = new Event();

		event.setEventId(VALID_ID_EVENT);
		event.setName(VALID_NAME);
		event.setDescription(VALID_DESCRIPTION);
		event.setPlace(VALID_PLACE);
		event.setDuration(VALID_DURATION);
		event.setEventType(VALID_EVENT_TYPE);
		event.setSeatsAEvent(EVENT_PLACES);

	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetEventId() {
		assertEquals(VALID_ID_EVENT, event.getEventId());

	}

	public void testSetEventId() {

		event.setEventId(VALID_ID_EVENT);
		assertEquals(VALID_ID_EVENT, event.getEventId());

		assertFailEventId(-8);
		assertFailEventId(0);

	}

	private void assertFailEventId(int evento) {
		try {
			event.setEventId(evento);
		} catch (DomainException e) {
			System.out.println("Not valid ID");
		}
	}

	public void testGetName() {
		assertEquals(VALID_NAME, event.getName());

	}

	public void testSetName() {
		event.setName(VALID_NAME);
		assertEquals(VALID_NAME, event.getName());
		assertFailName("thisisnotavalidnamebecauseistoomuchlarge");

	}

	private void assertFailName(String name) {
		try {
			event.setName(name);
		} catch (DomainException e) {
			System.out.println("Not valid NAME");
		}
	}

	public void testGetDescription() {
		assertEquals(VALID_DESCRIPTION, event.getDescription());

	}

	public void testSetDescription() {
		event.setDescription(VALID_DESCRIPTION);
		assertEquals(VALID_DESCRIPTION, event.getDescription());
		assertFailDescription("");
		assertFailDescription("verybaddescription");

	}

	private void assertFailDescription(String descripcion) {
		try {
			event.setDescription(descripcion);
		} catch (DomainException e) {
			System.out.println("Not valid DESCRIPTION");
		}
	}

	public void testGetPlace() {
		assertEquals(VALID_PLACE, event.getPlace());

	}

	public void testSetPlace() {
		event.setPlace(VALID_PLACE);
		assertEquals(VALID_PLACE, event.getPlace());
		assertFailPlace("");
		assertFailPlace("thisisnotavalidplace");

	}

	private void assertFailPlace(String place) {
		try {
			event.setPlace(place);
		} catch (DomainException e) {
			System.out.println("Not valid PLACE");
		}
	}

	public void testGetDuration() {
		assertEquals(VALID_DURATION, event.getDuration());

	}

	public void testSetDuration() {

		event.setDuration(VALID_DURATION);
		assertEquals(VALID_DURATION, event.getDuration());
		assertFailDuration("");
		assertFailDuration("thisisnotagooddurarionforthisevent");

	}

	private void assertFailDuration(String duration) {
		try {
			event.setPlace(duration);
		} catch (DomainException e) {
			System.out.println("Not valid PLACE");
		}
	}

	public void testGetEventType() {
		assertEquals(VALID_EVENT_TYPE, event.getEventType());

	}

	public void testSetEventType() {
		event.setEventType(VALID_EVENT_TYPE);
		assertEquals(VALID_EVENT_TYPE, event.getEventType());
		assertFailType("");
		assertFailType("thisisnotavalideventypebecauseistoomuchlarge");
	}

	private void assertFailType(String tipo) {
		try {
			event.setEventType(tipo);
		} catch (DomainException e) {
			System.out.println("Not valid PLACE");
		}
	}

	public void testGetSeatsAEvent() {

	}

	public void testSetSeatsAEvent() {

		event.setSeatsAEvent(EVENT_PLACES);
		assertEquals(EVENT_PLACES, event.getSeatsAEvent());

		assertFailPlaces(-1);

	}

	private void assertFailPlaces(int places) {
		try {
			event.setSeatsAEvent(places);
		} catch (DomainException e) {
			System.out.println("Not valid PLACE");
		}
	}

	public void testEvent() {
		Event e = new Event(event);
		assertEquals(e, event);
	}

	public void testEventEvent() {
		Event e = new Event(event);
		assertEquals(e, event);
	}

}
