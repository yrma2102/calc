package com.coding.web.models;

public class Calculator {
	private int id;
	private static int count = 0; 
	private int result;
	public Calculator() {
		this.id = ++count;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	
}
