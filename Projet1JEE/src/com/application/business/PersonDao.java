package com.application.business;

import java.util.Collection;

import com.application.beans.Group;
import com.application.beans.Person;

/**
 * 
 * @author HOUMED, ABDOULRAHIM
 *
 */
public interface PersonDao {
		/**
		 * @return  existing group list in the database
		 */
	   Collection<Group> findAllGroups() throws DaoException;

	   /**
	    * @param groupId 
	    * @return the list of people who belong to a group in precise parameter
	    */
	   Collection<Person> findAllPersons(long groupId) throws DaoException;

	   /**
	    * @param id
	    * @return the person whose the id is passed as a parameter
	    */
	   Person findPerson(long idPerson) throws DaoException;
	   
	   /**
	    * @param GroupId
	    * @return the group whose the id is passed as a parameter
	    */
	   Group findGroup(long GroupId) throws DaoException;

	   /**
	    * @param p
	    * this method add a person in database
	    */
	   int savePerson(Person p) throws DaoException;

	   /**
	    * @param g
	    *  this method  add a group in database
	    */
	   int saveGroup(Group g) throws DaoException;
	   
	   /**
	    * @param idPerson
	    * this method edit a person whose the id is passed as a parameter
	    */
	   int editPerson(long idPerson, Person p) throws DaoException;
	   
	   
	   
	   
}
