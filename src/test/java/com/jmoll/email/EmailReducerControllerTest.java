package com.jmoll.email;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author jmoll
 *
 */

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmailReducerController.class)
@AutoConfigureMockMvc
public class EmailReducerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private EmailReducerService serviceMock;

	@BeforeTestClass
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void whenValidInput_thenReturns200() throws Exception {
		EmailRequest request = new EmailRequest();
		request.setUserId("TestUserId");

		List<String> emails = new ArrayList<>();
		emails.add("test@jmoll.com");
		request.setAddresses(emails);

		mockMvc.perform(
				post("/email/reduce")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isOk());
	}

	@Test
	void whenBadInput_thenReturns400() throws Exception {
		mockMvc.perform(
				post("/email/reduce")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(new EmailRequest())))
				.andExpect(status().isBadRequest());
	}
}
