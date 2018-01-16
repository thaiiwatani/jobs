package entity;

public class Comment {
	private int id;
	private int jobId;
	private String studentId;
	private String content;
	private String memo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Comment(int id, int jobId, String studentId, String content, String memo) {
		super();
		this.id = id;
		this.jobId = jobId;
		this.studentId = studentId;
		this.content = content;
		this.memo = memo;
	}
	public Comment() {
		super();
	}
	public Comment(int jobId, String studentId, String content) {
		super();
		this.jobId = jobId;
		this.studentId = studentId;
		this.content = content;
	}
	
	

}
