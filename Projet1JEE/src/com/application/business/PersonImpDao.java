package com.application.business;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.application.beans.Group;
import com.application.beans.Person;

@Service("personannuaireDao")
public class PersonImpDao implements PersonDao{

	JdbcTemplate jdbcTemplate;
    protected final Log logger = LogFactory.getLog(getClass());
    
    @PostConstruct
    public void init() {
        logger.info("Create Table");
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS GROUP("+
    			"idGroup INT PRIMARY KEY"+
    			"name VARCHAR(500)"+
    		")");
        
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS PERSON(" + //
                "idPerson INT PRIMARY_KEY" + //
        		"lastName VARCHAR(100)"+//
                "firstName VARCHAR(100)"+//
        		"mail VARCHAR(250)"+//
                "webSite VARCHAR(250)"+//
        		"birthDay DATE"+//
                "password VARCHAR(50)" + //
        		"idGroup INT FOREIGN KEY REFERENCES GROUP(idGroup) "+//
                ")");     
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
	public Collection<Group> findAllGroups() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Person> findAllPersons(long groupId) throws DaoException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM personne where idGroup='"+groupId+"'";
		Collection<Person> listPerson = this.jdbcTemplate.query(sql, new BeanPropertyRowMapper(Person.class));
		return listPerson;
	}
	
	@Override
	public Person findPerson(long idPerson) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group findGroup(long GroupId) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void savePerson(Person p) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveGroup(Group g) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editPerson(long idPerson) throws DaoException {
		// TODO Auto-generated method stub
		
	}

}
