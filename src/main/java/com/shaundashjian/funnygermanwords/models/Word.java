package com.shaundashjian.funnygermanwords.models;

public class Word {
	private String wordInGerman;
	private String literalTranslation;
	private String explanation;
	private String pictureURL;
	public Word(String wordInGerman, String literalTranslation, String explanation, String pictureURL) {
		super();
		this.wordInGerman = wordInGerman;
		this.literalTranslation = literalTranslation;
		this.explanation = explanation;
		this.pictureURL = pictureURL;
	}
	public Word() {
		super();
	}
	public String getWordInGerman() {
		return wordInGerman;
	}
	public void setWordInGerman(String wordInGerman) {
		this.wordInGerman = wordInGerman;
	}
	public String getLiteralTranslation() {
		return literalTranslation;
	}
	public void setLiteralTranslation(String literalTranslation) {
		this.literalTranslation = literalTranslation;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public String getPictureURL() {
		return pictureURL;
	}
	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}
	@Override
	public String toString() {
		return "Word [wordInGerman=" + wordInGerman + ", literalTranslation=" + literalTranslation + ", explanation=" + explanation
				+ ", pictureURL=" + pictureURL + "]";
	}
	
}
