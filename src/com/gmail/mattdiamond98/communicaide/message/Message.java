package com.gmail.mattdiamond98.communicaide.message;

import java.util.Arrays;
import java.util.List;

import com.gmail.mattdiamond98.communicaide.contact.Contact;
import com.gmail.mattdiamond98.communicaide.services.MessageService;

public class Message {
	
	private List<Contact> destinations;
	private MessageDetails details;
	
	public Message(List<Contact> destinations, MessageDetails details) {
		this.destinations = destinations;
		this.details = details;
	}
	public Message(Contact[] destinations, MessageDetails details) {
		this(Arrays.asList(destinations), details);
	}
	
	public List<Contact> getDestinationList() {
		return destinations;
	}
	
	public MessageDetails getDetails() {
		return details;
	}
	
	public Message setDestinationList(List<Contact> destinations) {
		this.destinations = destinations;
		return this;
	}
	
	public Message setDetails(MessageDetails details) {
		this.details = details;
		return this;
	}
	
	public void send() {
		MessageService.sendCrossPlatformMessage(this);
	}
	
}
