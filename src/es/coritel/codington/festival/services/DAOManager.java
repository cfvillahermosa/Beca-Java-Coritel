package es.coritel.codington.festival.services;

import java.sql.Connection;

import es.coritel.codington.festival.daos.EventDAO;
import es.coritel.codington.festival.daos.EventSignUpDAO;
import es.coritel.codington.festival.daos.VisitorDAO;
import es.coritel.codington.festival.interfaces.daos.IEventDAO;
import es.coritel.codington.festival.interfaces.daos.IEventSignUpDAO;
import es.coritel.codington.festival.interfaces.daos.IVisitorDAO;
import es.coritel.codington.festival.utils.FERSDataConnection;

/**
 * Clase que crea las instancias de los daos con una conexion 
 * para tratar transacciones
 * 
 * @author Coritel
 *
 */
public class DAOManager {

	//Conexion de la base de datos
	private Connection conn;
	
	//Constructor 
	public DAOManager()   
	{
		conn = FERSDataConnection.getConnection();
	}
	/**
	 * m�todo que devuelve una instancia de un IEVentDAO
	 * 
	 * @return IEventDAO
	 */
	public IEventDAO getEventDAO()
	{
		return new EventDAO(conn);
		

	}
	/**
	 * m�todo que devuelve una instancia de un IVisitorDAO
	 * 
	 * @return IVisitorDAO
	 */
	public IVisitorDAO getVisitorDAO()
	{
		return new VisitorDAO(conn);
	}
	
	/**
	 * m�todo que devuelve una instancia de un EventSignUp
	 * 
	 * @return IEventSignUp
	 */
	public IEventSignUpDAO getEventSignUpDAO()
	{
		return new EventSignUpDAO(conn);
	}
	
	/**
	 * m�todo que hace commit y cierra la conexion
	 * 
	 */
	public void closeOK()
	{
		FERSDataConnection.commit(conn);
		FERSDataConnection.closeConnection(conn);
		
	}
	/**
	 * m�todo que hace rollback y cierra la conexion
	 * 
	 */
	public void closeError()
	{
		FERSDataConnection.rollback(conn);
		FERSDataConnection.closeConnection(conn);
		
	}
}
