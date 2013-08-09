package net.franckbenault.iterator;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;

public class Sample2 implements Iterator<String> {
	
	private static final Logger logger = Logger.getLogger(Sample2.class);
	
	private BufferedReader br;
	private String line;
	
	public Sample2() throws IOException {
		logger.info("open file");
	    br = new BufferedReader(new FileReader("../sample2/src/main/resources/file.txt"));
	    
	    line = br.readLine();

	}

	@Override
	public boolean hasNext() {
		return line!=null;
	}

	@Override
	public String next() {
		String tempLine = line;
		try {
			line = br.readLine();
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		return tempLine;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException(); 		
	}
	
	
	public void close() {
		try {
			logger.info("close file");
			br.close();
		} catch (IOException e) {
			logger.error(e.getMessage());
		}		
	}

}
