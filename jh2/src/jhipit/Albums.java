package jhipit;

public class Albums {

	public String album_title;
	public String message;
	public String[] errors = new String[]{};
	public String total;
	public int total_pages;
	public int page;
	public String limit;

	public String toString() {
		return album_title + "  " + "MyFoo";
	}

// 		String str = "{\"album_id\":\"7596\",\"album_title\":\"Album 1\"}";

}
