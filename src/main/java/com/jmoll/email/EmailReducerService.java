package com.jmoll.email;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * Service class to handle business logic for reducing raw list of email addresses
 * to a quantity of valid & unique addresses.
 * 
 * @author jmoll
 *
 */
@Service
public class EmailReducerService {

	public int getUniqueAddresses(List<String> unfilteredAddresses) {
		final Set<String> uniqueAddresses = new HashSet<>(filterInvalid(unfilteredAddresses));
		final Set<String> filteredAddresses = new HashSet<>();
		
		uniqueAddresses.forEach((emailAddress) -> {
			// Get everything before the @ and strip out period
			final String recipient = StringUtils.remove(getRecipient(emailAddress), '.');
						
			filteredAddresses.add(recipient);
		});
		
		return filteredAddresses.size();
	}
	
	/**
	 * This method is responsible for determining the recipient portion of the 
	 * email address I.E. (everything before the @)
	 * 
	 * @param emailAddress
	 * @return recipient
	 */
	private String getRecipient(String emailAddress) {
		final String separator = emailAddress.contains("+") ? "+" : "@";

		return StringUtils.substringBefore(emailAddress, separator);
	}
	
	private List<String> filterInvalid(List<String> unfilteredAddresses) {
		return unfilteredAddresses.stream().filter(item -> null != item && !item.isEmpty()).collect(Collectors.toList());
	}
}
