package net.franckbenault.iterator;

public class Person {
	
	private String firstName;
	
	private String lastName;
	
	private int age;
	
	public Person(String line) {
		String tab[] = null;
		if(null!=line)
			tab = line.split(":");
		
		if(tab!=null)
			firstName=tab[0];
		if(tab!=null && tab.length>=1)
			lastName=tab[1];
		if(tab!=null && tab.length>=2)
			age=Integer.valueOf(tab[2]);
		
		
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
		return true;
	}

}
