package com.mock.project.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.mock.project.model.Order;
import com.mock.project.model.User;

public class UserDAOImpl extends GenericDAOImplementation<User, Long> implements UserDAO {
	
	private EntityManager em;
	
	


	@Override
	public List<User> findAll(String username, String password) {
		return em.createQuery("from user where username= " + username + " and password= " + password).getResultList(); 
	}



	@Override
	public User findByPrimaryKey(User id) {
		// TODO Auto-generated method stub
		return null;
	}

}
