package org.launchcode.models.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.launchcode.models.HelloLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional // required for hibernate and spring to automatically use this interface
@Repository  // required for hibernate and spring to automatically use this interface
public interface HelloLogDao extends CrudRepository<HelloLog, Integer> { // CrudRepository allows us to lookup an entry within a db that has a certain variable type as its key value (in this case we are looking up HelloLog that has an Integer as its key value)
	
	// the two method names below must be exact or progrm will fail
	public List<HelloLog> findAll(); // required for hibernate and spring to automatically use this interface
	
	public HelloLog findByUid(Integer uid); // required for hibernate and spring to automatically use this interface
	
	// we can use any method named "findBy"[variable in class]
	
}
