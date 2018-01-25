package entity;

public class Account {
	private int id;
	private String userName;
	private String password;
	private String memo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Account(int id, String userName, String password, String memo) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.memo = memo;
	}
	public Account() {
		super();
	}
	public Account(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	

}
