package jhipit;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Histories {
	public String id;
	public String created;
	public Items[] items;
	
	public String toString() {
//		OffsetDateTime c = OffsetDateTime.parse(created, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSx"));
//		Duration d2 = Duration.between(c, OffsetDateTime.now());
		return " id: " + id + " created: " + created + " " + items[0].toString();
	}

	
}
