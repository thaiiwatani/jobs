package control;

import java.sql.SQLException;
import java.util.List;

import dataConnect.DataGroupJob;
import entity.GroupJob;

public class ControlGroupJob {
	
	private DataGroupJob dGroup = new DataGroupJob();
	public boolean add(GroupJob g) throws SQLException
	{
		return dGroup.addGroupJob(g);
	}
	public List<GroupJob> loadData() throws SQLException
	{
		return dGroup.loadData();
	}
	public boolean delete(GroupJob g) throws SQLException
	{
		return dGroup.delGroupJob(g);
	}
	public boolean update(GroupJob g) throws SQLException
	{
		return dGroup.updateGroupJob(g);
	}
	public boolean checkName(GroupJob g) throws SQLException
	{
		return dGroup.checkName(g);
	}
	public boolean checkJobInGroupJob(GroupJob g)
	{
		return dGroup.checkJobInGroupJob(g);
	}

}

