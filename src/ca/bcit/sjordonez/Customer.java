package ca.bcit.sjordonez;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String streetName;
	private String cityName;
	private String postalCode;
	private String phoneNumber;
	private String email;
	private LocalDate joinDate;

	public Customer() {
		super();
	}

	public Customer(final int id, final String firstName, final String lastName, final String streetName,
			final String cityName, final String postalCode, final String phoneNumber, final String email,
			final String joinDate) {
		validateInt(id);
		validateString(firstName);
		validateString(lastName);
		validateString(streetName);
		validateString(cityName);
		validateString(postalCode);
		validateString(phoneNumber);
		validateString(email);
		validateString(joinDate);
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetName = streetName;
		this.cityName = cityName;
		this.postalCode = postalCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
		// Convert joinDate String (YYYYMMDD) to LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        this.joinDate = LocalDate.parse(joinDate, formatter);
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

	/**
	 * Validates any generic integer/number.
	 *
	 * @param value The number.
	 */
	public final void validateInt(final int value) {
		if (value <= 0) {
			throw new IllegalArgumentException("Invalid integer/number: " + value);
		}
	}

	public final int getId() {
		return id;
	}

	public final String getFirstName() {
		return firstName;
	}

	public final String getLastName() {
		return lastName;
	}

	public final String getStreetName() {
		return streetName;
	}

	public final String getCityName() {
		return cityName;
	}

	public final String getPostalCode() {
		return postalCode;
	}

	public final String getPhoneNumber() {
		return phoneNumber;
	}

	public final String getEmail() {
		return email;
	}

	public final LocalDate getJoinDate() {
		return joinDate;
	}

	public final void setId(int id) {
		validateInt(id);
		this.id = id;
	}

	public final void setFirstName(String firstName) {
		validateString(firstName);
		this.firstName = firstName;
	}

	public final void setLastName(String lastName) {
		validateString(lastName);
		this.lastName = lastName;
	}

	public final void setStreetName(String streetName) {
		validateString(streetName);
		this.streetName = streetName;
	}

	public final void setCityName(String cityName) {
		validateString(cityName);
		this.cityName = cityName;
	}

	public final void setPostalCode(String postalCode) {
		validateString(postalCode);
		this.postalCode = postalCode;
	}

	public final void setPhoneNumber(String phoneNumber) {
		validateString(phoneNumber);
		this.phoneNumber = phoneNumber;
	}

	public final void setEmail(String email) {
		validateString(email);
		this.email = email;
	}

	public final void setJoinDate(String joinDate) {
		validateString(joinDate);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        this.joinDate = LocalDate.parse(joinDate, formatter);
	}

	@Override
	public String toString() {
		// Format the joinDate to a string with a specific format
	    String formattedJoinDate = joinDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	    String formattedCustomerDetails = String.join("\t",
	            String.valueOf(id),
	            firstName,
	            lastName,
	            streetName,
	            cityName,
	            postalCode,
	            phoneNumber,
	            email,
	            formattedJoinDate
	        );
	        
	        return formattedCustomerDetails;
	}

}
