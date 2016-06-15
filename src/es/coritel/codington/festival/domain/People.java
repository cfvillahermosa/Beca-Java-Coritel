package es.coritel.codington.festival.domain;

import es.coritel.codington.festival.exceptions.DomainException;
import es.coritel.codington.festival.utils.Validator;

/**
 * POJO for PEOPLE class which is PARENT CLASS for Visitor
 */
public class People {
	private static final int MIN_LENGTH_EMAIL = 3;
	private static final int MAX_LENGTH_EMAIL = 200;
	private static final int MIN = 1;
	private static final int MAX = 30;

	private String firstName; // Nombre

	private String lastName; // Apellido

	private String dni; // dni

	private String email; // Correo electrónico

	private String phoneNumber; // Número de teléfono 
		
	private String address;//Dirección 
	
	
	/**
	 * Constructor por defecto de una persona, crea una persona vacia
	 */
	public People(){
		
	}
	
	/**
	 * Constructor de copia, crea un objeto People copiando los atributos de otro
	 * 
	 * @param people	Persona que se va a copiar
	 */
	public People(People people){}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(Validator.checkLength(MIN, MAX, firstName)){
			this.firstName = firstName;
		}
		else
		{
			throw new DomainException("Invalid First Name");
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(Validator.checkLength(MIN, MAX, lastName)){
			this.lastName = lastName;
		}
		else
		{
			throw new DomainException("Invalid Last Name");
		}
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		if(Validator.checkDni(dni)){
			this.dni = dni;
		}
		else{
			throw new DomainException("Invalid dni");
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		boolean checkedEmail=(Validator.checkEmail(email,MIN_LENGTH_EMAIL,MAX_LENGTH_EMAIL));
		if(checkedEmail){
			this.email = email;
		}
		else
		{
			throw new DomainException("Invalid email");
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		boolean checkedPhoneNumber = (Validator.checkPhoneNumber(phoneNumber));
		if(checkedPhoneNumber){
			this.phoneNumber = phoneNumber;
		}
		else
		{
			throw new DomainException("Invalid Phone Number");
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		boolean checkedAddress = (Validator.checkLength(MIN, MAX, address));
		if(checkedAddress){
			this.address = address;
		}
		else
		{
			throw new DomainException("Invalid address");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		People other = (People) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}
	
	
}
