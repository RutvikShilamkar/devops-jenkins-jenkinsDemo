package com.devops.jenkinscicddemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(JenkinscicddemoApplication.class)
public class JenkinscicddemoApplicationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testSetupCicd() throws Exception {
		String userName = "Rutvik";

		mockMvc.perform(MockMvcRequestBuilders.get("/setup/{name}", userName))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Hello " + userName + " , Jenkins CI/CD setup is done."));
	}
}

// This test will check if the endpoint returns the correct status and message.
// Let me know if you want me to add more test cases or enhance this! 🚀
