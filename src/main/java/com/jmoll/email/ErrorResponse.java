package com.jmoll.email;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Response object used to provide meaningful error information on failed API
 * requests.
 * 
 * @author jmoll
 *
 */
public class ErrorResponse {
	private final LocalDateTime timestamp;
	private final Map<String, String> errors;

	public ErrorResponse(Map<String, String> errors) {
		this.timestamp = LocalDateTime.now();
		this.errors = errors;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public Map<String, String> getErrors() {
		return errors;
	}
}
