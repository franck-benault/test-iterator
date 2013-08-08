package net.franckbenault.iterator.sample1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Sample1Test {

	
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
	public void test() {
		Sample1 sample = new Sample1();
		int counter = 0;
		
		while(sample.hasNext()) {
			assertNotNull(sample.next());
			counter++;
		}
		assertEquals(counter,3L);
	}

}
