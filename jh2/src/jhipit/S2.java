package jhipit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class S2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("New world");
		S2 foo = new S2();
		foo.parse();
	}

	private String getFromFile() {
		String s;
		try {

			File f = new File("c:\\jhres\\dgcxjson_cleaned.txt");
			BufferedReader b = new BufferedReader(new FileReader(f));
			return b.readLine();
//			String readLine = "";
//			while ((readLine = b.readLine()) != null) {
//				System.out.println(readLine);
//			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		s = "{\"album_id\":\"7596\",\"album_title\":\"Tjoho\"}";
		return s;
	}

	private void parse() {
		System.out.println("In");
		String str = getFromFile();
		Gson gson = new GsonBuilder().create();
		JIRAResults j = gson.fromJson(str, JIRAResults.class);
		System.out.println(j);
	}
}

