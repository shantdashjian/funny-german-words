package com.shaundashjian.funnygermanwords.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shaundashjian.funnygermanwords.models.Word;
import com.shaundashjian.funnygermanwords.models.WordDAO;

public class MockWordDAO implements WordDAO {

	Map<String, Word> words;

	public MockWordDAO() {
		words = new HashMap<>();
		loadWords();
	}

	public void loadWords(){
		words.clear();
		words.put("Ohrwurm", new Word("Ohrwurm", "Ear worm", "Have you ever listened to a song on the radio while driving to work only to find yourself still humming the same tune by lunch time? Congratulations, you’ve had an ear worm. The beautiful German word Ohrwurm describes the fact of having a song stuck in your head as if it wriggled itself into your brain through your ear."
				, "http://www.suedkurier.de/storage/image/9/6/7/3/7383769_storagepic-frame-945x560_1oEGpO_DVfhK7.jpg"));
		words.put("Fernweh", new Word("Fernweh", "Distance pain", "This gem describes the feeling of wanting to be somewhere else. It’s kind of like a reverse homesickness (Heimweh in German), a longing for a place that isn’t where you are right now. Fernweh is also a frequent reason for people in Germany to go on holiday."
				, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f5/Flughafen_Berlin-Tempelhof_bei_Sonnenuntergang_-_Fernweh_%28152672327%29.jpg/1920px-Flughafen_Berlin-Tempelhof_bei_Sonnenuntergang_-_Fernweh_%28152672327%29.jpg"));

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

	@Override
	public List<Word> readCoreWords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Word> readExtraWords() {
		// TODO Auto-generated method stub
		return null;
	}

}