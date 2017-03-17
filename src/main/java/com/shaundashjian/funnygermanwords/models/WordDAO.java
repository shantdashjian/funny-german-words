package com.shaundashjian.funnygermanwords.models;

import java.util.List;

public interface WordDAO {
	void createWord(Word word);
	Word readWord(String wordInGerman);
	List<Word> readWords();
	void updateWord(Word word);
	void deleteWord(String wordInGerman);
}
