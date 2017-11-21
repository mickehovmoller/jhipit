package jhipit;

import java.io.PrintWriter;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Changelog {

	public String startAt;
	public String maxResults;
	public String total;
	public Histories[] histories;

	public void printToFile(PrintWriter outputFile, String key, OffsetDateTime createdDateTime, String resolution) {
		OffsetDateTime previousDateTime = createdDateTime;
		if (histories != null) {
			for (Histories h : histories) {
				if (h.isStausChange()) {
					String s = key + ";https://jira.cinnober.com/browse/" + key + ";" + h.getRelevantPreviousState()
							+ ";";
					OffsetDateTime currentDateTime = OffsetDateTime.parse(h.created,
							DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSx"));
					Duration dur = Duration.between(previousDateTime, currentDateTime);
					// TODO: Create and use a proper formatter
					long durInSeconds = dur.getSeconds();
					long durHours = durInSeconds / 3600;
					long durMinutes = (durInSeconds - durHours * 3600) / 60;
					long durSeconds = durInSeconds % 60;
					s += durHours + ":" + durMinutes + ":" + durSeconds;
					s += ";" + resolution;
					outputFile.println(s);
					previousDateTime = currentDateTime;
				}
			}
		}
	}

}
