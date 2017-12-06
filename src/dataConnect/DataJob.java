package dataConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.GroupJob;
import entity.Job;


public class DataJob {
	public DataJob()
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
		DataJob dtGroupJob = new DataJob();

	}
	private List<Job> loadData() throws SQLException
	{
		Connection con;
		try {
		con = new Connect().getMySQLConnection();
		Statement statement = con.createStatement();
		 
	    String sql = "Select id, groupname, memo from group_jobs";
	    ResultSet rs;
		
		rs = statement.executeQuery(sql);
		//List<groupJob> lst = new ArrayList<>(groupJob);
		List<Job> lstJob = new ArrayList<Job>();
		
	      while (rs.next()) {
	          int id = rs.getInt(1);
	          String groupname = rs.getString(2);
	          String memo = rs.getString("memo");
	          Job job = new Job();
	          lstJob.add(job);
	          
	          System.out.println("Id:" + id);
	          System.out.println("groupname:" + groupname);
	          System.out.println("memo:" + memo);
	      }
	      
	      con.close();
	      return lstJob;
	      
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}
	private boolean addJob(GroupJob g) throws SQLException
	{
		boolean check =false;
		Connection con=null;
		PreparedStatement preStmt = null;
		try {
		con = new Connect().getMySQLConnection();
		String sql = "insert into group_jobs values (?,?)";
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
	private boolean delJob(Job job) throws SQLException
	{
		boolean check =false;
		Connection con=null;
		PreparedStatement preStmt = null;
		try {
		con = new Connect().getMySQLConnection();
		String sql = "delete from group_jobs where id = ?)";
		preStmt = con.prepareStatement(sql);
        preStmt.setInt(1, job.getId());
        
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
	
	private boolean updateJob(Job job) throws SQLException
	{
		boolean check =false;
		Connection con=null;
		PreparedStatement preStmt = null;
		try {
		con = new Connect().getMySQLConnection();
		String sql = "update group_jobs set groupname = ?,memo=?  where id = ?)";
		preStmt = con.prepareStatement(sql);
		preStmt.setString(1, job.getJobName());
		preStmt.setString(2, job.getMemo());
        preStmt.setInt(3, job.getId());     
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
	

}

