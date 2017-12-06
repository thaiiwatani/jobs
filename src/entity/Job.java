package entity;

public class Job {
	private int id;
	private int groupid;
	private int salary;
	private String jobName;
	private String kaisha;
	private String linkAddress;
	private String image;
	private String link;
	private String address;
	private String industry;

	private String memo;
	public Job()
	{}
	public Job(int id,int groupid,int salary)
	{
		this.id=id;
		this.groupid=groupid;
		this.salary=salary;
		
	}
	
	

	public Job(int id, int groupid, int salary, String jobName, String kaisha, String linkAddress, String image,
			String link, String address, String industry, String memo) {
		super();
		this.id = id;
		this.groupid = groupid;
		this.salary = salary;
		this.jobName = jobName;
		this.kaisha = kaisha;
		this.linkAddress = linkAddress;
		this.image = image;
		this.link = link;
		this.address = address;
		this.industry = industry;
		this.memo = memo;
	}
	
	public Job(int groupid, int salary, String jobName, String kaisha, String image, String address) {
		super();
		this.groupid = groupid;
		this.salary = salary;
		this.jobName = jobName;
		this.kaisha = kaisha;
		this.image = image;
		this.address = address;
	}
	public Job(int id, int groupid, int salary, String jobName, String kaisha, String image, String address,
			String industry) {
		super();
		this.id = id;
		this.groupid = groupid;
		this.salary = salary;
		this.jobName = jobName;
		this.kaisha = kaisha;
		this.image = image;
		this.address = address;
		this.industry = industry;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGroupid() {
		return groupid;
	}

	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getKaisha() {
		return kaisha;
	}

	public void setKaisha(String kaisha) {
		this.kaisha = kaisha;
	}

	public String getLinkAddress() {
		return linkAddress;
	}

	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	

}
