package net.franckbenault.iterator;


import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

public class PersonIterator implements Iterator<Person> {
	
	private static final Logger logger = Logger.getLogger(PersonIterator.class);
	

	private Person person;
	private StringIterator stringIterator;
	
	public PersonIterator(Set<String> fileNamesInput) throws IOException {
		logger.info("open file "+fileNamesInput);
		stringIterator = new StringIterator(fileNamesInput);
	    
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
		String line = stringIterator.next();
		boolean isValid = false;
		Person tempPerson =null;
		//return only valid person
		Person res = null;
		
		if(line!=null) {
			tempPerson = new Person(line);
			isValid = tempPerson.check();
			if(isValid)
				res = tempPerson;
		}
		
		
		while(!isValid && line!=null) {
			line = stringIterator.next();
			if(line!=null) {
				tempPerson = new Person(line);
				isValid = tempPerson.check();
				if(isValid)
					res = tempPerson;
			}
		}
		logger.info("tempPerson "+tempPerson+" "+isValid);
		return res;
	}
	
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException(); 		
	}
	
	
	public void close() {
		stringIterator.close();
	}

}
