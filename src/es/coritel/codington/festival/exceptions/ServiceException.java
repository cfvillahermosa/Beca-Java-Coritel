package es.coritel.codington.festival.exceptions;
/**
 * Clase que representan las excepciones que serán lanzadas en la capa de Servicios
 *
 */
@SuppressWarnings("serial")
public class ServiceException extends RuntimeException {
	
	public ServiceException(String message){
		super(message);
	}
}
