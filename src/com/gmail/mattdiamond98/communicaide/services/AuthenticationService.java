package com.gmail.mattdiamond98.communicaide.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class AuthenticationService {
		
	public static String getEmailUsername() {
		return getTextFromLineStartingWith("username:");
	}
	
	public static String getEmailPassword() {
		
		return getTextFromLineStartingWith("password:");
	}
	
	public static String getTextFromLineStartingWith(String prefix) {
		try {
			File f = new File("authentication");
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(f);
			while (scan.hasNext()) {
				String ln = scan.next();
				if (ln.contains(prefix)) {
					return ln.substring(ln.indexOf(prefix) + prefix.length()).trim();
				}
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
