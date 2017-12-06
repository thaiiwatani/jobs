package entity;

public class GroupJob {
	private int id;
	private String groupName;
	private String memo;
	
	public GroupJob(int id, String groupName, String memo) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.memo = memo;
	}
	
	public GroupJob(String groupName, String memo) {
		super();
		this.groupName = groupName;
		this.memo = memo;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return groupName;
	}
	
	

}
