package dataConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	public List<Job> loadData() throws SQLException
	{
		Connection con;
		try {
		con = new Connect().getMySQLConnection();
		Statement statement = con.createStatement();
		 
	    String sql = "Select * from jobs";
	    ResultSet rs;
		
		rs = statement.executeQuery(sql);
		//List<Job> lst = new ArrayList<>(Job);
		List<Job> lstJob = new ArrayList<Job>();
		
	      while (rs.next()) {
	          int id = rs.getInt("id");
	          int groupid = rs.getInt("groupid");
	          
	          String memo = rs.getString("memo");
	          Job job = new Job();
	          job.setId(id);
	          job.setJobName(rs.getString("JobName"));
	          job.setGroupid(groupid);
	          job.setCompany(rs.getString("company"));
	          job.setSalary(rs.getInt("salary"));
	          job.setLink(rs.getString("link"));
	          job.setImage(rs.getString("image"));
	          job.setAddress(rs.getString("address"));
	          job.setIndustry(rs.getString("industry"));
	          
	          job.setMemo(memo);
	          
	          lstJob.add(job);
	          
	          System.out.println("Id:" + id);
	          System.out.println("groupid:" + groupid);
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
	public boolean addJob(Job g) throws SQLException
	{
		boolean check =false;
		Connection con=null;
		PreparedStatement preStmt = null;
		try {
		con = new Connect().getMySQLConnection();
		String sql = "insert into jobs(JobName,groupid,company,salary,link,image,address) values (?,?,?,?,?,?,?)";
		preStmt = con.prepareStatement(sql);
        preStmt.setString(1, g.getJobName());
        preStmt.setInt(2, g.getGroupid());
        preStmt.setString(3, g.getCompany());
        preStmt.setInt(4, g.getSalary());
        preStmt.setString(5, g.getLink());
        preStmt.setString(6, g.getImage());
        preStmt.setString(7, g.getAddress());
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
	public boolean delJob(Job job) throws SQLException
	{
		boolean check =false;
		Connection con=null;
		PreparedStatement preStmt = null;
		try {
		con = new Connect().getMySQLConnection();
		String sql = "delete from jobs where id = ?)";
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
	
	public boolean updateJob(Job job) throws SQLException
	{
		boolean check =false;
		Connection con=null;
		PreparedStatement preStmt = null;
		try {
		con = new Connect().getMySQLConnection();
		String sql = "update jobs set groupname = ?,memo=?  where id = ?)";
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

