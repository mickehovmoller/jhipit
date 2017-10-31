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

}
