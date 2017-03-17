package com.shaundashjian.funnygermanwords.controllers;


import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.shaundashjian.funnygermanwords.models.Word;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "HomeControllerTests-context.xml" })
public class HomeControllerTests {
	private MockMvc mockMvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	@Autowired
	HomeController controller;

	@Autowired
	MockWordDAO mockDAO;

	@Before
	public void setUp() {
		mockDAO = webApplicationContext.getBean(MockWordDAO.class);
		controller.setWordDAO(mockDAO);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void tearDown() {
		mockDAO.loadWords(); // cleanup
	}

	@Test
	public void test_GET_returns_Words() {
		try {
			MvcResult result = mockMvc.perform(get("/main.do")).andExpect(status().isOk()).andReturn();
			ModelAndView mv = result.getModelAndView();
			assertEquals("home", mv.getViewName());
			ModelMap map = mv.getModelMap();
			assertNotNull(map.get("words"));

			int expectedSize = mockDAO.readWords().size();
			assertEquals(expectedSize, ((List<Word>) map.get("words")).size());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	
}
