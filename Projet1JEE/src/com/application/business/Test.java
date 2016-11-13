package com.application.business;

import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.application.beans.Group;
import com.application.beans.Person;

public class Test {

	public static void main(String[] args) throws DaoException {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("WEB-INF/springDataSource.xml");
		//PersonDao personDao = (PersonDao) applicationContext.getBean("personDao");
		PersonDao persondao = new PersonImpDao();
		
		Collection<Person> persons = persondao.findAllPersons(1234);
		for(Person player : persons){
            System.out.println(player.getIdPerson() + "\t" + player.getLastName()+"\t" + player.getFirstName());
        }
	}

}
