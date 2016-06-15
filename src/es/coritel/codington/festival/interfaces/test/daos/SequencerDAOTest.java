package es.coritel.codington.festival.interfaces.test.daos;

import java.sql.Connection;

import es.coritel.codington.festival.daos.SequencerDAO;
import es.coritel.codington.festival.interfaces.daos.ISequencerDAO;
import es.coritel.codington.festival.utils.FERSDataConnection;
import junit.framework.TestCase;

public class SequencerDAOTest extends TestCase {
	Connection conn = FERSDataConnection.getConnection();
	ISequencerDAO sequencerDAO = new SequencerDAO(conn);
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetNext() {
		assertEquals(sequencerDAO.getNext("sequencer"), 3);
	}

}
