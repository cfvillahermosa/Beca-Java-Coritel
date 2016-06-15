package es.coritel.codington.festival.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.coritel.codington.festival.exceptions.DAOException;
import es.coritel.codington.festival.interfaces.daos.ISequencerDAO;
import es.coritel.codington.festival.utils.FERSDataConnection;
import es.coritel.codington.festival.utils.FERSDbQuery;

public class SequencerDAO implements ISequencerDAO {
	private Connection myConnection;
	public SequencerDAO(Connection conn) {
		myConnection = conn;
	}

	@Override
	public int getNext(String classname) {
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		int nextId = 0;
		try {
			ps = myConnection.prepareStatement(FERSDbQuery.getSequencerActual());
			resultSet = ps.executeQuery();
			if(resultSet.first())
			nextId = Integer.parseInt(resultSet.getString("id"));
		} catch (SQLException e) {
			throw new DAOException("fail getNext");
		}
		finally{
			FERSDataConnection.closeResulSet(resultSet);
			FERSDataConnection.closeStatement(ps);
		}
		return nextId;
	}
	
}
