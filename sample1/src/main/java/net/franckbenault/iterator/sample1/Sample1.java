package net.franckbenault.iterator.sample1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Sample1 implements Iterator<String> {
	
	private Set<String> mySet = new HashSet<String>();
	private Iterator<String> iterator;

	public Sample1() {
		mySet.add("val1");
		mySet.add("val2");
		mySet.add("val3");

		iterator = mySet.iterator();
	}

	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}

	@Override
	public String next() {
		return iterator.next();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException(); 
	}
}
