package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) // This is the fix
public class ResponsePojo {

	private String status;
	@JsonProperty("place_id")
	private String placeId;
	private String scope;
	
	public String getStatus() {
		return status;
	}

	public String getScope() {
		return scope;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPlaceId() { return placeId; }
    public void setPlaceId(String placeId) { 
    	this.placeId = placeId; 
    	}
	public void setscope(String scope) {
		this.scope = scope;
	}
	
}
