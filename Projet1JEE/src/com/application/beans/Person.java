package com.application.beans;

public class Person {

	private String idPerson;
	private String lastName;
	private String firstName;
	private String mail;
	private String webSite;
	private String birthDay;
	private String password;
	
	
	public Person(){
		
	}
	
	/*
	 * 
	 */
	
	public String getIdPerson() {
		return idPerson;
	}
	public void setIdPerson(String idPerson) {
		this.idPerson = idPerson;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
