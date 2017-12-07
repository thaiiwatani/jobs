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
		return dJob(g);
	}
	public List<GroupJob> loadData() throws SQLException
	{
		return dJob.loadData();
	}
	public boolean delete(GroupJob g) throws SQLException
	{
		return dJob.delGroupJob(g);
	}
	public boolean update(GroupJob g) throws SQLException
	{
		return dJob.updateGroupJob(g);
	}
	public boolean checkName(GroupJob g) throws SQLException
	{
		return dJob.checkName(g);
	}

}

