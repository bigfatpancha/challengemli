package com.challenge.mli.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessageTest {

	private Message message;
	private Message m1;
	private Message m2;
	
	/**
	 * ["", "este", "", "", "mensaje"]
	 * ["", "es", "", "", "secreto"]
	 * ["este", "", "un", "", ""]
	 */
	@BeforeEach
	public void init( ) {
		List<String> words = new ArrayList<String>();
		List<String> words1 = new ArrayList<String>();
		List<String> words2 = new ArrayList<String>();
		words.add("");
		words.add("este");
		words.add("");
		words.add("");
		words.add("mensaje");
		message = new Message(words);
		words1.add("");
		words1.add("es");
		words1.add("");
		words1.add("");
		words1.add("secreto");
		m1 = new Message (words1);
		words2.add("este");
		words2.add("");
		words2.add("un");
		words2.add("");
		words2.add("");
		m2 = new Message(words2);
	}
	
	@Test
	public void calculateShift() {
		
		message.calculateShift(m1, m2);

		assertEquals(1, message.getShift());
	}
	
	@Test
	public void wordsOrder() {
		List<String> words = new ArrayList<String>();
		words.add("este");
		words.add("");
		words.add("");
		words.add("mensaje");
		words.add("");
		message.calculateShift(m1, m2);
		message.wordsInCorrectPosition();
		assertEquals(words, message.getCorrectWords());
	}
}
