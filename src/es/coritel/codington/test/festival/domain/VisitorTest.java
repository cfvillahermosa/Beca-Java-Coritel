package es.coritel.codington.test.festival.domain;

import junit.framework.TestCase;
import es.coritel.codington.festival.domain.Visitor;
import es.coritel.codington.festival.exceptions.DomainException;

public class VisitorTest extends TestCase {

	/*
	 * VISITOR CONSTANTS
	 * */
	Visitor visitor;
	public static final String VALID_PASSWORD="validpassword";
	public static final String NOT_VALID_PASSWORD="this.is.not.a.valid.password";
	public static final int VALID_ID_VISITOR=2345474;
	public static final int NOT_VALID_ID_VISITOR=500000000;
	public static final String VALID_USERNAME="Charly1990";
	public static final String NOT_VALID_USERNAME="thisisnotavalidusername";
	public static final boolean VALID_ADMIN=true;
	
	/*
	 * PEOPLE CONSTANTS
	 * */
	
	public static final String VALID_FIRSTNAME="Carlos";
	public static final String VALID_LASTNAME="Fernandez";
	public static final String VALID_DNI="76.087.176-N";
	public static final String VALID_EMAIL="cfvillahermosa@gmail.com";
	public static final String VALID_PHONE_NUMBER="91234567890";
	public static final String VALID_ADDRESS="benito gutierrez";
    
	
	
	

	
	protected void setUp() throws Exception {
		super.setUp();
		visitor = new Visitor();
		visitor.setPassword(VALID_PASSWORD);
		visitor.setAdmin(VALID_ADMIN);
		visitor.setVisitorId(VALID_ID_VISITOR);
		visitor.setUserName(VALID_USERNAME);
		visitor.setFirstName(VALID_FIRSTNAME);
		visitor.setLastName(VALID_LASTNAME);
		visitor.setDni(VALID_DNI);
		visitor.setEmail(VALID_EMAIL);
		visitor.setPhoneNumber(VALID_PHONE_NUMBER);
		visitor.setAddress(VALID_ADDRESS);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}



	public void testGetVisitorId() {
  
		assertEquals(VALID_ID_VISITOR,visitor.getVisitorId());
	
	}

	public void testSetVisitorId() {
 
		visitor.setVisitorId(VALID_ID_VISITOR);
		assertEquals(VALID_ID_VISITOR,visitor.getVisitorId());

		try{
			visitor.setVisitorId(NOT_VALID_ID_VISITOR);
		}catch(DomainException e){
			System.out.println("Not valid ID");
		}
	  
	}

	public void testGetUserName() {

		assertEquals(VALID_USERNAME, visitor.getUserName());
	
	}

	public void testSetUserName() {
		
		visitor.setUserName(VALID_USERNAME);
		assertEquals(VALID_USERNAME, visitor.getUserName());
 
		try{
			visitor.setUserName(NOT_VALID_USERNAME);
			
		}catch(DomainException e){
			System.out.println("Not valid USERNAME"); 
		}
		

	
		
	}

	public void testGetPassword() {

		assertEquals(VALID_PASSWORD, visitor.getPassword());

	}

	public void testSetPassword() {
	    visitor.setPassword(VALID_PASSWORD);
		assertEquals(VALID_PASSWORD,visitor.getPassword());
		
		try{
			visitor.setPassword(NOT_VALID_PASSWORD);
			fail("No exception throwable");
			
		}catch(DomainException e){
			System.out.println("Not valid PASSWORD");
		}

	}

	public void testIsAdmin() {

		assertEquals(VALID_ADMIN, visitor.isAdmin());
	
	}

	public void testSetAdmin() {

		visitor.setAdmin(VALID_ADMIN);
		assertEquals(VALID_ADMIN, visitor.isAdmin());
		try{
			visitor.setAdmin(false);
		}catch(DomainException e){
		System.out.println("Not Valid ADMIN");
		}
	}


	
	
	
	
	
	/*
	 * PEOPLE TEST CASES
	 * */

	public void testGetFirstName() {
		assertEquals(VALID_FIRSTNAME,visitor.getFirstName());
	}

	public void testSetFirstName() {

		visitor.setFirstName(VALID_FIRSTNAME);	
		assertEquals(VALID_FIRSTNAME,visitor.getFirstName());
        
		try{
			visitor.setFirstName("MiguelCarrascowe");
		}catch(DomainException e){
			System.out.println("Not valid FIRSTNAME");
		}
		
	}

	public void testGetLastName() {

		assertEquals(VALID_LASTNAME,visitor.getLastName());
	
	}

	public void testSetLastName() {
		visitor.setLastName(VALID_LASTNAME);
		assertEquals(VALID_LASTNAME,visitor.getLastName());
		try{
			visitor.setLastName("jfhsjhfjsdhfjksdhfkjhsdkjfhsd");
		}catch(DomainException e){
			System.out.println("Not valid LASTNAME");
		}

	}

	public void testGetDni() {

		assertEquals(VALID_DNI,visitor.getDni());
		
	}

	public void testSetDni() {
		visitor.setDni(VALID_DNI);
		assertFailDni("89765478N");
		assertFailDni("89765478");
		assertFailDni("89 765 478 N");
		assertFailDni("8.057.38.79-N");
	}

	private void assertFailDni(String dni){
		try {
			visitor.setDni(dni);
		} catch (DomainException e) {
			System.out.println("Not valid DNI");
		}
	}
	
	
	public void testGetEmail() {

	
		assertEquals(VALID_EMAIL,visitor.getEmail());
	}

	public void testSetEmail() {
		visitor.setEmail(VALID_EMAIL);
		assertEquals(VALID_EMAIL,visitor.getEmail());
		assertFailEmail("failemail@@@llklk");
		assertFailEmail("cfvillahermosa.@gmail");
		assertFailEmail("cfvillahermosa@");

	}
	
	private void assertFailEmail(String email){
		try {
			visitor.setEmail(email);
		} catch (DomainException e) {
			System.out.println("Not valid DNI");
		}
	}
	

	public void testGetPhoneNumber() {
		
		assertEquals(VALID_PHONE_NUMBER,visitor.getPhoneNumber());
	}

	public void testSetPhoneNumber() {
		visitor.setPhoneNumber(VALID_PHONE_NUMBER);
		assertEquals(VALID_PHONE_NUMBER,visitor.getPhoneNumber());
        
		assertFailPhoneNumber("111111111");
		assertFailPhoneNumber("1111111111111111111111111");

		
	}
	
	private void assertFailPhoneNumber(String phone){
		try {
			visitor.setEmail(phone);
		} catch (DomainException e) {
			System.out.println("Phone number no valido");
		}
	}

	
	
	
	public void testGetAddress() {
	
		assertEquals(VALID_ADDRESS,visitor.getAddress());

	}

	public void testSetAddress() {
		
		visitor.setAddress(VALID_ADDRESS);
		assertEquals(VALID_ADDRESS,visitor.getAddress());

		assertFailAddress("thisisafailadresssssssssssssss");
		assertFailAddress("");
	
	}

	
	private void assertFailAddress(String address){
		try {
			visitor.setEmail(address);
		} catch (DomainException e) {
			System.out.println("Not valid PHONE NUMBER");
		}
	}
	

}
