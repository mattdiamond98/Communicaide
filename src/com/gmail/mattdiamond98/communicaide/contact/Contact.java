package com.gmail.mattdiamond98.communicaide.contact;

import java.util.HashMap;
import java.util.Map;

import com.gmail.mattdiamond98.communicaide.platforms.PlatformType;

public class Contact implements Destination {
	
	private String name;
	private Map<PlatformType, String> platforms;
	
	public Contact(String name) {
		this.name = name;
		platforms = new HashMap<>();
	}
	
	public String getName() {
		return name;
	}
	
	public boolean hasPlatformType(PlatformType type) {
		return platforms.containsKey(type);
	}
	
	public Contact setName(String name) {
		this.name = name;
		return this;
	}
	
	public Contact putPlatform(PlatformType platform, String value) {
		platforms.put(platform, value);
		return this;
	}
	
	public String getPlatformValue(PlatformType platform) {
		return platforms.get(platform);
	}
	
	public String toString() {
		return name + " : " + platforms.toString();
	}
	
}
