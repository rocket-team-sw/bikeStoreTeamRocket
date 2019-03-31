package com.RocketbackEndJwt.api.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Response<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private T data;
	private List<T> list;
	private String message;
	private int code;
	
	public Response(T data, String message, int code) {
		this.data = data;
		this.list = new ArrayList<>();
		this.message = message;
		this.code = code;
	}
	
	public Response(List<T> list, String message, int code) {
		this.list = list;
		this.data = (T) new Object();
		this.message = message;
		this.code = code;
	}
	
	public Response(String message, int code) {
		this.data = (T) new Object();
		this.list = new ArrayList<>();
		this.message = message;
		this.code = code;
	}
	
}
