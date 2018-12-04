package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDAO {
public boolean save(Product Product);
	
	public boolean delete(Product Product);
	public boolean update(Product Product);
	public List<Product> listproducts();
	public Product getProduct(int ProductId);

	



}
