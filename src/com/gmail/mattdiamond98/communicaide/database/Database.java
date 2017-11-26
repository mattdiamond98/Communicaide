package com.gmail.mattdiamond98.communicaide.database;

import java.util.List;

import com.gmail.mattdiamond98.communicaide.contact.Contact;

public interface Database {
	
	public Contact getContact(int index);
	public List<Contact> getAllContacts();
}
