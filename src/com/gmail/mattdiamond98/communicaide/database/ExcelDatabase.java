package com.gmail.mattdiamond98.communicaide.database;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gmail.mattdiamond98.communicaide.contact.Contact;
import com.gmail.mattdiamond98.communicaide.platforms.PlatformType;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelDatabase implements Database {
	
	private Workbook workbook;
	private Sheet sheet;
	
	private Map<String, Integer> headers;
	
	public ExcelDatabase(File f) throws BiffException, IOException {
		headers = new HashMap<>();
		//Sheet indexes references as (column, row)
		workbook = Workbook.getWorkbook(f);
		sheet = workbook.getSheet(0);
		Cell[] topRow = sheet.getRow(0);
		for (Cell cell : topRow) {
			if (cell.getContents().equalsIgnoreCase("NAME")) {
				headers.put("NAME", cell.getColumn());
			}
			for (PlatformType platform : PlatformType.values()) {
				if (cell.getContents().equalsIgnoreCase(platform.name())) {
					headers.put(platform.name(), cell.getColumn());
				}
			}
		}
	}
	
	public Contact getContact(int index) {
		Contact contact =  new Contact(sheet.getCell(headers.get("NAME"), index).getContents());
		for (PlatformType platform : PlatformType.values()) {
			if (headers.containsKey(platform.name())) {
				contact.putPlatform(platform, sheet.getCell(headers.get(platform.name()), index).getContents());
			}
		}
		return contact;
	}
	
	public List<Contact> getAllContacts() {
		List<Contact> allContacts = new ArrayList<>();
		for (int i = 1; i < sheet.getColumn(0).length; i++) {
			allContacts.add(getContact(i));
		}
		return allContacts;
	}
	
}
