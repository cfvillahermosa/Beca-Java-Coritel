package es.coritel.codington.festival.interfaces.daos;

import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.exceptions.DAOException;

public interface IVisitorDAO {

	/**
	 * DAO method to loading visitor details into VISITOR table in database
	 * and validating about existing visitor details.
	 * 
	 * @param visitor
	 * @return
	 * @throws DAOException
	 * 
	 */
	public boolean insertData(Visitor visitor) throws DAOException;
	

	/**
	 * DAO method for searching for visitor details using USERNAME
	 *  
	 * @param visitor
	 * @return
	 * @throws DAOException

	
	 */
	public Visitor searchUser(Visitor user) throws DAOException;
		
		

	/**
	 * DAO method to update visitor with additional information
	 * 
	 * @param visitor
	 * @return
	 * @throws DAOException
	
	 */
	public int updateVisitor(Visitor visitor) throws DAOException;
		
	
	/**
	 * DAO method to update visitor password information
	 * 
	 * @param visitor
	 * @return
	 * @throws DAOException 
	 */
	public int changePassword(Visitor visitor) throws DAOException; 

		


}
