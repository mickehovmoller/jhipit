package jhipit;

import java.time.Duration;

public class JiraWithStatus {
	private String key;
	private String URL;
	private String status;
	private Duration timeSpent;
	private String resolution;
	private String severity;
	private String lastUpdated;

	public JiraWithStatus(String key, String URL, String status, Duration timeSpent, String resolution, String severity,
			String lastUpdated) {
		this.key = key;
		this.URL = URL;
		this.status = status;
		this.timeSpent = timeSpent;
		this.resolution = resolution;
		this.severity = severity;
		this.lastUpdated = lastUpdated;
	}

	public void addTimeSpent(Duration extraTime) {
		timeSpent = timeSpent.plus(extraTime);
	}

	public String getLine() {
		// Add the first fields
		String s = key + ";" + URL + ";" + status + ";";

		// A bit of a mess to get the days as a decimal value
		long durInSeconds = timeSpent.getSeconds();
		long resSeconds = durInSeconds - timeSpent.toDays() * (24 * 60 * 60);
		double ratio = resSeconds / (24 * 60 * 60.0);
		double actualDays = timeSpent.toDays() + ratio;
		s += String.format("%f", actualDays);

		// And finally the rest of the fields
		s += ";" + resolution + ";" + severity + ";" + lastUpdated;

		return s;
	}
}
