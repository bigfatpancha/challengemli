package com.challenge.mli.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.challenge.mli.exceptions.MessageNotFoundException;
import com.challenge.mli.model.Message;

@Service
public class MessagesService {

	
	public String getMessage(List<List<String>> messages) {
		List<Message> messagesArray = new ArrayList<Message>();
		Message m1, m2, m3;
		for (List<String> words : messages) {
			messagesArray.add(new Message(words));
		}
		m1 = messagesArray.get(0);
		m2 = messagesArray.get(1);
		m3 = messagesArray.get(2);
		
		int index = 0;
		for (Message aMessage : messagesArray) {
			if (index == 0) {
				aMessage.calculateShift(m2, m3);
			} else if (index == 1) {
				aMessage.calculateShift(m1, m3);
			} else if (index == 2) {
				aMessage.calculateShift(m1, m2);
			}
			aMessage.wordsInCorrectPosition();
			index++;
		}
		
		String finalMessage = "";
		for (int i = 0; i < m1.size(); i++) {
			String word = m1.getWordInPosition(i) != "" ? m1.getWordInPosition(i) : m2.getWordInPosition(i) != "" ? m2.getWordInPosition(i) : m3.getWordInPosition(i) != "" ? m3.getWordInPosition(i) : "";
			if (word != "") {
				finalMessage += word + " ";
			} else {
				throw new MessageNotFoundException("Cannot find message");
			}			
		}
		
		return finalMessage;
	}
}
