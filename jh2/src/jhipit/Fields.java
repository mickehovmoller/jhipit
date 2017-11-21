package jhipit;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Fields {
	public String created;
	public String description;
	public Resolution resolution;

//	public String toString() {
//		return created + "  " + description;
//	}

	public OffsetDateTime getCreatedDateTime() {
		OffsetDateTime currentDateTime = OffsetDateTime.parse(created,
				DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSx"));
		return currentDateTime;
	}
	
	public String getResolution() {
		if (resolution==null) return "";
		return resolution.toString();
	}

}
