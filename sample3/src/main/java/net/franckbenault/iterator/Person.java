package net.franckbenault.iterator;

import org.apache.log4j.Logger;

public class Person {
	
	private static final Logger logger = Logger.getLogger(Person.class);
	
	private String firstName;
	
	private String lastName;
	
	private Integer age;
	
	public Person(String line) {
		String tab[] = null;
		if(null!=line)
			tab = line.split(":");
		
		if(tab!=null)
			firstName=tab[0];
		if(tab!=null && tab.length>=1)
			lastName=tab[1];
		if(tab!=null && tab.length>=2)
			try {
				age=Integer.valueOf(tab[2]);
			} catch (java.lang.NumberFormatException e) {
				logger.error(e);
			}
			
		
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}
	
	public boolean check() {
		if(age==null)
			return false;
		
		if (firstName==null)
			return false;

		if (lastName==null)
			return false;
		
		return true;
	}

}
