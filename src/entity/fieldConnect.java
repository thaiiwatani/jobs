package entity;

public class fieldConnect {
	private  String hostName;
	private String dbName;
	private String userName;
	private String password;
	
	public fieldConnect(String hostName, String dbName, String userName, String password) {
		super();
		this.hostName = hostName;
		this.dbName = dbName;
		this.userName = userName;
		this.password = password;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
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

}
