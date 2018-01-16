package composite;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Comment;

public class TableValuesOfComment extends AbstractTableModel{
	private List<Comment> lstComment;
	public Object[][] values;
	public TableValuesOfComment(List<Comment> lstComment)
	{
		
//		this.lstComment =lstComment;
		
		values= new Object[lstComment.size()][3];
		for(int i=0;i<lstComment.size();i++)
		{
			Comment comment = lstComment.get(i);
			Object[] objects ={comment.getStudentId(),comment.getContent(),comment.getMemo()};
			values[i]=objects;
//			System.out.println("valueeeeeeeeeeeeee"+values[i][2]);
		}
		
		
	}
	
	public final static String[] columnNames = {
	       "学籍番号", "コメントの内容", "メモ"
	    };
	
	
	public Object[][] getValues() {
		return values;
	}

	public void setValues(Object[][] values) {
		this.values = values;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return values[0].length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return values.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
        return values[rowIndex][columnIndex];
    }
	
	@Override
	public String getColumnName(int column){
	        return columnNames[column];
	}

}
