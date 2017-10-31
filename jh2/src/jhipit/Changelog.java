package jhipit;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Changelog {

	public String startAt;
	public String maxResults;
	public String total;
	public Histories[] histories;

	public String toString() {
		String s = " maxResults: " + maxResults;
		OffsetDateTime previousDateTime = null;
		if (histories != null) {
			for (Histories h: histories) {
				s += h.toString();
				OffsetDateTime currentDateTime = OffsetDateTime.parse(h.created, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSx"));
				if (previousDateTime != null) {
					Duration dur = Duration.between(previousDateTime, currentDateTime);
					s += " duration: " + dur;
				}
				previousDateTime = currentDateTime;
			}
		}
		return s;
	}

}
