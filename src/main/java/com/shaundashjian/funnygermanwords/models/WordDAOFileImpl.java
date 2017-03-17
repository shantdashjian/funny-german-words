package com.shaundashjian.funnygermanwords.models;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class WordDAOFileImpl implements WordDAO {
	private static final String FILE_NAME="/WEB-INF/funny-german-words.tsv";
	private Map<String, Word> words = new HashMap<>();
	/*
	 * Use Autowired to have Spring inject an instance
	 * of a WebApplicationContext into this object after
	 * creation.  We will use the WebApplicationContext to
	 * retrieve an ServletContext so we can read from a
	 * file.
	 */
	@Autowired
	WebApplicationContext webApplicationContext;

	/*
	 * The @PostConstruct method is called by Spring after
	 * object creation and dependency injection
	 */
	@PostConstruct
	private void init() {
		try (
				InputStream inputStream = webApplicationContext.getServletContext().getResourceAsStream(FILE_NAME);
				BufferedReader buf = new BufferedReader(new InputStreamReader(inputStream));
			) {
			String line;
			while ((line = buf.readLine()) != null) {
				String[] param = line.split("\\t");
				String wordInGerman = param[0];
				String literalTranslation = param[1];
				String explanation = param[2];
				String pictureURL = param[3];
				
				Word word = new Word(wordInGerman, literalTranslation, explanation, pictureURL);
				words.put(wordInGerman, word);
				System.out.println(word);

			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}


	@Override
	public void createWord(Word word) {
		words.put(word.getWordInGerman(), word);
	}

	@Override
	public Word readWord(String wordInGerman) {
		return words.get(wordInGerman);
	}

	@Override
	public List<Word> readWords() {
		List<Word> words = new ArrayList<>(this.words.values());
		return words;
	}

	@Override
	public void updateWord(Word word) {
		words.put(word.getWordInGerman(), word);
	}

	@Override
	public void deleteWord(String wordInGerman) {
		words.remove(wordInGerman);
	}

}
