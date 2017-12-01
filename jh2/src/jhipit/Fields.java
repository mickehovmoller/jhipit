package jhipit;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Fields {
	public String created;
	public String description;
	public Resolution resolution;
	public Priority priority;
	public String updated;

	public OffsetDateTime getCreatedDateTime() {
		OffsetDateTime currentDateTime = OffsetDateTime.parse(created,
				DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSx"));
		return currentDateTime;
	}
	
	public OffsetDateTime getUpdatedDateTime() {
		OffsetDateTime updatedDateTime = OffsetDateTime.parse(updated,
				DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSx"));
		return updatedDateTime;
	}
	
	public String getResolution() {
		if (resolution==null) return "";
		return resolution.toString();
	}

	public String getPriority() {
		if (priority==null) return "";
		return priority.toString();
	}

}
