package jhipit;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

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

	public void iterateIssues(Map<JiraStatusTuple, JiraWithStatus> jiraMap) {
		OffsetDateTime createdDateTime = fields.getCreatedDateTime();
		String resolution = fields.getResolution();
		String severity = fields.getPriority();
		String lastUpdated = fields.getUpdatedDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
		changelog.iterateChangelog(jiraMap, key, createdDateTime, resolution, severity, lastUpdated);
	}

}
