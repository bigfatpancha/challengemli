package com.challenge.mli.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Message {
	
	private List<String> words;
	private List<String> correctWords;
	private Integer shift;
	private Map<String, Integer> wordPositionMap = new HashMap<>();
	
	public Message (List<String> words) {
		this.words = words;
		for (int pos = 0; pos < this.words.size(); pos++) {
			String word = this.words.get(pos);
			if (word != "") {
				this.wordPositionMap.put(word, pos);
			}
		}
	}
	
	public void calculateShift(Message m1, Message m2) {
		Integer shift1 = null;
		Integer shift2 = null;
		int pos = 0;
		do {
			String word = this.words.get(pos);
			if (word != "") {
				if (shift1 == null && m1.getWordPositionMap().containsKey(word)) {
					shift1 = pos - m1.getWordPositionMap().get(word);
				}
				if (shift2 == null && m2.getWordPositionMap().containsKey(word)) {
					shift2 = pos - m2.getWordPositionMap().get(word);
				}
			}
			pos++;
		} while (pos < this.words.size() && (shift1 == null || shift2 == null));
		if (shift1 == null && shift2 == null) {
			this.shift = 0;
		} else if (shift1 == null) {
			this.shift = shift2;
		} else if (shift2 == null) {
			this.shift = shift1;
		} else {			
			this.shift = Math.max(shift1, shift2);
		}
		
	}
	
	public void wordsInCorrectPosition() {
		if (this.shift > 0) {
			this.correctWords = rotate(this.words, this.words.size() - this.shift);			
		} else {			
			this.correctWords = this.words;
		}
	}
	
	private <T> ArrayList<T> rotate(List<T> aL, int shift) {
	    ArrayList<T> newValues = new ArrayList<>(aL);
	    Collections.rotate(newValues, shift);
	    return newValues;
	}

	public Integer size() {
		return this.words.size();
	}

	public Map<String, Integer> getWordPositionMap() {
		return wordPositionMap;
	}

	public String getWordInPosition(Integer pos) {
		return this.correctWords.get(pos);
	}
	
}
