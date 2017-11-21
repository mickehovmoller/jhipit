package jhipit;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class JIRAResults {

	public String expand;
	public int startAt;
	public int maxResults;
	public int total;
	public Issues[] issues;
	
	public String toString() {
		for (Issues i : issues) {
			System.out.println(i.toString());
		}
		return expand + "  " + startAt + "  " + maxResults + "  " + total;
	}

	public void printToFile(String filename) {
		// TODO Auto-generated method stub
		PrintWriter outputFile;
		try {
			outputFile = new PrintWriter(filename);
			outputFile.println("Key;Link;Status;Time spent;Resolution");
			for (Issues i : issues) {
				i.printToFile(outputFile);
			}
			outputFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

//"expand": "schema,names",
//"startAt": 0,
//"maxResults": 50,
//"total": 1891,
//"issues": [
