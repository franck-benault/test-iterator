package net.franckbenault.iterator;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonIteratorTest {

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
	 * test with File1 no comment
	 */
	@Test
	public void testWithFile1() throws IOException  {
		PersonIterator iterator = null;
		try {
			Set<String> fileNames = new HashSet<String>();
			fileNames.add("../sample4/src/main/resources/file1.txt");
			iterator = new PersonIterator(fileNames);
			int counter = 0;
			
			while(iterator.hasNext()) {
				assertNotNull(iterator.next());
				counter++;
			}
			assertEquals(counter,4L);
		} finally {
			iterator.close();
		}
		
	}
	
	/*
	 * test with file2
	 * file with several lines in comment
	 */
	@Test
	public void testWithFile2() throws IOException  {
		PersonIterator iterator = null;
		try {
			Set<String> fileNames = new HashSet<String>();
			fileNames.add("../sample4/src/main/resources/file2.txt");
			iterator = new PersonIterator(fileNames);
			int counter = 0;
			
			while(iterator.hasNext()) {
				Person person = iterator.next();
				System.out.println(person);
				assertNotNull(person);
				counter++;
			}
			assertEquals(counter,1L);
		} finally {
			iterator.close();
		}	
	}

	/*
	 * test with file3
	 * file with all lines in comment
	 */
	@Test
	public void testWithFile3() throws IOException  {
		PersonIterator iterator = null;
		try {
			Set<String> fileNames = new HashSet<String>();
			fileNames.add("../sample4/src/main/resources/file3.txt");
			iterator = new PersonIterator(fileNames);
			int counter = 0;
			
			while(iterator.hasNext()) {
				assertNotNull(iterator.next());
				counter++;
			}
			assertEquals(counter,0L);
		} finally {
			iterator.close();
		}	
	}
	
	@Test(expected=IOException.class)
	public void testWithWrongFile() throws IOException  {
		Set<String> fileNames = new HashSet<String>();
		fileNames.add("WrongFileName");
		new PersonIterator(fileNames);	



		
	}
}
