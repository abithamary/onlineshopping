package com.niit.dao;

import java.util.List;

import com.niit.model.Supplier;

public interface SupplierDAO {
public boolean save(Supplier Supplier);
	
	public boolean delete(Supplier Supplier);
	public boolean update(Supplier Supplier);
	public List<Supplier> listCategories();
	public Supplier getSupplier(int SupplierId);




}
