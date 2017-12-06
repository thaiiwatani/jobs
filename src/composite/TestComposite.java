package composite;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TestComposite extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TestComposite(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(2, false));
		
		Button btnAddJob = new Button(this, SWT.NONE);
		btnAddJob.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("da an ok");
				
			}
		});
		btnAddJob.setFont(SWTResourceManager.getFont("Yu Gothic UI", 18, SWT.NORMAL));
		btnAddJob.setText("Add Job");
		
		Button btnCancel = new Button(this, SWT.NONE);
		btnCancel.setFont(SWTResourceManager.getFont("Yu Gothic UI", 18, SWT.NORMAL));
		btnCancel.setText("Cancel");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
