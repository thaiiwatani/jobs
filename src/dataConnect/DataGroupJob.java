package dataConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.GroupJob;


public class DataGroupJob {
	public DataGroupJob()
	{
		try {
			loadData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataGroupJob dtGroupJob = new DataGroupJob();

	}
	public List<GroupJob> loadData() throws SQLException
	{
		Connection con;
		try {
		con = new Connect().getMySQLConnection();
		Statement statement = con.createStatement();
		 
	    String sql = "Select id, groupname, memo from group_jobs";
	    ResultSet rs;
		
		rs = statement.executeQuery(sql);
		//List<groupJob> lst = new ArrayList<>(groupJob);
		List<GroupJob> lstGroupJob = new ArrayList<GroupJob>();
		
	      while (rs.next()) {
	          int id = rs.getInt(1);
	          String groupname = rs.getString(2);
	          String memo = rs.getString("memo");
	          GroupJob gJob = new GroupJob(id,groupname,memo);
	          lstGroupJob.add(gJob);
	          
	          System.out.println("Id:" + id);
	          System.out.println("groupname:" + groupname);
	          System.out.println("memo:" + memo);
	      }
	      
	      con.close();
	      return lstGroupJob;
	      
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}
	public GroupJob loadGroupJob(GroupJob g) throws SQLException
	{
		Connection con;
		try {
		con = new Connect().getMySQLConnection();
		Statement statement = con.createStatement();
		 
	    String sql = "Select id, groupname, memo from group_jobs where id =?";
	    ResultSet rs;
		
		rs = statement.executeQuery(sql);
		//List<groupJob> lst = new ArrayList<>(groupJob);
		List<GroupJob> lstGroupJob = new ArrayList<GroupJob>();
		
	      while (rs.next()) {
	          int id = rs.getInt(1);
	          String groupname = rs.getString(2);
	          String memo = rs.getString("memo");
	          GroupJob gJob = new GroupJob(id,groupname,memo);
	          lstGroupJob.add(gJob);
	          
	          System.out.println("Id:" + id);
	          System.out.println("groupname:" + groupname);
	          System.out.println("memo:" + memo);
	      }
	      
	      con.close();
	      return g;
	      
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}
	public boolean addGroupJob(GroupJob g) throws SQLException
	{
		boolean check =false;
		Connection con=null;
		PreparedStatement preStmt = null;
		try {
		con = new Connect().getMySQLConnection();
		String sql = "insert into group_jobs(GroupName,memo) values (?,?)";
		preStmt = con.prepareStatement(sql);
        preStmt.setString(1, g.getGroupName());
        preStmt.setString(2, g.getMemo());
        check =preStmt.execute();
	    
		}catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return check;
		}
		finally {
            if (null != preStmt) {
                preStmt.close();
            }
            if (null != con) {
                con.close();
            }
		}
		
		return check;
	}
	public boolean checkName(GroupJob g) throws SQLException
	{
		boolean check =false;
		Connection con=null;
		PreparedStatement preStmt = null;
		try {
		con = new Connect().getMySQLConnection();
		String sql = "Select id from group_jobs where GroupName =?";
		preStmt = con.prepareStatement(sql);
        preStmt.setString(1, g.getGroupName());
        ResultSet rs;
        rs= preStmt.executeQuery();
        if(!rs.next())
        {
        	check = true;
        }
        
	    
		}catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return check;
		}
		finally {
            if (null != preStmt) {
                preStmt.close();
            }
            if (null != con) {
                con.close();
            }
		}
		
		return check;
	}
	public boolean delGroupJob(GroupJob gJob) throws SQLException
	{
		boolean check =false;
		Connection con=null;
		PreparedStatement preStmt = null;
		try {
		con = new Connect().getMySQLConnection();
		String sql = "delete from group_jobs where id = ?";
		preStmt = con.prepareStatement(sql);
        preStmt.setInt(1, gJob.getId());
        
        check =preStmt.execute();
	    
		}catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return check;
		}
		finally {
            if (null != preStmt) {
                preStmt.close();
            }
            if (null != con) {
                con.close();
            }
		}
		
		return check;
	}
	
	public boolean updateGroupJob(GroupJob gJob) throws SQLException
	{
		boolean check =false;
		Connection con=null;
		PreparedStatement preStmt = null;
		
		try {
		con = new Connect().getMySQLConnection();
		String sql = "update group_jobs set groupname =?,memo=?  where id =?";
		
		preStmt = con.prepareStatement(sql);
		
		preStmt.setString(1, gJob.getGroupName());
		preStmt.setString(2, gJob.getMemo());
        preStmt.setInt(3, gJob.getId());  
        
        check =!preStmt.execute();
        System.out.println("ABC"+check);
	   
		}catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return check;
		}
		finally {
            if (null != preStmt) {
                preStmt.close();
            }
            if (null != con) {
                con.close();
            }
		}
		
		return check;
	}
	public boolean checkJobInGroupJob(GroupJob groupJob)
	{
		//true = data of job ga nai
		//false = data aru
		boolean check = false;
		Connection con=null;
		PreparedStatement preStmt = null;
		try {
		con = new Connect().getMySQLConnection();
		
		 
	    String sql = "Select id from jobs where groupid =?";
	    preStmt = con.prepareStatement(sql);
	    preStmt.setInt(1, groupJob.getId());
	    
	    ResultSet rs;
		
		rs = preStmt.executeQuery();
		//List<groupJob> lst = new ArrayList<>(groupJob);
		System.out.println("checkUpdate");
		if(!rs.next())
		{
			check = true;
		}
	     preStmt.close();
	     con.close();
	     return check;
	      
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return check;
		}
	}

}

