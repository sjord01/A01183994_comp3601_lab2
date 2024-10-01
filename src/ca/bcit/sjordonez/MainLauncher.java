package ca.bcit.sjordonez;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class MainLauncher {

	private static final String FILEPATH_CUSTOMER = "files//customers.dat";
	private static final String DELIMITER_CUSTOMER = "\\|";
	
	private static final int POSITION_ID = 0;
	private static final int POSITION_FIRST_NAME = 1;
	private static final int POSITION_LAST_NAME = 2;
	private static final int POSITION_STREET = 3;
	private static final int POSITION_CITY = 4;
	private static final int POSITION_POSTAL_CODE = 5;
	private static final int POSITION_PHONE = 6;
	private static final int POSITION_EMAIL = 7;
	private static final int POSITION_JOIN_DATE = 8;
	
	public static void main(String[] args) {
		 MainLauncher launcher = new MainLauncher();
	     CustomerLibrary customerLibrary = CustomerLibrary.getCustomerLibraryInstance();
	     
	     // Load customer data from .dat file (provide file path)
	     launcher.loadCustomerData(FILEPATH_CUSTOMER, customerLibrary);

	     // Launch the customer frame
	     launcher.loadCustomerFrame();
    }
	
	public void loadCustomerFrame() {
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Nimbus".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                BooksAppFrame frame = new BooksAppFrame();
                frame.setVisible(true);
            }
        });
	}
	
	/**
     * Loads customer data from a file and populates the customerMap.
     * 
     * @param filePath The path to the customer data file.
     * @param customerMap The map to populate with customer data.
     */
	private void loadCustomerData(String filePath, CustomerLibrary customerLibrary) {
	    String line = null;  // Declare line outside the try block to make it accessible in the catch block
	    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	        boolean firstLine = true;  // Flag to skip the header line
	        
	        while ((line = br.readLine()) != null) {
	            if (firstLine) {
	                firstLine = false;  // Skip the first line (header)
	                continue;
	            }

	            String[] data = line.split(DELIMITER_CUSTOMER);
	            
	            // Assuming fixed positions for the customer data fields
	            int id = Integer.parseInt(data[POSITION_ID]);
	            String firstName = data[POSITION_FIRST_NAME];
	            String lastName = data[POSITION_LAST_NAME];
	            String street = data[POSITION_STREET];
	            String city = data[POSITION_CITY];
	            String postalCode = data[POSITION_POSTAL_CODE];
	            String phone = data[POSITION_PHONE];
	            String email = data[POSITION_EMAIL];
	            String joinDate = data[POSITION_JOIN_DATE];  // in format YYYYMMDD

	            // Create a new customer object
	            Customer customer = new Customer(id, firstName, lastName, street, city, postalCode, phone, email, joinDate);

	            // Add customer to the library
	            customerLibrary.addCustomer(customer);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (NumberFormatException e) {
	        System.err.println("Error parsing number in line: " + line);  // Now the line variable is accessible here
	        e.printStackTrace();
	    }
	}


}
