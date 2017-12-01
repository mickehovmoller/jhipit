package jhipit;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JIRAResults {

	public String expand;
	public int startAt;
	public int maxResults;
	public int total;
	public Issues[] issues;

	public void printToFile(String filename) {

		PrintWriter outputFile;

		Map<JiraStatusTuple, JiraWithStatus> jiraMap = new HashMap<JiraStatusTuple, JiraWithStatus>();
		try {
			for (Issues i : issues) {
				i.iterateIssues(jiraMap);
			}
			outputFile = new PrintWriter(filename);
			outputFile.println("Key;Link;Status;Time spent;Resolution;Priority;LastUpdated");

			Set<Entry<JiraStatusTuple, JiraWithStatus>> set = jiraMap.entrySet();
			Iterator<Entry<JiraStatusTuple, JiraWithStatus>> iterator = set.iterator();
			while (iterator.hasNext()) {
				Entry<JiraStatusTuple, JiraWithStatus> mentry = iterator.next();
				JiraWithStatus j = (JiraWithStatus) mentry.getValue();
				outputFile.println(j.getLine());
			}

			outputFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
