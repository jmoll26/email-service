package com.jmoll.email;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author jmoll
 *
 */

public class EmailReducerServiceTest {

	private EmailReducerService reducerService = new EmailReducerService();
	

	@ParameterizedTest
	@MethodSource("generateAddressesStream")
	public void testGetUniqueAddresses(List<String> addresses, int expectedResult) {
		assertEquals(expectedResult, reducerService.getUniqueAddresses(addresses));
	}
	
	private static Stream<Arguments> generateAddressesStream() {
		List<Arguments> listOfArguments = new LinkedList<>();
		
		listOfArguments.add(Arguments.of(List.of(""), 0));
		listOfArguments.add(Arguments.of(List.of(), 0));
		listOfArguments.add(Arguments.of(List.of("test.email@gmail.com", "testemail@gmail.com"), 1));
		listOfArguments.add(Arguments.of(List.of("test.email@gmail.com", "test.email+spam@gmail.com", "testemail@gmail.com"), 1));
		
		return listOfArguments.stream();
	}
}
