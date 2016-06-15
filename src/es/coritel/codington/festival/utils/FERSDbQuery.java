package es.coritel.codington.festival.utils;

/**
 * Helper class for externalization of queries
 */
public class FERSDbQuery {
	
	// SQL queries for EVENTDAO
	private static String allEvents= "SELECT *  FROM events"; //Obtiene todos los eventos de la tabla events
	private static String searchByEventName = "SELECT * FROM events WHERE name = ?" ;	//Obtiene un evento buscando por su nombre (búsqueda parcial)
	private static String updateSeatsEventDec = "UPDATE events SET seats_available = seats_available-1 WHERE name = ?"; //Decrementa el número de asientos disponibles para un evento dado
	private static String updateSeatsEventInc="UPDATE events SET seats_available = seats_available+1 WHERE name = ?";	//Incrementa el número de asientos disponibles para un evento dado
	private static  String getEvent="SELECT * FROM events WHERE id = ?"; //Obtiene un evento por su id
	private static String updateEvent="UPDATE events SET id=?,name=?,description=?,places=?,duration=?,event_type=?,seats_available=?";	//actualiza un evento
	private static String insertEvent = "INSERT INTO events (id,name,description,places,duration,event_type,seats_available) VALUES(?,?,?,?,?,?,?)";//inserta un evento
	private static String deleteEvent = "DELETE FROM events WHERE id=?"; //borra un evento 


	// SQL queries for VISITORDAO
	private static String insertVisitor = "INSERT INTO visitors VALUES (?,?,?,?,?,?,?,?,?,?)"; //Inserta un visitante
	private static String searchVisitor = "SELECT * FROM visitors WHERE username = ?"; //Busca un visitante por username
	private static String updateVisitor= "UPDATE visitors SET id=?,firstname=?,lastname=?,dni=?,email=?,phone_number=?,address=?,username=?,isadmin=?"; //Actualiza los datos de un visitante (A excepción de la password)
	private static String changePWDQuery= "UPDATE visitors SET password = ?"; //actualiza la password de un visitante dado
	
	//SQL queries for EVENTSIGNUPDAO
	private static String registerVisitorToEvent= "INSERT INTO events_signup VALUES (?,?,?)"; //Crea un nuevo registro en la tabla signup
	private static String deleteEventSessionSignup = "DELETE FROM events_signup WHERE event_id = ?"; //Borra las ocurrencias de un evento de la tabla signup
	private static String checkEvent = "SELECT * FROM events_signup WHERE visitor_id = ?" ;//Comprueba si un visitante está registrado a un evento
	private static String eventsRegistered= "SELECT E.* FROM EVENTS E, EVENTS_SIGNUP ES WHERE ES.EVENT_ID = E.ID";//Obtiene todos los eventos en los que está registrado un visitante dado

	private static String unRegisterVisitorToEvent = "DELETE FROM events_signup WHERE visitor_id = ? AND event_id = ?" ;//Borra el registro de la tabla signup para un visitante y evento dado
	
	
	//SQL queries for SEQUENCERDAO
	private static String sequencerActual = "SELECT * FROM sequencer  ORDER BY id DESC LIMIT 1"; //Obtiene el ultimo id asignado de la tabla sequencer
	private static String actualizaSequencer= "UPDATE sequencer SET id = id+1 WHERE id = (SELECT MAX(id) FROM sequencer)"; //Actualiza la tabla sequence para incrementar el último id asignado
	public static String getAllEvents() {
		return allEvents;
	}
	public static void setAllEvents(String allEvents) {
		FERSDbQuery.allEvents = allEvents;
	}
	public static String getSearchByEventName() {
		return searchByEventName;
	}
	public static void setSearchByEventName(String searchByEventName) {
		FERSDbQuery.searchByEventName = searchByEventName;
	}
	public static String getUpdateSeatsEventDec() {
		return updateSeatsEventDec;
	}
	public static void setUpdateSeatsEventDec(String updateSeatsEventDec) {
		FERSDbQuery.updateSeatsEventDec = updateSeatsEventDec;
	}
	public static String getUpdateSeatsEventInc() {
		return updateSeatsEventInc;
	}
	public static void setUpdateSeatsEventInc(String updateSeatsEventInc) {
		FERSDbQuery.updateSeatsEventInc = updateSeatsEventInc;
	}
	public static String getGetEvent() {
		return getEvent;
	}
	public static void setGetEvent(String getEvent) {
		FERSDbQuery.getEvent = getEvent;
	}
	public static String getUpdateEvent() {
		return updateEvent;
	}
	public static void setUpdateEvent(String updateEvent) {
		FERSDbQuery.updateEvent = updateEvent;
	}
	public static String getInsertEvent() {
		return insertEvent;
	}
	public static void setInsertEvent(String insertEvent) {
		FERSDbQuery.insertEvent = insertEvent;
	}
	public static String getDeleteEvent() {
		return deleteEvent;
	}
	public static void setDeleteEvent(String deleteEvent) {
		FERSDbQuery.deleteEvent = deleteEvent;
	}
	public static String getInsertVisitor() {
		return insertVisitor;
	}
	public static void setInsertVisitor(String insertVisitor) {
		FERSDbQuery.insertVisitor = insertVisitor;
	}
	public static String getSearchVisitor() {
		return searchVisitor;
	}
	public static void setSearchVisitor(String searchVisitor) {
		FERSDbQuery.searchVisitor = searchVisitor;
	}
	public static String getUpdateVisitor() {
		return updateVisitor;
	}
	public static void setUpdateVisitor(String updateVisitor) {
		FERSDbQuery.updateVisitor = updateVisitor;
	}
	public static String getChangePWDQuery() {
		return changePWDQuery;
	}
	public static void setChangePWDQuery(String changePWDQuery) {
		FERSDbQuery.changePWDQuery = changePWDQuery;
	}
	public static String getRegisterVisitorToEvent() {
		return registerVisitorToEvent;
	}
	public static void setRegisterVisitorToEvent(String registerVisitorToEvent) {
		FERSDbQuery.registerVisitorToEvent = registerVisitorToEvent;
	}
	public static String getDeleteEventSessionSignup() {
		return deleteEventSessionSignup;
	}
	public static void setDeleteEventSessionSignup(String deleteEventSessionSignup) {
		FERSDbQuery.deleteEventSessionSignup = deleteEventSessionSignup;
	}
	public static String getCheckEvent() {
		return checkEvent;
	}
	public static void setCheckEvent(String checkEvent) {
		FERSDbQuery.checkEvent = checkEvent;
	}
	public static String getEventsRegistered() {
		return eventsRegistered;
	}
	public static void setEventsRegistered(String eventsRegistered) {
		FERSDbQuery.eventsRegistered = eventsRegistered;
	}
	public static String getUnRegisterVisitorToEvent() {
		return unRegisterVisitorToEvent;
	}
	public static void setUnRegisterVisitorToEvent(String unRegisterVisitorToEvent) {
		FERSDbQuery.unRegisterVisitorToEvent = unRegisterVisitorToEvent;
	}
	public static String getSequencerActual() {
		return sequencerActual;
	}
	public static void setSequencerActual(String sequencerActual) {
		FERSDbQuery.sequencerActual = sequencerActual;
	}
	public static String getActualizaSequencer() {
		return actualizaSequencer;
	}
	public static void setActualizaSequencer(String actualizaSequencer) {
		FERSDbQuery.actualizaSequencer = actualizaSequencer;
	}

	
	

	
	

}
