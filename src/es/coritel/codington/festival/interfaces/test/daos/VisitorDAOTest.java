package es.coritel.codington.festival.interfaces.test.daos;

import java.sql.Connection;

import es.coritel.codington.festival.daos.VisitorDAO;
import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.exceptions.DAOException;
import es.coritel.codington.festival.interfaces.daos.IVisitorDAO;
import es.coritel.codington.festival.utils.FERSDataConnection;
import junit.framework.TestCase;

public class VisitorDAOTest extends TestCase {
	Visitor visitor = new Visitor();
	Connection conn = FERSDataConnection.getConnection();
	IVisitorDAO visitorDAO = new VisitorDAO(conn);

	protected void setUp() throws Exception {
		super.setUp();
		visitor.setAddress("benito gutierrez");
		visitor.setAdmin(false);
		visitor.setDni("55.888.999-N");
		visitor.setEmail("cfvillahermosa@gmail.com");
		visitor.setFirstName("Carlos");
		visitor.setLastName("fernandez");
		visitor.setPassword("123456");
		visitor.setPhoneNumber("1111111111");
		visitor.setUserName("charly");
		visitor.setVisitorId(2);
		visitorDAO.insertData(visitor);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		FERSDataConnection.rollback(conn);
	}

	public void testSearchUser() {
		assertEquals(visitor,visitorDAO.searchUser(visitor));
	}

	public void testUpdateVisitor() {
		try
		{
			visitorDAO.updateVisitor(visitor);
			fail ("no ha lanzado la DAO exeption");
		}
		catch(DAOException e)
		{
			
		}
	}

	public void testChangePassword() {
		try
		{
			visitorDAO.changePassword(visitor);
			fail ("no ha lanzado la DAO exeption");
		}
		catch(DAOException e)
		{
			
		}
	}

}
