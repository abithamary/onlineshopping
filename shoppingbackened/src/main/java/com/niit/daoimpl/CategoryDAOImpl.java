package com.niit.daoimpl;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;


@Repository("categoryDAO")
@Transactional

public class CategoryDAOImpl  implements CategoryDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public boolean save(Category category) {
		try
		{
		sessionFactory.getCurrentSession().save(category);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Category category) {
		try
		{
		sessionFactory.getCurrentSession().update(category);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(Category category) {
				try {
	sessionFactory.getCurrentSession().delete(category);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	public List<Category> listCategories() {

		return sessionFactory.getCurrentSession().createQuery("from Category").list();
		
	}

	public Category getCategory(int categoryId) {
		
		  return 	(Category)  

sessionFactory.getCurrentSession().get(Category.class,categoryId);

	}


}

