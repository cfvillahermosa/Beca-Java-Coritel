package es.coritel.codington.festival.interfaces.daos;
/**
 * SEQUENCER INTERFACE for defining abstract for SEQUENCERDAO
 */
public interface ISequencerDAO {
	
	public static final String CLASS_EVENT_NAME ="event";
	public static final String CLASS_VISITOR_NAME ="visitor";
	public static final String CLASS_EVENT_SIGNUP_NAME ="event_signup";
	/**
	 * Method that returns the next id assigned to the table whose name 
	 * is passed as parameter
	 * @param nameclass
	 * @return nextId
	 */
	public int getNext(String classname);

}
