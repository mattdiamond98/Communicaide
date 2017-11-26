package com.gmail.mattdiamond98.communicaide.message;

public class MessageDetails {
	
	private String subject;
	private String text;
	
	public MessageDetails(String subject, String text) {
		this.subject = subject;
		this.text = text;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public String getText() {
		return text;
	}
	
	public MessageDetails setSubject(String subject) {
		this.subject = subject;
		return this;
	}
	
	public MessageDetails setText(String text) {
		this.text = text;
		return this;
	}
	
	/**
	 * Method for replacing generic message values with specific values
	 * @param generics a list of generic value pairs in the format of {@code"<key>:value"}. 
	 * @return a new set of MessageDetails with the replaced values
	 */
	public MessageDetails replaceGenerics(String... generics) {
		MessageDetails newDetails = new MessageDetails(subject, text);
		for (String pair : generics) {
			String generic = pair.substring(0, pair.indexOf(':'));
			String value = pair.substring(pair.indexOf(':') + 1);
			newDetails.subject = newDetails.subject.replace(generic, value);
			newDetails.text = newDetails.text.replace(generic, value);
		}
		return newDetails;
	}
	
	public String toString() {
		return subject + ":\t" + text;
	}
	
}
