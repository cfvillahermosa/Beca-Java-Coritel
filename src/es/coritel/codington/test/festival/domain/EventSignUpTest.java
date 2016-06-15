package es.coritel.codington.test.festival.domain;

import junit.framework.TestCase;
import es.coritel.codington.festival.domain.EventSignUp;
import es.coritel.codington.festival.exceptions.DomainException;

public class EventSignUpTest extends TestCase {
	
	EventSignUp sign;
	public static final int ID_VALIDO=1; // identificador unico
	public static final int ID_VISITOR=1; // id del visitante
	public static final int ID_EVENTO=1; // id del evento


	protected void setUp() throws Exception {
		super.setUp();
		sign = new EventSignUp();
		sign.setId(ID_VALIDO);
	    sign.setIdEvent(ID_EVENTO);
	    sign.setIdVisitor(ID_VISITOR);
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetId() 
	{
		assertEquals(ID_VALIDO,sign.getId());
		
	}

	public void testSetId() 
	{
		sign.setId(ID_VALIDO);
		assertEquals(ID_VALIDO,sign.getId());
		
		assertFailEventId(0);

		
	}
	
	private void assertFailEventId(int id){
		try {
			sign.setId(id);
		} catch (DomainException e) {
			System.out.println("ID no valido");
		}
	}

	//----------------------------------------------
	public void testGetIdVisitor()
	{
		assertEquals(ID_VISITOR,sign.getIdVisitor());

		
	}

	public void testSetIdVisitor() 
	{
		 sign.setIdEvent(ID_VISITOR);
		 assertEquals(ID_VISITOR,sign.getIdVisitor());
		
	}
	

	
	//--------------------------------------------------

	public void testGetIdEvent() 
	{
		assertEquals(ID_EVENTO,sign.getIdEvent());
		
	}

	public void testSetIdEvent() 
	{
		  sign.setIdVisitor(ID_EVENTO);
		  assertEquals(ID_EVENTO,sign.getIdEvent());
		  
		  
		  assertFailIdEvent(0);
		
	}
	
	
	private void assertFailIdEvent(int id){
		try {
			sign.setIdEvent(id);
		} catch (DomainException e) {
			System.out.println("ID EVENTO no valido");
		}
	}
	
	//_----------------------------------------------

	public void testEventSignUp()
	{
		
		EventSignUp e= new EventSignUp(sign);
		assertEquals(e,sign);
		
		
	}

}
