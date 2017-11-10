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
		String s = "";
		for (Items i: items) {
			if (!i.toString().equals("")) {
				s += i.toString();
			}
		}
		return " id: " + id + " created: " + created + " " + s;
	}
	
	public String getRelevantPreviousState()
	{
		for (Items i: items) {
			if (!i.toString().equals("")) {
				return i.getRelevantPreviousState();
			}
		}
		return "";
	}

	// Returns true if there is a state change
	public boolean isStausChange()
	{
		for (Items i: items) {
			if (!i.toString().equals("")) {
				return i.isStatusChange();
			}
		}
		return false;
	}

}
