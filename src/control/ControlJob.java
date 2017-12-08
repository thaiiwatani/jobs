package control;

import java.sql.SQLException;
import java.util.List;
import dataConnect.DataJob;
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
	

}

