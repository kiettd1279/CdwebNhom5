package com.laptrinhweb.config;

public class ResponJWT {
	private final String tokenTile = "Bearer";
	private String accessToken;

	
	public ResponJWT(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenTile() {
		return tokenTile;
	}

}
