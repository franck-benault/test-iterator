package net.franckbenault.iterator.sample2;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Sample2 implements Iterator<String> {
	
	private BufferedReader br;
	private String line;
	
	public Sample2() throws IOException {
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
			e.printStackTrace();
		}
		return tempLine;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException(); 		
	}
	
	
	public void close() {
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
