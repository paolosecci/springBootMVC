package com.shelf.book;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
class BookApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void circularViewPathIssue() throws Exception {
	}

}
