package com.niit.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.UserDAO;
import com.niit.model.User;
@Repository("userDAO")
@Transactional


public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public boolean save(User User) {
		try
		{
		sessionFactory.getCurrentSession().save(User);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(User User) {
		try
		{
		sessionFactory.getCurrentSession().update(User);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(User User) {
				try {
	sessionFactory.getCurrentSession().delete(User);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	public List<User> listCategories() {

		return sessionFactory.getCurrentSession().createQuery("from User").list();
		
	}

	public User getUser(int UserId) {
		
		  return 	(User)  

sessionFactory.getCurrentSession().get(User.class,UserId);

	}


}






	



	

}
