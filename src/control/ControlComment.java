package control;

import java.sql.SQLException;
import java.util.List;

import dataConnect.DataComment;
import entity.Comment;
import entity.Job;

public class ControlComment {
	
	private DataComment dComment = new DataComment();
	public boolean add(Comment g) throws SQLException
	{
		return dComment.addComment(g);
	}
	public List<Comment> loadData(Job job) throws SQLException
	{
		return dComment.loadData(job);
	}
	public boolean delete(Comment g) throws SQLException
	{
		return dComment.delComment(g);
	}
	public boolean update(Comment g) throws SQLException
	{
		return dComment.updateComment(g);
	}

	public boolean checkComment(Comment g)
	{
		return dComment.checkJobInComment(g);
	}

}

