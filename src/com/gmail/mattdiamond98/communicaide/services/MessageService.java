package com.gmail.mattdiamond98.communicaide.services;

import com.gmail.mattdiamond98.communicaide.contact.Contact;
import com.gmail.mattdiamond98.communicaide.message.Message;
import com.gmail.mattdiamond98.communicaide.message.MessageDetails;
import com.gmail.mattdiamond98.communicaide.platforms.PlatformType;

public final class MessageService {
	
	public static void sendCrossPlatformMessage(Message message) {		
		for (Contact destination : message.getDestinationList()) {
			MessageDetails details = message.getDetails().replaceGenerics("<name>:" + destination.getName());
			for (PlatformType type : PlatformType.values())
			if (destination.hasPlatformType(type))
				type.getPlatform().sendMessage(details, destination);
		}
	}
	
}
