package net.franckbenault.iterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

public class StringIterator implements Iterator<String> {
	
	private static final Logger logger = Logger.getLogger(StringIterator.class);

	
	private Set<String> mySet = new HashSet<String>();
	private Iterator<String> iterator;

	public StringIterator() {
		logger.info("fill the set");
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
