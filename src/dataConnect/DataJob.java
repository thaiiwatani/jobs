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
	      }
	      
	      con.close();
	     
	      return lstJob;
	      
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}
	public Job loadJob(Job j) throws SQLException
	{
		Connection con;
		try {
		con = new Connect().getMySQLConnection();
		PreparedStatement preStmt = null;
	    String sql = "Select * from jobs where id =?";
	    ResultSet rs;
	    preStmt=con.prepareStatement(sql);
	    preStmt.setInt(1, j.getId());
		rs = preStmt.executeQuery();
		//List<Job> lst = new ArrayList<>(Job);
		
		Job job = new Job();
	      while (rs.next()) {
	          int id = rs.getInt("id");
	          int groupid = rs.getInt("groupid");
	          
	          String memo = rs.getString("memo");
	          
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

	      }
	      
	      con.close();
	      return job;
	      
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}
	public List<Job> loadJobForName(String nameJob) throws SQLException
	{
		Connection con;
		try {
		con = new Connect().getMySQLConnection();
		PreparedStatement preStmt = null;
	    String sql = "Select * from jobs where JobName LIKE ?";
	    ResultSet rs;
	    preStmt=con.prepareStatement(sql);
	    preStmt.setString(1, "%"+nameJob+"%");
		rs = preStmt.executeQuery();
		List<Job> lstJob = new ArrayList<Job>();
		
		
	      while (rs.next()) {
	          int id = rs.getInt("id");
	          int groupid = rs.getInt("groupid");
	          Job job = new Job();
	          String memo = rs.getString("memo");
	          
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
	      }
	 
	      con.close();
	      return lstJob;
	      
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}
	public List<Job> loadJobForAddress(String address) throws SQLException
	{
		Connection con;
		try {
		con = new Connect().getMySQLConnection();
		PreparedStatement preStmt = null;
	    String sql = "Select * from jobs where address LIKE ?";
	    ResultSet rs;
	    preStmt=con.prepareStatement(sql);
	    preStmt.setString(1, "%"+address+"%");
		rs = preStmt.executeQuery();
		List<Job> lstJob = new ArrayList<Job>();
		
		
	      while (rs.next()) {
	          int id = rs.getInt("id");
	          int groupid = rs.getInt("groupid");
	          Job job = new Job();
	          String memo = rs.getString("memo");
	          
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
	      }
	 
	      con.close();
	      return lstJob;
	      
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}
	public List<Job> loadJobForSalary(int salary) throws SQLException
	{
		Connection con;
		try {
		con = new Connect().getMySQLConnection();
		PreparedStatement preStmt = null;
	    String sql = "Select * from jobs where salary >=?";
	    ResultSet rs;
	    preStmt=con.prepareStatement(sql);
	    preStmt.setInt(1, salary);
		rs = preStmt.executeQuery();
		List<Job> lstJob = new ArrayList<Job>();
		
		
	      while (rs.next()) {
	          int id = rs.getInt("id");
	          int groupid = rs.getInt("groupid");
	          Job job = new Job();
	          String memo = rs.getString("memo");
	          
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
	      }
	 
	      con.close();
	      return lstJob;
	      
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}
	public List<Job> loadJobFromGroup(GroupJob groupJob) throws SQLException
	{
		Connection con;
		try {
		con = new Connect().getMySQLConnection();
		PreparedStatement preStmt = null;
	    String sql = "Select * from jobs where groupid =?";
	    ResultSet rs;
	    preStmt=con.prepareStatement(sql);
	    preStmt.setInt(1, groupJob.getId());
		rs = preStmt.executeQuery();
		List<Job> lstJob = new ArrayList<Job>();
		
		
	      while (rs.next()) {
	          int id = rs.getInt("id");
	          int groupid = rs.getInt("groupid");
	          Job job = new Job();
	          String memo = rs.getString("memo");
	          
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
		String sql = "insert into jobs(JobName,groupid,company,salary,link,image,address,Industry) values (?,?,?,?,?,?,?,?)";
		preStmt = con.prepareStatement(sql);
        preStmt.setString(1, g.getJobName());
        preStmt.setInt(2, g.getGroupid());
        preStmt.setString(3, g.getCompany());
        preStmt.setInt(4, g.getSalary());
        preStmt.setString(5, g.getLink());
        preStmt.setString(6, g.getImage());
        preStmt.setString(7, g.getAddress());
        preStmt.setString(8, g.getIndustry());
        
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
	
	public boolean updateJob(Job g) throws SQLException
	{
		boolean check =false;
		Connection con=null;
		PreparedStatement preStmt = null;
		try {
		con = new Connect().getMySQLConnection();
		String sql = "update jobs set JobName=?,groupid=?,company=?,salary=?,link=?,image=?,address=?,Industry=?  where id = ?";
		preStmt = con.prepareStatement(sql);
		preStmt.setString(1, g.getJobName());
        preStmt.setInt(2, g.getGroupid());
        preStmt.setString(3, g.getCompany());
        preStmt.setInt(4, g.getSalary());
        preStmt.setString(5, g.getLink());
        preStmt.setString(6, g.getImage());
        preStmt.setString(7, g.getAddress());
        preStmt.setString(8, g.getIndustry());  
        preStmt.setInt(9, g.getId());
        check =preStmt.execute();
        System.out.println("Update"+g.getAddress());
        System.out.println("Update"+g.getJobName());
        System.out.println("Update"+g.getCompany());
        System.out.println("Update"+g.getSalary());
        System.out.println("Update"+check);
	    
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

