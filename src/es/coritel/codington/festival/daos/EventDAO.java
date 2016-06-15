package es.coritel.codington.festival.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;

import es.coritel.codington.festival.domain.Event;
import es.coritel.codington.festival.exceptions.DAOException;
import es.coritel.codington.festival.interfaces.daos.IEventDAO;
import es.coritel.codington.festival.utils.FERSDataConnection;
import es.coritel.codington.festival.utils.FERSDbQuery;

public class EventDAO implements IEventDAO {
	private Connection myConnection;

	public EventDAO(Connection conn) {

		myConnection = conn;
	}

	@Override
	public List<Event> showAllEvents() throws DAOException {
		ResultSet resultSet = null;
		PreparedStatement ps = null;
		Event aux = null;
		List<Event> allEvents;
		try {
			ps = myConnection.prepareStatement(FERSDbQuery.getAllEvents());
			resultSet = ps.executeQuery();
				allEvents = new ArrayList<Event>();
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
				allEvents.add(aux);
			}
		} catch (SQLException e) {
			throw new DAOException("fail showAllEvents");
		} finally {
			FERSDataConnection.closeResulSet(resultSet);
			FERSDataConnection.closeStatement(ps);
		}
		if(allEvents.isEmpty())
			allEvents = null;
		return allEvents;
	}

	@Override
	public List<Event> showAllEvents(Event eventname) throws DAOException {
		List<Event> allEvents;
		if(eventname == null){
			return allEvents = null;
		}
		else{
		ResultSet resultSet = null;
		PreparedStatement ps = null;
		Event aux = null;
		
		try {
			ps = myConnection.prepareStatement(FERSDbQuery
					.getSearchByEventName());
			ps.setString(1, eventname.getName());
			resultSet = ps.executeQuery();
			allEvents = new ArrayList<Event>();
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
				allEvents.add(aux);
			}
		} catch (SQLException e) {
			throw new DAOException("fail showAllEvents");
		} finally {
			FERSDataConnection.closeResulSet(resultSet);
			FERSDataConnection.closeStatement(ps);
		}
		if(allEvents.isEmpty())
			allEvents = null;
		return allEvents;
		}
	}

	@Override
	public Event getEvent(int eventId) throws DAOException {
		Event aux = null;
		ResultSet resultSet = null;
		PreparedStatement ps = null;
		try {
			ps = myConnection.prepareStatement(FERSDbQuery.getGetEvent());
			ps.setInt(1, eventId);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				aux = new Event();
				aux.setDescription(resultSet.getString("description"));
				aux.setDuration(resultSet.getString("duration"));
				aux.setPlace(resultSet.getString("places"));
				aux.setEventId(Integer.parseInt(resultSet.getString("id")));
				aux.setName(resultSet.getString("name"));
				aux.setEventType(resultSet.getString("event_type"));
				aux.setSeatsAEvent(Integer.parseInt(resultSet
						.getString("seats_available")));
			}
		} catch (SQLException e) {
			throw new DAOException("fail getEvent");
		} finally {
			FERSDataConnection.closeStatement(ps);
			FERSDataConnection.closeResulSet(resultSet);
		}
		return aux;

	}

	@Override
	public int updateEvent(Event updateEvent) throws DAOException {
		PreparedStatement ps = null;
		int updates = 0;
		try {
			ps = myConnection.prepareStatement(FERSDbQuery.getUpdateEvent());
			ps.setInt(1, updateEvent.getEventId());
			ps.setString(2, updateEvent.getName());
			ps.setString(3, updateEvent.getDescription());
			ps.setString(4, updateEvent.getPlace());
			ps.setString(5, updateEvent.getDuration());
			ps.setString(6, updateEvent.getEventType());
			ps.setInt(7, updateEvent.getSeatsAEvent());
			ps.setInt(8, updateEvent.getEventId());
			updates = ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("fail updateEvent");
		} finally {
			FERSDataConnection.closeStatement(ps);
		}
		return updates;
	}

	@Override
	public int insertEvent(Event insertEvent) throws DAOException {
		int inserts = 0;
		PreparedStatement ps = null;
		try {
			ps = myConnection.prepareStatement(FERSDbQuery.getInsertEvent());
			ps.setInt(1, insertEvent.getEventId());
			ps.setString(2, insertEvent.getName());
			ps.setString(3, insertEvent.getDescription());
			ps.setString(4, insertEvent.getPlace());
			ps.setString(5, insertEvent.getDuration());
			ps.setString(6, insertEvent.getEventType());
			ps.setInt(7, insertEvent.getSeatsAEvent());
			inserts = ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("fail insertEvent");
		} finally {
			FERSDataConnection.closeStatement(ps);
		}
		return inserts;
	}

	@Override
	public int deleteEvent(int eventId) throws DAOException {
		PreparedStatement ps = null;
		int deletes = 0;
		try {
			ps = myConnection.prepareStatement(FERSDbQuery.getDeleteEvent());
			ps.setInt(1, eventId);
			deletes = ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("fail deleteEvent");
		} finally {
			FERSDataConnection.closeStatement(ps);
		}
		return deletes;
	}

	@Override
	public int updateSeatsEventDec(Event event) throws DAOException {
		int updateSeatsDec = 0;
		PreparedStatement ps = null;
		try {
			ps = myConnection.prepareStatement(FERSDbQuery
					.getUpdateSeatsEventDec());
			ps.setString(1, event.getName());
			updateSeatsDec = ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("fail updateSeatsEventDec");
		} finally {
			FERSDataConnection.closeStatement(ps);
		}
		return updateSeatsDec;
	}

	@Override
	public int updateSeatsEventInc(Event event) throws DAOException {
		PreparedStatement ps = null;
		int updateSeatsInc = 0;
		try {
			ps = myConnection.prepareStatement(FERSDbQuery
					.getUpdateSeatsEventInc());
			ps.setString(1, event.getName());
			updateSeatsInc = ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("fail updateSeatsEventInc");
		} finally {
			FERSDataConnection.closeStatement(ps);
		}
		return updateSeatsInc;
	}

}
