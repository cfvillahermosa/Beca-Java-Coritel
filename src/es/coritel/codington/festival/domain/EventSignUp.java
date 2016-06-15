package es.coritel.codington.festival.domain;
/**
 * POJO class for EventSignUp
 */

public class EventSignUp {

	private int id; //identificador unico
	private int idVisitor; //id del visitante
	private int idEvent; //id del evento

	//Constructor vacio
	public EventSignUp(){}
		
	public EventSignUp(EventSignUp sign) {
		super();
		this.id = sign.id;
		this.idVisitor = sign.idVisitor;
		this.idEvent = sign.idEvent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdVisitor() {
		return idVisitor;
	}

	public void setIdVisitor(int idVisitor) {
		this.idVisitor = idVisitor;
	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + idEvent;
		result = prime * result + idVisitor;
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
		EventSignUp other = (EventSignUp) obj;
		if (id != other.id)
			return false;
		if (idEvent != other.idEvent)
			return false;
		if (idVisitor != other.idVisitor)
			return false;
		return true;
	}
	
	
}
