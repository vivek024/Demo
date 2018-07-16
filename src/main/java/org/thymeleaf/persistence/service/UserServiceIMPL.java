/**
 * 
 */
package org.thymeleaf.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.persistence.model.User;
import org.thymeleaf.persistence.repository.UserRepository;

/**
 * @author vee
 *
 */
@Service
@Transactional
public class UserServiceIMPL implements UserService{
	
	@Autowired
	private UserRepository repository;
	
	

	/**
	 * @return the repository
	 */
	public UserRepository getRepository() {
		return repository;
	}



	/**
	 * @param repository the repository to set
	 */
	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}



	@Override
	public void registeruser(User user) {
		repository.registeruser(user);
		
	}

}
