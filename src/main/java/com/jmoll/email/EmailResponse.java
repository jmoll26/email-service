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
	private final int distinceAddressCount;
	
	public EmailResponse(String message, int totalAddressCount, int distinceAddressCount) {
		this.message = message;
		this.totalAddressCount = totalAddressCount;
		this.distinceAddressCount = distinceAddressCount;
	}
	
	public String getMessage() {
		return message;
	}
	public int getTotalAddressCount() {
		return totalAddressCount;
	}
	public int getDistinctAddressCount() {
		return distinceAddressCount;
	}
}
