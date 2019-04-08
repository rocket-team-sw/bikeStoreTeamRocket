package com.RocketbackEndJwt.api.response;

import java.io.Serializable;
import java.util.List;

public class Response<T> implements Serializable {

private static final long serialVersionUID = 1L;
	
	T data;
	List<T> list;
	String message;
	int code;
	
	public Response(T data, List<T> list, String message, int code) {
		super();
		this.data = data;
		this.list = list;
		this.message = message;
		this.code = code;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}	
}
