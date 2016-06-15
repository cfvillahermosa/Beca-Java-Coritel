package es.coritel.codington.festival.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.domain.EventSignUp;
import es.coritel.codington.festival.exceptions.DAOException;
import es.coritel.codington.festival.interfaces.daos.IEventSignUpDAO;
import es.coritel.codington.festival.utils.FERSDataConnection;
import es.coritel.codington.festival.utils.FERSDbQuery;

public class EventSignUpDAO implements IEventSignUpDAO {
	private Connection myConnection;
	public EventSignUpDAO(Connection conn) {
		myConnection = conn;
	}

	@Override
	public boolean checkEventsofVisitor(EventSignUp eventSignUp)
			throws DAOException {
		boolean checked = false;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = myConnection.prepareStatement(FERSDbQuery.getCheckEvent());
			ps.setInt(1, eventSignUp.getIdVisitor());
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				checked = true;
			}
		} catch (SQLException e) {
			throw new DAOException("fail checkEventsofVisitor");
		} finally {
			FERSDataConnection.closeResulSet(resultSet);
			FERSDataConnection.closeStatement(ps);
		}
		return checked;
	}

	@Override
	public int unregisterVisitorToEvent(EventSignUp eventSignUp)
			throws DAOException {
		int rowsUpdated = 0;
		PreparedStatement ps = null;
		try {
			ps = myConnection.prepareStatement(FERSDbQuery
					.getUnRegisterVisitorToEvent());
			ps.setInt(1, eventSignUp.getIdVisitor());
			ps.setInt(2, eventSignUp.getIdEvent());
			rowsUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("fail unregisterVisitorToEvent");
		} finally {
			FERSDataConnection.closeStatement(ps);

		}
		return rowsUpdated;
	}

	@Override
	public int registerVisitorToEvent(EventSignUp eventSignUp)
			throws DAOException {
		int rowUpdates = 0;
		PreparedStatement ps = null;
		try {
			ps = myConnection.prepareStatement(FERSDbQuery
					.getRegisterVisitorToEvent());
			ps.setInt(1, eventSignUp.getId());
			ps.setInt(2, eventSignUp.getIdEvent());
			ps.setInt(3, eventSignUp.getIdVisitor());
			rowUpdates = ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("fail registerVisitorToEvent");
		} finally {
			FERSDataConnection.closeStatement(ps);
		}

		return rowUpdates;
	}

	@Override
	public int deleteEventSignUp(int eventId) throws DAOException {
		int deletes = 0;
		PreparedStatement ps = null;
		try {
			ps = myConnection.prepareStatement(FERSDbQuery
					.getDeleteEventSessionSignup());
			ps.setInt(1, eventId);
			deletes = ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("fail deleteEventSignUp");
		} finally {
			FERSDataConnection.closeStatement(ps);
		}
		return deletes;
	}

	@Override
	public List<Event> registeredEvents(EventSignUp eventSignUp)
			throws DAOException {
		PreparedStatement ps = null;
		List<Event> registerEvents = null;
		ResultSet resultSet = null;
		Event aux = null;
		try {
			ps = myConnection.prepareStatement(FERSDbQuery
					.getEventsRegistered());
			resultSet = ps.executeQuery();
			registerEvents = new ArrayList<Event>();
			while (resultSet.next()) {
				aux = new Event();
				aux.setDescription(resultSet.getString("description"));
				aux.setDuration(resultSet.getString("duration"));
				aux.setPlace(resultSet.getString("places"));
				aux.setName(resultSet.getString("name"));
				aux.setEventId(Integer.parseInt(resultSet.getString("id")));
				aux.setEventType(resultSet.getString("event_type"));
				aux.setSeatsAEvent(Integer.parseInt(resultSet
						.getString("seats_available")));
						
				registerEvents.add(aux);
			}
		} catch (SQLException e) {
			throw new DAOException("fail registeredEvents");
		} finally {
			FERSDataConnection.closeResulSet(resultSet);
			FERSDataConnection.closeStatement(ps);
		}
		return registerEvents;
	}
	/*
	 * public static void main(String[] args) { System.out.println("hola");
	 * Connection conn = FERSDataConnection.getConnection(); EventSignUpDAO e =
	 * new EventSignUpDAO(conn); EventSignUp eventSignUp = new EventSignUp();
	 * eventSignUp.setId(2); eventSignUp.setIdEvent(2);
	 * eventSignUp.setIdVisitor(2); e.registerVisitorToEvent(eventSignUp); }
	 */
}
