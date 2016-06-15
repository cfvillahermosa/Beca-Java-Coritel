package es.coritel.codington.festival.exceptions;

/**
 * Clase que representan las excepciones que ser�n lanzadas en la capa de Dominio
 * 
 */
@SuppressWarnings("serial")
public class DomainException extends RuntimeException {
	public DomainException(String message){
		super(message);
	}
}
