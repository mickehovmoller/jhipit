package jhipit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class S2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("New world");
		S2 foo = new S2();
		foo.parseJQL();
//		foo.parseIssue();
		// foo.getJIRAs();
	}

	private String getFromFile() {
		String s;
		try {

			File f = new File("c:\\jhres\\dgcxjson_cleaned.txt");
			BufferedReader b = new BufferedReader(new FileReader(f));
			return b.readLine();
			// String readLine = "";
			// while ((readLine = b.readLine()) != null) {
			// System.out.println(readLine);
			// }

		} catch (IOException e) {
			e.printStackTrace();
		}
		s = "{\"album_id\":\"7596\",\"album_title\":\"Tjoho\"}";
		return s;
	}

	private void parseJQL() {
		System.out.println("In");
		// String str = getFromFile();
//		String url = "https://jira.cinnober.com/rest/api/2/search?jql=project%20%3D%20BKL&expand=changelog";
		String url = "https://jira.cinnober.com/rest/api/2/search?jql=issue%20%3D%20BKL-271&expand=changelog";
		String str = getJIRAs(url);
		Gson gson = new GsonBuilder().create();
		JIRAResults j = gson.fromJson(str, JIRAResults.class);
		System.out.println(j);
	}

	private void parseIssue() {
		String url = "https://jira.cinnober.com/rest/api/2/issue/244606/changelog";
		String str = getJIRAs(url);
		Gson gson = new GsonBuilder().create();
		Issue i = gson.fromJson(str, Issue.class);
		System.out.println(i);
	}

	private String getJIRAs(String url) {
		String username = "micke.hovmoller";
		String password = getPwd();
		String[] command = { "curl", "-H", "Accept:application/json", "-u", username + ":" + password, url };
		ProcessBuilder process = new ProcessBuilder(command);
		Process p;
		try {
			p = process.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				builder.append(System.getProperty("line.separator"));
			}
			String result = builder.toString();
			System.out.print(result);
			return result;

		} catch (IOException e) {
			System.out.print("error");
			e.printStackTrace();
		}
		return null;
	}

	private String getPwd() {
		try {
			File f = new File("c:\\jhres\\pwd.txt");
			BufferedReader b = new BufferedReader(new FileReader(f));
			String pwd = b.readLine();
			b.close();
			return pwd;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
