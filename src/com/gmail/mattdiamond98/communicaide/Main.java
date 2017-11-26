package com.gmail.mattdiamond98.communicaide;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.gmail.mattdiamond98.communicaide.contact.Contact;
import com.gmail.mattdiamond98.communicaide.database.Database;
import com.gmail.mattdiamond98.communicaide.database.ExcelDatabase;
import com.gmail.mattdiamond98.communicaide.gui.ApplicationFrame;
import com.gmail.mattdiamond98.communicaide.message.Message;
import com.gmail.mattdiamond98.communicaide.message.MessageDetails;

import jxl.read.biff.BiffException;

public class Main {
	
	public static void main(String[] args) throws BiffException, IOException, InterruptedException {
		ApplicationFrame appFrame = new ApplicationFrame();
		appFrame.display();
	}
	
	public static void sendMessage(String messageText) {
		try {
			Database database = new ExcelDatabase(new File("db.xls"));
			List<Contact> contacts = database.getAllContacts();
			Message message = new Message(contacts, 
			new MessageDetails(
					"GUI Test",
					messageText));
			message.send();
			System.out.println("Sent messages successfully.");
		} catch (Exception e) {
			System.out.println("An error has occurred.");
			e.printStackTrace();
		}
	}
	
	
}
