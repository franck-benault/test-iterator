package net.franckbenault.iterator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class PersonTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testPerson1()  {
		Person person =new Person("AA:BB:34");
		assertNotNull(person);
		
	}
	
	@Test
	public void testPersonNullInput()  {
		Person person =new Person(null);
		assertNotNull(person);
		
	}
}
