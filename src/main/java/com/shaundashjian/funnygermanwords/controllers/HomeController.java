package com.shaundashjian.funnygermanwords.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shaundashjian.funnygermanwords.models.Word;
import com.shaundashjian.funnygermanwords.models.WordDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private WordDAO wordDAO;

	public void setWordDAO(WordDAO wordDAO) {
		this.wordDAO = wordDAO;

	}
	
	/**
	 * Handles main.do welcome page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/main.do", method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("words", wordDAO.readWords());		
		model.addAttribute("coreWords", wordDAO.readCoreWords());		
		model.addAttribute("extraWords", wordDAO.readExtraWords());		
		return "home";
	}
	/**
	 * Handles listWords.do welcome page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listWords.do", method = RequestMethod.GET)
	public String listWords(Model model) {
		model.addAttribute("words", wordDAO.readWords());		
		model.addAttribute("coreWords", wordDAO.readCoreWords());		
		model.addAttribute("extraWords", wordDAO.readExtraWords());		
		return "listwords";
	}
	/**
	 * Handles addWord.do 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addWord.do", method = RequestMethod.GET)
	public String addWord(Model model) {
		return "addword";
	}
	/**
	 * Handles displayWord.do 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/displayWord.do", method = RequestMethod.GET)
	public ModelAndView displayWord(String wordInGerman) {
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("displayword");
	    mv.addObject("word", wordDAO.readWord(wordInGerman));
	    return mv;
	}
	/**
	 * Handles editWord.do 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/editWord.do", method = RequestMethod.GET)
	public ModelAndView editWord(String wordInGerman) {
		Word word = wordDAO.readWord(wordInGerman);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("editword");
		mv.addObject("word", word);
		return mv;
	}
	/**
	 * Handles createWord.do 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/createWord.do", method = RequestMethod.POST)
	public ModelAndView createWord(Word word) {
		wordDAO.createWord(word);
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("wordadded");
	    mv.addObject("word", wordDAO.readWord(word.getWordInGerman()));
	    return mv;
	}
	/**
	 * Handles updateWord.do 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateWord.do", method = RequestMethod.POST)
	public ModelAndView updateWord(Word word) {
		wordDAO.updateWord(word);
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("wordupdated");
	    mv.addObject("word", wordDAO.readWord(word.getWordInGerman()));
	    return mv;
	}
	/**
	 * Handles deletedWord.do 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteWord.do", method = RequestMethod.GET)
	public ModelAndView deleteWord(String wordInGerman) {
		Word word = wordDAO.readWord(wordInGerman);
		wordDAO.deleteWord(wordInGerman);
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("worddeleted");
	    mv.addObject("word", word);
	    mv.addObject("words", wordDAO.readWords());
	    mv.addObject("coreWords", wordDAO.readCoreWords());
	    mv.addObject("extraWords", wordDAO.readExtraWords());
	    return mv;
	}
	
}
