package es.coritel.codington.festival.test.services;

import java.sql.Connection;

import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.interfaces.services.IVisitorService;
import es.coritel.codington.festival.services.VisitorService;
import es.coritel.codington.festival.utils.FERSDataConnection;
import junit.framework.TestCase;

public class VisitorServiceTest extends TestCase {
	Visitor visitor;
	Connection conn = FERSDataConnection.getConnection();
	IVisitorService visitorService = new VisitorService();
	protected void setUp() throws Exception {
		super.setUp();
		visitor = new Visitor();
		visitor.setAddress("alcala");
		visitor.setAdmin(false);
		visitor.setDni("55.555.555-L");
		visitor.setEmail("cfvillahermosa@gmail.com");
		visitor.setFirstName("carlos");
		visitor.setLastName("Fernandez");
		visitor.setPassword("123456");
		visitor.setPhoneNumber("6736383858");
		visitor.setUserName("charly");
		visitor.setVisitorId(5);
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
		conn.rollback();
	}

	public void testCreateVisitor() {
		assertTrue(visitorService.createVisitor(this.visitor));
	}

	public void testSearchVisitor() {
		assertNotNull(visitorService.searchVisitor(this.visitor));
	}

	public void testShowRegisteredEvents() {
		fail("Not yet implemented");
	}

	public void testUpdateVisitorDetails() {
		fail("Not yet implemented");
	}

	public void testChangePassword() {
		fail("Not yet implemented");
	}

}
