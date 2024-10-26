package ca.bcit.sjordonez;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class BooksAppFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public BooksAppFrame() {
		CustomerLibrary.getCustomerLibraryInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 300);
		setLocationRelativeTo(null);
		setVisible(true);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);

		JMenuItem menuFileDrop = new JMenuItem("Drop");
		menuFile.add(menuFileDrop);

		JSeparator separatorFile_1 = new JSeparator();
		menuFile.add(separatorFile_1);

		JMenuItem menuFileQuit = new JMenuItem("Quit");
		menuFileQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		});
		menuFileQuit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
		menuFile.add(menuFileQuit);

		JMenu menuCustomers = new JMenu("Count");
		menuBar.add(menuCustomers);

		JMenuItem menuCustomersCount = new JMenuItem("Count");
		menuCustomers.add(menuCustomersCount);

		JCheckBoxMenuItem chckbxmntmByJoinDate = new JCheckBoxMenuItem("By Join Date");
		chckbxmntmByJoinDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SortByListState.getInstance().setSortByJoinDate(chckbxmntmByJoinDate.isSelected());
			}
		});
		menuCustomers.add(chckbxmntmByJoinDate);

		JSeparator separatorCustomers_1 = new JSeparator();
		menuCustomers.add(separatorCustomers_1);

		JMenuItem menuCustomersList = new JMenuItem("List");
		menuCustomersList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerListDialog dialog = new CustomerListDialog();
				dialog.setVisible(true);
			}
		});
		menuCustomers.add(menuCustomersList);

		JMenu menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);

		JMenuItem menuHelpAbout = new JMenuItem("About");
		menuHelpAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(BooksAppFrame.this, "<html><h1>Customer Management App</h1>"
						+ "<p>Version: 1.0</p>"
						+ "<p>This application helps you manage a list of customers. You can add, view, edit, and delete customer details easily. "
						+ "Additionally, the app sorts customers by ID and provides detailed information when you select a customer.</p>"
						+ "<p>Developed by: Samson James Ordonez</p></html>", "About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		menuHelpAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		menuHelp.add(menuHelpAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][]", "[][]"));
	}

}
