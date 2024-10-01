package ca.bcit.sjordonez;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CustomerDetailsDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private CustomerLibrary customerLibrary;
	private JTextField textField_id;
	private JTextField textField_firstName;
	private JTextField textField_lastName;
	private JTextField textField_street;
	private JTextField textField_city;
	private JTextField textField_postalCode;
	private JTextField textField_phone;
	private JTextField textField_email;
	private JTextField textField_joinDate;

	/**
	 * Create the dialog.
	 */
	public CustomerDetailsDialog(Customer customer) {
		this.customerLibrary = CustomerLibrary.getCustomerLibraryInstance();
		setSize(600, 450);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][][]"));
		{
			JLabel lbl_id = new JLabel("ID");
			contentPanel.add(lbl_id, "cell 0 0,alignx trailing");
		}
		{
			textField_id = new JTextField(String.valueOf(customer.getId()));
			textField_id.setEnabled(false);
			textField_id.setEditable(false);
			contentPanel.add(textField_id, "cell 1 0,growx");
			textField_id.setColumns(10);
		}
		{
			JLabel lbl_firstName = new JLabel("First Name");
			contentPanel.add(lbl_firstName, "cell 0 1,alignx trailing");
		}
		{
			textField_firstName = new JTextField(customer.getFirstName());
			contentPanel.add(textField_firstName, "cell 1 1,growx");
			textField_firstName.setColumns(10);
		}
		{
			JLabel lbl_lastName = new JLabel("Last Name");
			contentPanel.add(lbl_lastName, "cell 0 2,alignx trailing");
		}
		{
			textField_lastName = new JTextField(customer.getLastName());
			contentPanel.add(textField_lastName, "cell 1 2,growx");
			textField_lastName.setColumns(10);
		}
		{
			JLabel lbl_street = new JLabel("Street");
			contentPanel.add(lbl_street, "cell 0 3,alignx trailing");
		}
		{
			textField_street = new JTextField(customer.getStreetName());
			contentPanel.add(textField_street, "cell 1 3,growx");
			textField_street.setColumns(10);
		}
		{
			JLabel lbl_City = new JLabel("City");
			contentPanel.add(lbl_City, "cell 0 4,alignx trailing");
		}
		{
			textField_city = new JTextField(customer.getCityName());
			contentPanel.add(textField_city, "cell 1 4,growx");
			textField_city.setColumns(10);
		}
		{
			JLabel lbl_postalCode = new JLabel("Postal Code");
			contentPanel.add(lbl_postalCode, "cell 0 5,alignx trailing");
		}
		{
			textField_postalCode = new JTextField(customer.getPostalCode());
			contentPanel.add(textField_postalCode, "cell 1 5,growx");
			textField_postalCode.setColumns(10);
		}
		{
			JLabel lbl_phone = new JLabel("Phone");
			contentPanel.add(lbl_phone, "cell 0 6,alignx trailing");
		}
		{
			textField_phone = new JTextField(customer.getPhoneNumber());
			contentPanel.add(textField_phone, "cell 1 6,growx");
			textField_phone.setColumns(10);
		}
		{
			JLabel lbl_Email = new JLabel("Email");
			contentPanel.add(lbl_Email, "cell 0 7,alignx trailing");
		}
		{
			textField_email = new JTextField(customer.getEmail());
			contentPanel.add(textField_email, "cell 1 7,growx");
			textField_email.setColumns(10);
		}
		{
			textField_joinDate = new JTextField(customer.getJoinDate().toString());
			contentPanel.add(textField_joinDate, "cell 1 8,growx");
			textField_joinDate.setColumns(10);
		}
		{
			JLabel lbl_joinDate = new JLabel("Join Date");
			contentPanel.add(lbl_joinDate, "cell 0 8,alignx trailing");
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
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
