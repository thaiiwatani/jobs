package control;

import java.sql.SQLException;
import java.util.List;
import dataConnect.DataJob;
import entity.GroupJob;
import entity.Job;


public class ControlJob {
	
	private DataJob dJob = new DataJob();
	public boolean add(Job job) throws SQLException
	{
		return dJob.addJob(job);
	}
	public List<Job> loadData() throws SQLException
	{
		return dJob.loadData();
	}
	public boolean delete(Job g) throws SQLException
	{
		return dJob.delJob(g);
	}
	public boolean update(Job g) throws SQLException
	{
		return dJob.updateJob(g);
	}
	public Job loadJob(Job job) throws SQLException
	{
		return dJob.loadJob(job);
	}
	public List<Job> loadDataFromGroup(GroupJob groupJob) throws SQLException
	{
		return dJob.loadJobFromGroup(groupJob);
	}
	public List<Job> loadDataForName(String nameJob) throws SQLException
	{
		return dJob.loadJobForName(nameJob);
	}
	public List<Job> loadJobForAddress(String address) throws SQLException
	{
		return dJob.loadJobForAddress(address);
	}
	public List<Job> loadJobForSalary(int salary) throws SQLException
	{
		return dJob.loadJobForSalary(salary);
	}

}

