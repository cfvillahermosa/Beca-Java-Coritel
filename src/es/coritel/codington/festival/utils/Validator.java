package es.coritel.codington.festival.utils;

/**
 * Clase que maneja las validaciones de los formatos de los datos de la
 * aplicación
 * 
 */
public class Validator {

	public Validator() {
	}

	public static boolean checkPhoneNumber(String phoneNumber) {
		boolean internacional = (phoneNumber.matches("^\\+[0-9]{10,20}"));
		boolean nacional = (phoneNumber.matches("[0-9]{10,20}"));
		if (nacional || internacional ) {
			return true;
		} 
		else
		{
			return false;
		}
	}

	public static boolean checkDni(String dni) {
		boolean dniMatches = dni.matches("[0-9]{2}+.+[0-9]{3}+.+[0-9]{3}+-+[A-Za-z]");
		if (dniMatches) {
			return true;
		}

		else{
			return false;
		}
	}

	public static boolean checkLength(int min, int max, String stringCheckLength) {
		boolean minimum =(stringCheckLength.length() >= min);
		boolean maximum = (stringCheckLength.length() <= max);
		if (minimum && maximum){
			return true;
		}
		else{
			return false;
		}
	}

	public static boolean checkIsNumber(String checkNumber) {
		try {
			Long.parseLong(checkNumber);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static boolean checkEmail(String email,int min,int max) {
		boolean emailMatches= (email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"));
		boolean length = (checkLength(min, max, email));
		if (emailMatches && length){
			return true;
		}
		else{
			return false;
		}
	}


}
