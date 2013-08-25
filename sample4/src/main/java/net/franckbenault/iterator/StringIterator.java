package net.franckbenault.iterator;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

public class StringIterator implements Iterator<String> {
	
	private static final Logger logger = Logger.getLogger(StringIterator.class);
	

	private BufferedReader br;
	private String line;
	private Iterator<String> iterator;
	
	public StringIterator(Set<String> fileNamesInput) throws IOException {
		
		iterator = fileNamesInput.iterator();
		String fileNameInput = iterator.next();

		openNextFile(fileNameInput);
	    line = getNextValidLine(); 
	    
	}

	@Override
	public boolean hasNext() {
		return line!=null;
	}

	@Override
	public String next() {
		String tempLine = line;
		
		line = getNextValidLine(); 
		return tempLine;
	}
	
	private void openNextFile(String fileNameInput) {
		logger.info("open file "+fileNameInput);
	    try {
			br = new BufferedReader(new FileReader(fileNameInput));
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		}
	}
	
	
	private String readLine() {
		String tempLine = null;
		
		try {
			if (br!=null)
				tempLine = br.readLine();
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	
		return tempLine;
	}
	
	private String getNextValidLine() {
		String tempLine = getNextLine();
		boolean isValid = isValid(tempLine);
		
		while(!isValid && tempLine!=null) {
			tempLine = getNextLine();	
			isValid = isValid(tempLine);
		}
		logger.info("getNextValidLine "+tempLine);
		return tempLine;
	}
	
	private String getNextLine() {
		String tempLine = readLine();		
		while(tempLine==null && iterator.hasNext()) {
			openNextFile(iterator.next());
			tempLine = readLine();
		}
		logger.info("getNextLine "+tempLine);
		return tempLine;
	}
	
	private boolean isValid(String line) {
		
		if(line == null)
			return false;
		
		if (line.startsWith("#"))
			return false;
		else {
			logger.info(""+line+" is valid");
			return true;	
		}
				
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException(); 		
	}
	
	
	public void close() {
		try {
			logger.info("close file");
			if(br!=null)
				br.close();
		} catch (IOException e) {
			logger.error(e.getMessage());
		}		
	}

}
