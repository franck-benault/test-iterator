package net.franckbenault.iterator;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Sample2Test {

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
		Sample2 sample = null;
		try {
			sample = new Sample2("../sample2/src/main/resources/file1.txt");
			int counter = 0;
			
			while(sample.hasNext()) {
				assertNotNull(sample.next());
				counter++;
			}
			assertEquals(counter,4L);
		} finally {
			sample.close();
		}
		
	}
	
	/*
	 * test with file2
	 * file with several lines in comment
	 */
	@Test
	public void testWithFile2() throws IOException  {
		Sample2 sample = null;
		try {
			sample = new Sample2("../sample2/src/main/resources/file2.txt");
			int counter = 0;
			
			while(sample.hasNext()) {
				assertNotNull(sample.next());
				counter++;
			}
			assertEquals(counter,3L);
		} finally {
			sample.close();
		}	
	}

	/*
	 * test with file3
	 * file with all lines in comment
	 */
	@Test
	public void testWithFile3() throws IOException  {
		Sample2 sample = null;
		try {
			sample = new Sample2("../sample2/src/main/resources/file3.txt");
			int counter = 0;
			
			while(sample.hasNext()) {
				assertNotNull(sample.next());
				counter++;
			}
			assertEquals(counter,0L);
		} finally {
			sample.close();
		}	
	}
	
	@Test(expected=IOException.class)
	public void testWithWrongFile() throws IOException  {
		
		new Sample2("WrongFileName");


		
	}
}
