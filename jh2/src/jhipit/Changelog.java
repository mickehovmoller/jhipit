package jhipit;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Changelog {

	public String startAt;
	public String maxResults;
	public String total;
	public Histories[] histories;

  // Iterates over the changelog. Adds new items to the hashmap, and updates already existing ones
	public void iterateChangelog(Map<JiraStatusTuple, JiraWithStatus> jiraMap, String key,
			OffsetDateTime createdDateTime, String resolution, String severity, String lastUpdated) {

		OffsetDateTime previousDateTime = createdDateTime;

		if (histories != null) {
			for (Histories h : histories) {
				if (h.isStausChange()) {

					// Get the duration of this status change
					OffsetDateTime currentDateTime = OffsetDateTime.parse(h.created,
							DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSx"));
					Duration dur = Duration.between(previousDateTime, currentDateTime);

					// Check if this combination is already in the map
					JiraStatusTuple newTuple = new JiraStatusTuple(key, h.getRelevantPreviousState());

					JiraWithStatus j = jiraMap.get(newTuple);

					if (j == null) {
						// No, so add it
						JiraWithStatus result = new JiraWithStatus(key, "https://jira.cinnober.com/browse/" + key,
								h.getRelevantPreviousState(), dur, resolution, severity, lastUpdated);
						jiraMap.put(newTuple, result);
					} else {
						// Yes, so just add the time
						j.addTimeSpent(dur);
					}
					previousDateTime = currentDateTime;
				}
			}

		}
	}
}