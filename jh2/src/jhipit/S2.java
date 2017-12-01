package jhipit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class S2 {

	public static void main(String[] args) {
		System.out.println("Starting");
		S2 foo = new S2();
		
		String url;
		if (args.length == 0) {
			// No arguments passed? For now, use this as a convenience. For later, return with proper error message
			url = "https://jira.cinnober.com/rest/api/2/search?jql=project%20%3D%20%22TRADExpress%20Development%22%20and%20status%20%3DClosed%20and%20updated%20%3E%3D%202017-01-01%20and%20type%20%3D%20Bug%20and%20key%20%3D%20tedev-14854&expand=changelog";
		} else {
			url = getRESTURLFromHTTPURL(args[0]);
		}
		foo.parseJQL(url);
	}

	private static String getRESTURLFromHTTPURL(String url) {
		// Replaces the submitted JIRA query with a similar one using the REST API
		// Also expands the changelog (where the time and status changes are)
		// and sets maxResults to a higher value than the default of 50
		String urlToUse = "https://jira.cinnober.com/rest/api/2/search?";
		int startOfJQL =url.indexOf("jql");
		urlToUse += url.substring(startOfJQL);
		urlToUse += "&expand=changelog&maxResults=1000";
		System.out.println(urlToUse);
		return urlToUse;
	}

	private void parseJQL(String url) {

		String str = getJIRAs(url);
		Gson gson = new GsonBuilder().create();
		JIRAResults j = gson.fromJson(str, JIRAResults.class);

		// Right now prints the results to this specific file. May be changed to a parameter,
		// but that complicates the Excel end somewhat
		j.printToFile("c:\\jhres\\output.txt");
	}

	private String getJIRAs(String url) {
		// This part uses username/password. Should be replaced by OAuth ro something
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
		// Ugly AND unsecure. Two for the price of one!
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
