package com.jmoll.email;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * Request object to encapsulate fields and validation requirements.
 * 
 * @author jmoll
 *
 */

public class EmailRequest {
	
	@NotBlank(message = "UserId is required")
	private String userId;
	
	@NotEmpty(message = "Email addresses are required")
	private List<String> addresses;
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public List<String> getAddresses() {
		if (null == addresses) {
			return new ArrayList<>();
		}
		
		return addresses;
	}
	
	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}
	
	public int getTotalCount() {
		return getAddresses().size();
	}
}
