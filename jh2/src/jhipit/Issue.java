package jhipit;

public class Issue {
	public String expand;
	public String id;
	public String self;
	public String key;
	public Fields fields;
	
	public String toString() {
		return expand + "  " + id + "  " + self + "  " + key + fields.toString();
	}

}
