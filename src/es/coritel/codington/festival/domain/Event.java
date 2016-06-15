package es.coritel.codington.festival.domain;

import es.coritel.codington.festival.exceptions.DomainException;
import es.coritel.codington.festival.utils.Validator;

/**
 * POJO class for Event
 */
public class Event {
	private static final int minLength=1;
	private static final int maxLength=45;
	
	private int eventId;// Identificador del evento

	private String name;// Nombre del evento

	private String description;// Descripción del evento

	private String place;// Lugar del evento

	private String duration;// Duración del evento

	private String eventType;// Tipo de evento

	private int seatsAEvent;// Asientos disponibles en el evento
	
	
	/**
	 * Constructor por defecto de Event, crea un evento vacio
	 */
	public Event(){}
	
	/**
	 * Constructor de copia, crea un objeto Event copiando los atributos de otro
	 * 
	 * @param event	Evento que se va a copiar
	 */
	public Event(Event event) {
		super();
		this.eventId = event.eventId;
		this.name = event.name;
		this.description = event.description;
		this.place = event.place;
		this.duration = event.duration;
		this.eventType = event.eventType;
		this.seatsAEvent = event.seatsAEvent;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		if (Validator.checkLength(minLength, maxLength,name)){
			this.name = name;
		}
		else{
			throw new DomainException("Invalid Name Event");
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (Validator.checkLength(minLength, maxLength,description)){
			this.description = description;
		}
		else
		{
			throw new DomainException("Invalid Description Event");
		}
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		if (Validator.checkLength(minLength, maxLength,place)){
			this.place = place;
		}
		else
		{
			throw new DomainException("Invalid Place Event");
		}
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		if (Validator.checkLength(minLength, maxLength,duration)){
			this.duration = duration;
		}
		else{
			throw new DomainException("Invalid Duration Event");
		}
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		if (Validator.checkLength(minLength, maxLength,eventType)){
			this.eventType= eventType;
		}
		else{
			throw new DomainException("Invalid eventType Event");
		}
	}

	public int getSeatsAEvent() {
		return seatsAEvent;
	}

	public void setSeatsAEvent(int seatsAEvent) {
		if(seatsAEvent >= 0){
			this.seatsAEvent = seatsAEvent;
		}
		else{
			throw new DomainException ("Invalid number of seats");
			}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + eventId;
		result = prime * result
				+ ((eventType == null) ? 0 : eventType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + seatsAEvent;
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
		Event other = (Event) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (eventId != other.eventId)
			return false;
		if (eventType == null) {
			if (other.eventType != null)
				return false;
		} else if (!eventType.equals(other.eventType))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		if (seatsAEvent != other.seatsAEvent)
			return false;
		return true;
	}
	
	
}