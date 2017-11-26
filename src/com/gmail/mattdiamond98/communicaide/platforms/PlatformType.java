package com.gmail.mattdiamond98.communicaide.platforms;

public enum PlatformType {
	
	EMAIL(new EmailPlatform());
	
	private Platform platform;
	
	private PlatformType(Platform platform) {
		this.platform = platform;
	}
	
	public Platform getPlatform() {
		return platform;
	}
	
}
