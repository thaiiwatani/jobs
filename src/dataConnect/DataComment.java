package dataConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Comment;
import entity.Job;


public class DataComment {
	public DataComment()
	{
//		try {
//			loadData(Job job);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataComment dtComment = new DataComment();

	}
	public List<Comment> loadData(Job job) throws SQLException
	{
		Connection con=null;
		try {
		con = new Connect().getMySQLConnection();
		
	    String sql = "Select id,studentid,content,memo from comments where jobid=?";
	    ResultSet rs=null;
	    PreparedStatement preStmt = null;
	    preStmt=con.prepareStatement(sql);
	    preStmt.setInt(1, job.getId());
		rs = preStmt.executeQuery();
		List<Comment> lstComment = new ArrayList<Comment>();
		
//		System.out.println("IDDDDDDDDDDTest in Data"+comment.getJobId());
	      while (rs.next()) {
	    	  Comment comment = new Comment();
	  		  comment.setJobId(job.getId());
	          int id = rs.getInt("id");
	          String studentId = rs.getString("studentid");
	          String content = rs.getString("content");
	          String memo =rs.getString("memo");
	          comment.setId(id);
	          comment.setContent(content);
	          comment.setStudentId(studentId);
	          comment.setMemo(memo);
	          lstComment.add(comment);
	      }
	      
	      con.close();
	      return lstComment;
	      
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}
	public Comment loadComment(Comment g) throws SQLException
	{
		Connection con;
		try {
		con = new Connect().getMySQLConnection();
		Statement statement = con.createStatement();
		 
	    String sql = "Select id, groupname, memo from group_jobs where id =?";
	    ResultSet rs;
		
		rs = statement.executeQuery(sql);
		//List<Comment> lst = new ArrayList<>(Comment);
		List<Comment> lstComment = new ArrayList<Comment>();
		
	      while (rs.next()) {
	          int id = rs.getInt(1);
	          String groupname = rs.getString(2);
	          String memo = rs.getString("memo");
	          Comment comment = new Comment(id,groupname,memo);
	          lstComment.add(comment);
	      }
	      
	      con.close();
	      return g;
	      
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}
	public boolean addComment(Comment comment) throws SQLException
	{
		boolean check =false;
		Connection con=null;
		PreparedStatement preStmt = null;
		try {
		con = new Connect().getMySQLConnection();
		String sql = "insert into comments(studentid,content,memo,jobid) values (?,?,?,?)";
		preStmt = con.prepareStatement(sql);
        preStmt.setString(1, comment.getStudentId());
        preStmt.setString(2, comment.getContent());
        preStmt.setString(3, comment.getMemo());
        preStmt.setInt(4, comment.getJobId());
        
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
	
	public boolean delComment(Comment comment) throws SQLException
	{
		boolean check =false;
		Connection con=null;
		PreparedStatement preStmt = null;
		ResultSet rs;
	   
		try {
		con = new Connect().getMySQLConnection();
		String sql = "delete from comments where id = ?";
		
		preStmt = con.prepareStatement(sql);
        preStmt.setInt(1, comment.getId());
        
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
	
	public boolean updateComment(Comment comment) throws SQLException
	{
		boolean check =false;
		
		
		return check;
	}
	public boolean checkJobInComment(Comment Comment)
	{

		boolean check = false;
		
		return check;
	}

}

