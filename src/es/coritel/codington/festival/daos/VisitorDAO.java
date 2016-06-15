package es.coritel.codington.festival.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.exceptions.DAOException;
import es.coritel.codington.festival.interfaces.daos.IVisitorDAO;
import es.coritel.codington.festival.utils.FERSDataConnection;
import es.coritel.codington.festival.utils.FERSDbQuery;

public class VisitorDAO implements IVisitorDAO {
	private Connection myConnection;

	public VisitorDAO(Connection conn) {

		myConnection = conn;
	}

	@Override
	public boolean insertData(Visitor visitor) throws DAOException {
		PreparedStatement ps = null;
		int inserts = 0;
		try {
			ps = myConnection.prepareStatement(FERSDbQuery.getInsertVisitor());
			ps.setInt(1, visitor.getVisitorId());
			ps.setString(2, visitor.getFirstName());
			ps.setString(3, visitor.getLastName());
			ps.setString(4, visitor.getDni());
			ps.setString(5, visitor.getEmail());
			ps.setString(6, visitor.getPhoneNumber());
			ps.setString(7, visitor.getAddress());
			ps.setString(8, visitor.getUserName());
			ps.setString(9, visitor.getPassword());
			ps.setBoolean(10, visitor.isAdmin());
			inserts = ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("fail insertData");
		} finally {
			FERSDataConnection.closeStatement(ps);
		}
		if (inserts > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Visitor searchUser(Visitor user) throws DAOException {
		PreparedStatement ps = null;
		Visitor aux = null;
		ResultSet resultSet = null;
		try {
			ps = myConnection.prepareStatement(FERSDbQuery.getSearchVisitor());
			ps.setString(1, user.getUserName());
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				aux = new Visitor();
				aux.setAddress(resultSet.getString("address"));
				aux.setDni(resultSet.getString("dni"));
				aux.setEmail(resultSet.getString("email"));
				aux.setFirstName(resultSet.getString("firstname"));
				aux.setLastName(resultSet.getString("lastname"));
				aux.setPassword(resultSet.getString("password"));
				aux.setPhoneNumber(resultSet.getString("phone_number"));
				aux.setUserName(resultSet.getString("username"));
				aux.setVisitorId(Integer.parseInt(resultSet.getString("id")));
			}
		} catch (SQLException e) {
			throw new DAOException("fail searchUser");
		} finally {
			FERSDataConnection.closeResulSet(resultSet);
			FERSDataConnection.closeStatement(ps);
		}
		return aux;
	}

	@Override
	public int updateVisitor(Visitor visitor) throws DAOException {
		int updates = 0;
		PreparedStatement ps = null;
		try {
			ps = myConnection.prepareStatement(FERSDbQuery.getUpdateVisitor());
			ps.setInt(1, visitor.getVisitorId());
			ps.setString(2, visitor.getFirstName());
			ps.setString(3, visitor.getLastName());
			ps.setString(4, visitor.getDni());
			ps.setString(5, visitor.getEmail());
			ps.setString(6, visitor.getPhoneNumber());
			ps.setString(7, visitor.getAddress());
			ps.setString(8, visitor.getUserName());
			ps.setBoolean(9, visitor.isAdmin());
			ps.setInt(10, visitor.getVisitorId());
			updates = ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("fail updateVisitor");
		} finally {
			FERSDataConnection.closeStatement(ps);
		}
		return updates;
	}

	@Override
	public int changePassword(Visitor visitor) throws DAOException {
		PreparedStatement ps = null;
		int changes = 0;
		try {
			ps = myConnection.prepareStatement(FERSDbQuery.getChangePWDQuery());
			ps.setString(1, visitor.getPassword());
			ps.setInt(2, visitor.getVisitorId());
			changes = ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("fail changePassword");
		} finally {
			FERSDataConnection.closeStatement(ps);
		}
		return changes;
	}

}
