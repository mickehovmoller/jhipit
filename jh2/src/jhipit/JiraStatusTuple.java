package jhipit;

import java.util.Objects;

public class JiraStatusTuple {
	private String key;
	private String status;

	public JiraStatusTuple(String key, String status) {
		this.key = key;
		this.status = status;
	}

	public boolean equals(Object o){
		    if(o == null) return false;
		    if(!(o instanceof JiraStatusTuple)) return false;
		    JiraStatusTuple other = (JiraStatusTuple) o;
		    return ((this.key.equals(other.key)) && (this.status.equals(other.status)));
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.key, this.status);
	}

}
