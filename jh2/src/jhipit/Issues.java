package jhipit;

public class Issues {
	public String expand;
	public String id;
	public String self;
	public String key;

	public String toString() {
		return expand + "  " + id + "  " + self + "  " + key;
	}

}

//"expand": "operations,versionedRepresentations,editmeta,changelog,renderedFields",
//"id": "243320",
//"self": "https://jira.cinnober.com/rest/api/2/issue/243320",
//"key": "DGCXSUP-2638",
//"fields": {
