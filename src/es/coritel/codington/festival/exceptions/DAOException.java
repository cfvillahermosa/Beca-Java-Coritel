package es.coritel.codington.festival.exceptions;

/**
 * Clase que representan las excepciones que serán lanzadas en la capa de DAOs
 *
 */
@SuppressWarnings("serial")
public class DAOException extends RuntimeException {

	public DAOException(String message){
		super(message);
	}

}
