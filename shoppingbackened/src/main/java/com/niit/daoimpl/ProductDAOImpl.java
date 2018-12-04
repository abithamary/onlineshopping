package com.niit.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;
@Repository("productDAO")
@Transactional

public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public boolean save(Product Product) {
		try
		{
		sessionFactory.getCurrentSession().save(Product);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Product Product) {
		try
		{
		sessionFactory.getCurrentSession().update(Product);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(Product Product) {
				try {
	sessionFactory.getCurrentSession().delete(Product);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	public List<Product> listCategories() {

		return sessionFactory.getCurrentSession().createQuery("from Product").list();
		
	}

	public Product getProduct(int ProductId) {
		
		  return 	(Product)  

sessionFactory.getCurrentSession().get(Product.class,ProductId);

	}


}





