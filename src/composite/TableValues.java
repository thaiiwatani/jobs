package composite;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Job;

public class TableValues extends AbstractTableModel{
	public TableValues(List<Job> lstJob)
	{
		
		Object[][] values= new Object[lstJob.size()][4];
		for(int i=0;i<lstJob.size();i++)
		{
			Job job = lstJob.get(i);
			Object[] objects ={job.getJobName(),job.getCompany(),job.getAddress(),job.getSalary()};
			values[i]=objects;
		}
		setValues(values);
		
		
	}
	
	public final static String[] columnNames = {
	        "Name", "Company", "Address", "Salary"
	    };
	public Object[][] values;
	
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
