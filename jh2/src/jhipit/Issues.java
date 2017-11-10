package jhipit;

import java.io.PrintWriter;
import java.time.OffsetDateTime;

public class Issues {
	public String expand;
	public String id;
	public String self;
	public String key;
	public Fields fields;
	public Changelog changelog;

	public String toString() {
		return id + "  " + self + "  " + key + changelog.toString();
	}

	public void printToFile(PrintWriter outputFile) {
		OffsetDateTime createdDateTime = fields.getCreatedDateTime();		
		changelog.printToFile(outputFile, key, createdDateTime);
		
	}

}

//"expand": "operations,versionedRepresentations,editmeta,changelog,renderedFields",
//"id": "243320",
//"self": "https://jira.cinnober.com/rest/api/2/issue/243320",
//"key": "DGCXSUP-2638",
//"fields": {
