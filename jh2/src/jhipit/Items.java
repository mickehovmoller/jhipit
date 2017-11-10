package jhipit;

public class Items {
	public String field;
	public String fromString;
	public String toString;

	public String toString() {
		if (field.equals("status")) {
			return "  " + fromString + "  " + toString;
		} else
			return "";
	}
	
	public String getRelevantPreviousState() {
		if (field.equals("status")) {
			return fromString;
		} else
			return "";
	}

	
	public boolean isStatusChange() {
		return field.equals("status");
	}
	

}
