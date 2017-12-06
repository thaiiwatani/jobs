package composite;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class textChooseFile extends Composite {
	private Text text;
	private Shell shell;
	private String selectedDir;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public textChooseFile(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));
		
		
		
		
		text = new Text(this, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		Button btnBroswer = new Button(this, SWT.NONE);
		btnBroswer.setText("Broswer");
		btnBroswer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText(ChooseFile());
			}
		});

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	private String ChooseFile()
	{
		DirectoryDialog directoryDialog = new DirectoryDialog(shell);
        System.out.println("OUT111111");
        directoryDialog.setFilterPath(selectedDir);
        directoryDialog.setMessage("Please select a directory and click OK");
        
        String dir = directoryDialog.open();
        if(dir != null) {
        	selectedDir = dir;
        	return dir;
        }
		return dir;
	}
}
