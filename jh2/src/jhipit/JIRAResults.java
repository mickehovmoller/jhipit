package jhipit;

public class JIRAResults {

	public String expand;
	public int startAt;
	public int maxResults;
	public int total;
	public Issues[] issues;
	
	public String toString() {
		for (Issues i : issues) {
			System.out.println(i.toString());
		}
		return expand + "  " + startAt + "  " + maxResults + "  " + total;
	}

}

//"expand": "schema,names",
//"startAt": 0,
//"maxResults": 50,
//"total": 1891,
//"issues": [
