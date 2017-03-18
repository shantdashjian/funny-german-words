package com.shaundashjian.funnygermanwords.controllers;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

			List<Word> actualList = ((List<Word>) map.get("words"));
			int expectedSize = 2;
			assertEquals(expectedSize, actualList.size());

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	@Test
	public void test_GET_list_Words_returns_Words() {
		try {
			MvcResult result = mockMvc.perform(get("/listWords.do")).andExpect(status().isOk()).andReturn();
			ModelAndView mv = result.getModelAndView();
			assertEquals("listwords", mv.getViewName());
			ModelMap map = mv.getModelMap();
			assertNotNull(map.get("words"));

			List<Word> actualList = ((List<Word>) map.get("words"));
			int expectedSize = 2;
			assertEquals(expectedSize, actualList.size());

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	@Test
	public void test_GET_add_word_returns_view_add_Word() {
		try {
			MvcResult result = mockMvc.perform(get("/addWord.do")).andExpect(status().isOk()).andReturn();
			ModelAndView mv = result.getModelAndView();
			assertEquals("addword", mv.getViewName());

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
	@Test
	public void test_GET_display_word_returns_view_display_and_Word() {
		try {
			MvcResult result = mockMvc.perform(get("/displayWord.do")
					.param("wordInGerman", "Ohrwurm")
					).andExpect(status().isOk()).andReturn();
			ModelAndView mv = result.getModelAndView();
			assertEquals("displayword", mv.getViewName());
			
			ModelMap map = mv.getModelMap();
			assertNotNull(map.get("word"));
			Word actualWord = (Word) map.get("word");
			String expectedWordInGerman = "Ohrwurm";
			assertEquals(expectedWordInGerman, actualWord.getWordInGerman());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	@Test
	public void test_GET_edit_word_returns_view_edit_Word() {
		try {
			MvcResult result = mockMvc.perform(get("/editWord.do")
					.param("wordInGerman", "Ohrwurm")
					).andExpect(status().isOk()).andReturn();
			ModelAndView mv = result.getModelAndView();
			assertEquals("editword", mv.getViewName());
			ModelMap map = mv.getModelMap();
			assertNotNull(map.get("word"));
			Word actualWord = (Word) map.get("word");
			String expectedWordInGerman = "Ohrwurm";
			assertEquals(expectedWordInGerman, actualWord.getWordInGerman());

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	@Test
	public void test_POST_create_word_returns_view_word_created_and_Word() {
		try {

			MvcResult result = mockMvc
					.perform(post("/createWord.do").param("wordInGerman", "Kummerspeck")
							.param("literalTranslation", "Grief bacon")
							.param("explanation",
									"When a relationship ends or during other times of sadness, anger, or worry, it’s common to put on a few pounds of Kummerspeck. What it means is the excess weight put on by emotional overeating. So when you find yourself on the couch watching “Bridget Jones’ Diary” with a tub of ice cream, you are in fact feeding your grief bacon.")
							.param("pictureURL", "https://farm7.staticflickr.com/6067/6057404732_f7169a6664_z.jpg"))
					.andExpect(status().isOk()).andReturn();
			ModelAndView mv = result.getModelAndView();
			assertEquals("wordadded", mv.getViewName());

			ModelMap map = mv.getModelMap();
			assertNotNull(map.get("word"));
			Word actualWord = (Word) map.get("word");
			String expectedWordInGerman = "Kummerspeck";
			assertEquals(expectedWordInGerman, actualWord.getWordInGerman());
			String expectedLiteralTranslation = "Grief bacon";
			assertEquals(expectedLiteralTranslation, actualWord.getLiteralTranslation());
			String expectedExplanation = "When a relationship ends or during other times of sadness, anger, or worry, it’s common to put on a few pounds of Kummerspeck. What it means is the excess weight put on by emotional overeating. So when you find yourself on the couch watching “Bridget Jones’ Diary” with a tub of ice cream, you are in fact feeding your grief bacon.";
			assertEquals(expectedExplanation, actualWord.getExplanation());
			String expectedPictureURL = "https://farm7.staticflickr.com/6067/6057404732_f7169a6664_z.jpg";
			assertEquals(expectedPictureURL, actualWord.getPictureURL());

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	@Test
	public void test_POST_update_word_returns_view_word_updated_and_Word() {
		try {

			MvcResult result = mockMvc
					.perform(post("/updateWord.do").param("wordInGerman", "Kummerspeck")
							.param("literalTranslation", "Grief bacon and eggs")
							.param("explanation",
									"When a relationship ends or during other times of sadness, anger, or worry, it’s common to put on a few pounds of Kummerspeck. What it means is the excess weight put on by emotional overeating. So when you find yourself on the couch watching “Bridget Jones’ Diary” with a tub of ice cream, you are in fact feeding your grief bacon.")
							.param("pictureURL", "https://farm7.staticflickr.com/6067/6057404732_f7169a6664_z.jpg"))
					.andExpect(status().isOk()).andReturn();
			ModelAndView mv = result.getModelAndView();
			assertEquals("wordupdated", mv.getViewName());

			ModelMap map = mv.getModelMap();
			assertNotNull(map.get("word"));
			Word actualWord = (Word) map.get("word");
			String expectedWordInGerman = "Kummerspeck";
			assertEquals(expectedWordInGerman, actualWord.getWordInGerman());
			String expectedLiteralTranslation = "Grief bacon and eggs";
			assertEquals(expectedLiteralTranslation, actualWord.getLiteralTranslation());
			String expectedExplanation = "When a relationship ends or during other times of sadness, anger, or worry, it’s common to put on a few pounds of Kummerspeck. What it means is the excess weight put on by emotional overeating. So when you find yourself on the couch watching “Bridget Jones’ Diary” with a tub of ice cream, you are in fact feeding your grief bacon.";
			assertEquals(expectedExplanation, actualWord.getExplanation());
			String expectedPictureURL = "https://farm7.staticflickr.com/6067/6057404732_f7169a6664_z.jpg";
			assertEquals(expectedPictureURL, actualWord.getPictureURL());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

	@Test
	public void test_GET_delete_word_returns_view_word_deleted_and_Word() {
		try {
			MvcResult result = mockMvc
					.perform(get("/deleteWord.do")
							.param("wordInGerman", "Ohrwurm")
							).andExpect(status().isOk()).andReturn();
			ModelAndView mv = result.getModelAndView();
			assertEquals("worddeleted", mv.getViewName());

			ModelMap map = mv.getModelMap();
			assertNotNull(map.get("word"));
			Word actualWord = (Word) map.get("word");
			String expectedWordInGerman = "Ohrwurm";
			assertEquals(expectedWordInGerman, actualWord.getWordInGerman());

			assertNotNull(map.get("words"));
			List<Word> actualList = ((List<Word>) map.get("words"));
			int expectedSize = 1;
			assertEquals(expectedSize, actualList.size());
			for (Word word : actualList) {
				assertNotEquals(expectedWordInGerman, word.getWordInGerman());
			}

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}

}
