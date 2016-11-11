package com.application.beans;

/**
 * 
 * @author Houmed, Abdoulrahim
 *
 */
public class Person {
	
	private long idPerson;
	private String lastName;
	private String firstName;
	private String mail;
	private String webSite;
	private String birthDay;
	private String password;
	private String idGroup;
	
	/**
	 * Constructor
	 */
	public Person(){
		
	}
	
	/**
	 * @return idPerson of Person
	 */
	public long getIdPerson() {
		return idPerson;
	}
	/**
	 * @param idPerson this is  represents the idPerson of the Person
	 */
	public void setIdPerson(long idPerson) {
		this.idPerson = idPerson;
	}
	/**
	 * @return lastName of Person
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * 
	 * @param lastName this is represents the lastPerson of the  Person
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return firstName of Person
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName this is represents the firstName of the  Person
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return mail of Person
	 */
	public String getMail() {
		return mail;
	}
	
	/**
	 * @param mail this is represents the mail of the person
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * @return webSite of Person
	 */
	public String getWebSite() {
		return webSite;
	}
	
	/**
	 * @param webSite  this is represents the webSite of the person
	 */
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	
	/**
	 * @return  birthDay of person
	 */
	public String getBirthDay() {
		return birthDay;
	}
	
	/**
	 * @param birthDay  this is represents the birthDay of the person
	 */
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	
	/**
	 * @return password of Person
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * @param password this is represents the password of the person
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return idGroup of Person
	 */
	public String getIdGroup() {
		return idGroup;
	}
	
	/**
	 * @param idGroup 
	 */
	public void setIdGroup(String idGroup) {
		this.idGroup = idGroup;
	}
	
}
