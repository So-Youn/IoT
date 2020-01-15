package api.util;

public class StudentDTO {
	private int number;
	private String name;
	private int java;
	private int web;
	private int android;
	
	public StudentDTO() {
		
	}
	public StudentDTO(int number, String name, int java, int web, int android) {
		super();
		this.number = number;
		this.name = name;
		this.java = java;
		this.web = web;
		this.android = android;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getWeb() {
		return web;
	}
	public void setWeb(int web) {
		this.web = web;
	}
	public int getAndroid() {
		return android;
	}
	public void setAndroid(int android) {
		this.android = android;
	}
	
	
}