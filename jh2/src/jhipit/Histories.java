package jhipit;


public class Histories {
	public String id;
	public String created;
	public Items[] items;
	
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
