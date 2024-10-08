package ca.bcit.sjordonez;

import java.awt.FlowLayout;
import java.util.Comparator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.miginfocom.swing.MigLayout;

public class CustomerListDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private CustomerLibrary customerLibrary;

	/**
	 * Create the dialog.
	 */
	public CustomerListDialog() {
		setTitle("Customer List");
		this.customerLibrary = CustomerLibrary.getCustomerLibraryInstance();
		setSize(600, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new MigLayout("", "[grow]", "[grow][39px]"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, "cell 0 0,grow");
		
		// Create and populate the customer list
		DefaultListModel<Customer> listModel = new DefaultListModel<>();
		// Check AppState to determine sorting method
        boolean sortByJoinDate = SortByListState.getInstance().isSortByJoinDate();

        // Fetch and sort the customer list
        List<Customer> customers = customerLibrary.getAllCustomers();
        if (sortByJoinDate) {
            customers.sort(Comparator.comparing(Customer::getJoinDate));
        } else {
            customers.sort(Comparator.comparingInt(Customer::getId));
        }
		for (Customer customer : customers) {
			listModel.addElement(customer);
		}
		contentPanel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			contentPanel.add(scrollPane, "cell 0 0,alignx center,aligny top, grow, hmin 300px");
			{
				JList<Customer> list = new JList<Customer>(listModel);
				list.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						if (!e.getValueIsAdjusting()) {
							Customer selectedCustomer = (Customer) list.getSelectedValue(); // Cast to Customer
							if (selectedCustomer != null) {
								// Open the details dialog
								new CustomerDetailsDialog(selectedCustomer).setVisible(true);
							}
						}
					}
				});
				list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				scrollPane.setViewportView(list);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, "cell 0 1,growx,aligny top");
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}