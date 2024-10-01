package ca.bcit.sjordonez;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a customer library that stores Customer objects. Functionalities:
 * to add, remove, display, and retrieve customer entries. It follows a
 * singleton pattern to ensure only one instance of the library exists.
 * 
 * @author Samson James Ordonez
 * @version 1.0
 */
public class CustomerLibrary {
	private Map<Integer, Customer> customerMap;
	private String libraryName;

	// Singleton instance of CustomerLibrary
	private static CustomerLibrary customerLibraryInstance = new CustomerLibrary();

	/**
	 * Constructs an empty CustomerLibrary. This constructor is private to enforce
	 * the singleton pattern.
	 */
	private CustomerLibrary() {
		customerMap = new HashMap<>();
	}

	/**
	 * Retrieves the singleton instance of the CustomerLibrary.
	 * 
	 * @return The singleton instance of CustomerLibrary.
	 */
	public static CustomerLibrary getCustomerLibraryInstance() {
		return customerLibraryInstance;
	}
	
	/**
     * Retrieves the customer map.
     * 
     * @return The map of customers with their IDs as keys.
     */
    public Map<Integer, Customer> getCustomerMap() {
        return customerMap;
    }

	/**
	 * Sets the name of the customer library.
	 * 
	 * @param libraryName The name to set for the library.
	 */
	public void setCustomerLibraryName(String libraryName) {
		validateString(libraryName);
		this.libraryName = libraryName;
	}

	/**
	 * Retrieves the name of the customer library.
	 * 
	 * @return The name of the library.
	 */
	public String getCustomerLibraryName() {
		return libraryName;
	}

	/**
	 * Adds a Customer object to the library.
	 *
	 * @param customer The Customer object to add.
	 */
	public void addCustomer(Customer customer) {
		validateCustomer(customer);
		customerMap.put(customer.getId(), customer);
	}

	/**
	 * Deletes/removes a Customer object from the library.
	 *
	 * @param customer The Customer object to remove.
	 */
	public void deleteCustomer(Customer customer) {
		validateCustomer(customer);
		customerMap.remove(customer.getId());
	}

	/**
	 * Retrieves a Customer object by its ID.
	 * 
	 * @param id The ID of the customer to retrieve.
	 * @return The Customer object with the specified ID, or null if not found.
	 */
	public Customer getCustomerById(int id) {
		return customerMap.get(id);
	}

	/**
	 * Displays all the Customer objects in the library.
	 */
	public void displayCustomerLibrary() {
		customerMap.values().forEach(System.out::println);
	}

	/**
	 * Retrieves all customer entries as a list.
	 * 
	 * @return List of all customer entries.
	 */
	public List<Customer> getAllCustomers() {
		return new ArrayList<>(customerMap.values());
	}

	/**
	 * Validates a Customer object.
	 * 
	 * @param customer Customer object.
	 */
	private void validateCustomer(Customer customer) {
		if (customer == null) {
			throw new IllegalArgumentException("Customer object cannot be null");
		}
	}

	/**
	 * Validates any generic String.
	 *
	 * @param value The String value.
	 */
	public final void validateString(final String value) {
		if (value == null || value.isEmpty()) {
			throw new IllegalArgumentException("Invalid String: " + value);
		}
	}
}
