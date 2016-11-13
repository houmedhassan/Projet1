package com.application.business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.application.beans.Group;
import com.application.beans.Person;

/**
 * 
 * @author HOUMED, ABDOULRAHIM
 *
 */
@Service
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
    
    
    final private RowMapper<Person> personMapper = new RowMapper<Person>(){
    	@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Person person =new Person();
			person.setIdPerson(rs.getLong("idPerson"));
			person.setLastName(rs.getString("lastName"));
			person.setFirstName(rs.getString("firstName"));
			person.setMail(rs.getString("mail"));
			person.setWebSite(rs.getString("webSite"));
			person.setBirthDay(rs.getString("birthDay"));
			person.setPassword(rs.getString("password"));
			person.setIdGroup(rs.getString("idGroup"));
			return person;
    	}
    };
    
    final private RowMapper<Group> groupMapper = new RowMapper<Group>(){
		@Override
		public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Group group =new Group();
			group.setIdGroup(rs.getLong("idGroup"));
			group.setName(rs.getString("name"));
			return group;
		}
	};
    
    
	@Override
	public Collection<Group> findAllGroups() throws DaoException {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.query("SELECT * FROM GROUP", groupMapper);
	}

	@Override
	public Collection<Person> findAllPersons(long groupId) throws DaoException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM PERSON WHERE idGroup=?";
		
		return this.jdbcTemplate.query(sql, new Object[]{groupId}, personMapper);
	}
	
	@Override
	public Person findPerson(long idPerson) throws DaoException {
		// TODO Auto-generated method stub
		Person person = this.jdbcTemplate.queryForObject("SELECT * FROM PERSON WHERE IDPERSON=?",
		new Object[]{idPerson},
		personMapper
		);
		return person;
		
	}

	@Override
	public Group findGroup(long groupId) throws DaoException {
		// TODO Auto-generated method stub
		Group group = this.jdbcTemplate.queryForObject("SELECT * FROM GROUP WHERE IDGROUP=?",
				new Object[]{groupId},
				groupMapper);
		return group;
	}

	@Override
	public int savePerson(Person p) throws DaoException {
		// TODO Auto-generated method stub
		String sql="INSERT INTO PERSON VALUES("
						+ "'"+p.getIdPerson()+"','"
						+"'"+p.getLastName()+"',"
						+"'"+p.getFirstName()+"',"
						+"'"+p.getMail()+"',"
						+"'"+p.getWebSite()+"',"
						+"'"+p.getBirthDay()+"',"
						+"'"+p.getPassword()+"',"
						+"'"+p.getIdGroup()+"'"
					+")";
		return this.jdbcTemplate.update(sql);
		
	}

	@Override
	public int saveGroup(Group g) throws DaoException {
		// TODO Auto-generated method stub
		String sql="INSERT INTO GROUP VALUES("
						+ "'"+g.getIdGroup()+"',"
						+ "'"+g.getName()+"'"
					+ ")";
		return this.jdbcTemplate.update(sql);
	}

	@Override
	public int editPerson(long idPerson, Person p) throws DaoException {
		// TODO Auto-generated method stub
		String sql="UPDATE PERSON set lastName = ?, firstName=?, mail=?, "
					+ "webSite=?, birthDay=?, password=?, idGroup=?   where idPerson='"+idPerson+"'";
		return this.jdbcTemplate.update(sql, p.getLastName(), p.getFirstName(), p.getMail(), 
										p.getWebSite(), p.getBirthDay(),p.getPassword(), p.getIdGroup() );
	}

}


