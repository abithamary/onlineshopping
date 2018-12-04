package com.niit.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;
@Repository("supplierDAO")
@Transactional

public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public SupplierDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public boolean save(Supplier Supplier) {
		try
		{
		sessionFactory.getCurrentSession().save(Supplier);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Supplier Supplier) {
		try
		{
		sessionFactory.getCurrentSession().update(Supplier);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(Supplier Supplier) {
				try {
	sessionFactory.getCurrentSession().delete(Supplier);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	public List<Supplier> listCategories() {

		return sessionFactory.getCurrentSession().createQuery("from Supplier").list();
		
	}

	public Supplier getSupplier(int SupplierId) {
		
		  return 	(Supplier)  

sessionFactory.getCurrentSession().get(Supplier.class,SupplierId);

	}


}






	


