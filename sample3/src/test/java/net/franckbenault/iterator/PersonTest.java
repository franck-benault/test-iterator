package net.franckbenault.iterator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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

	/*
	 * input string without separator
	 */
	@Test
	public void testPerson0()  {
		Person person =new Person("AABB34");
		assertNotNull(person);
		assertTrue(!person.check());
	}
	
	/*
	 * input string with only one separator
	 */
	@Test
	public void testPerson0bis()  {
		Person person =new Person("AA:BB34");
		assertNotNull(person);
		assertTrue(!person.check());
	}
	
	@Test
	public void testPerson1()  {
		Person person =new Person("AA:BB:34");
		assertNotNull(person);
		assertTrue(person.check());
	}
	
	@Test
	public void testPersonNullInput()  {
		Person person =new Person(null);
		assertNotNull(person);
		assertTrue(!person.check());
	}
	
	@Test
	public void testPersonWrongAgeNull()  {
		Person person =new Person("AA:BB:E4");
		assertNotNull(person);
		assertNull(person.getAge());
		assertTrue(!person.check());
	}
	
	@Test
	public void testPersonWrongAgeNegative()  {
		Person person =new Person("AA:BB:-4");
		assertNotNull(person);
		assertNotNull(person.getAge());
		assertTrue(!person.check());
	}
	
	@Test
	public void testPersonWrongAgeTooOld()  {
		Person person =new Person("AA:BB:140");
		assertNotNull(person);
		assertNotNull(person.getAge());
		assertTrue(!person.check());
	}
}
