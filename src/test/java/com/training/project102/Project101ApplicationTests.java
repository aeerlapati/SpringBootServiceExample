package com.training.project102;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class Project101ApplicationTests {
	
	@Autowired
	private MockMvc	mockMvc;

	@Test
	void contextLoads() {
		assertEquals(5,5);
	}
	
	@Test
	public void validateHelloService() throws Exception {
		this.mockMvc.perform(get("/hello/123456").header("accept-language", "application/xml")).andDo(print()).andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.xpath("/value").string(is("Hello 123456")));
	}
	
	@Test
	public void validateCoalMineService() throws Exception {
		this.mockMvc.perform(get("/coal-mine")).andDo(print()).andExpect(status().isOk()).andExpect(MockMvcResultMatchers.content().string("Tweet"));
	}

}
