package com.example.mainguyen.sportshopapp.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseStatus {
	
	private int status;
	
	private String message;

	private Object dataObject;


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getDataObject() {
		return dataObject;
	}

	public void setDataObject(Object dataObject) {
		this.dataObject = dataObject;
	}

	@Override
	public String toString() {
		return "ResponseStatus{" +
				"status=" + status +
				", message='" + message + '\'' +
				", dataObject=" + dataObject +
				'}';
	}
}
