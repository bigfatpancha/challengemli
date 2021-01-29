package com.challenge.mli.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessageServiceTest {
	
	private MessagesService service = new MessagesService();
	private List<List<String>> messages = new ArrayList<>();
	
	@BeforeEach
	public void init() {
		List<String> words = new ArrayList<String>();
		List<String> words1 = new ArrayList<String>();
		List<String> words2 = new ArrayList<String>();
		words.add("");
		words.add("este");
		words.add("");
		words.add("");
		words.add("mensaje");
		messages.add(words);
		words1.add("");
		words1.add("es");
		words1.add("");
		words1.add("");
		words1.add("secreto");
		messages.add(words1);
		words2.add("este");
		words2.add("");
		words2.add("un");
		words2.add("");
		words2.add("");
		messages.add(words2);
	}
	
	@Test
	public void getMessage() {
		String msg = service.getMessage(messages);
		assertEquals("este es un mensaje secreto ", msg);
	}

}
