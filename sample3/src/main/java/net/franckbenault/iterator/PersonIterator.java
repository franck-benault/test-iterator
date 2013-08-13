package net.franckbenault.iterator;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;

public class PersonIterator implements Iterator<Person> {
	
	private static final Logger logger = Logger.getLogger(PersonIterator.class);
	

	private Person person;
	private StringIterator stringIterator;
	
	public PersonIterator(String fileNameInput) throws IOException {
		logger.info("open file "+fileNameInput);
		stringIterator = new StringIterator(fileNameInput);
	    
	    person = getNextValidPerson(); 
	    
	}

	@Override
	public boolean hasNext() {
		return person!=null;
	}

	@Override
	public Person next() {
		Person tempPerson = person;
		
		person = getNextValidPerson(); 
		return tempPerson;
	}
	
	

	
	private Person getNextValidPerson() {
		Person tempPerson = new Person(stringIterator.next());
		
		boolean isValid = person.check();
		//logger.info("check "+tempLine+" "+isValid);
		
		while(!isValid && person!=null) {
			tempPerson = new Person(stringIterator.next());
			isValid = person.check();
		}
		return person;
	}
	
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException(); 		
	}
	
	
	public void close() {
		stringIterator.close();
	}

}
