package com.gmail.mattdiamond98.communicaide.platforms;

import com.gmail.mattdiamond98.communicaide.contact.Contact;
import com.gmail.mattdiamond98.communicaide.message.MessageDetails;

public interface Platform {
	
    //TODO: need host and user authentication details! IMPORTANT
	public void sendMessage(MessageDetails message, Contact to);
	
}
