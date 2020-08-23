package com.jmoll.email;

/**
 * Response object to encapsulate all attributes to send back to clients.
 * 
 * @author jmoll
 *
 */
public class EmailResponse {
	private final String message;
	private final int totalAddressCount;
	private final int uniqueAddressCount;
	
	public EmailResponse(String message, int totalAddressCount, int uniqueAddressCount) {
		this.message = message;
		this.totalAddressCount = totalAddressCount;
		this.uniqueAddressCount = uniqueAddressCount;
	}
	
	public String getMessage() {
		return message;
	}
	public int getTotalAddressCount() {
		return totalAddressCount;
	}
	public int getUniqueAddressCount() {
		return uniqueAddressCount;
	}
}
