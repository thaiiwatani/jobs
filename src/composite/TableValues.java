package composite;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Job;

public class TableValues extends AbstractTableModel{
	private List<Job> lstJob;
	public Object[][] values;
	public TableValues(List<Job> lstJob)
	{
		
//		this.lstJob =lstJob;
		
		values= new Object[lstJob.size()][5];
		for(int i=0;i<lstJob.size();i++)
		{
			Job job = lstJob.get(i);
			Object[] objects ={job.getId(),job.getJobName(),job.getCompany(),job.getAddress(),job.getSalary()};
			values[i]=objects;
//			System.out.println("valueeeeeeeeeeeeee"+values[i][2]);
		}
		
		
	}
	
	public final static String[] columnNames = {
	       "ƒR[ƒh", "Name", "Company", "Address", "Salary"
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
