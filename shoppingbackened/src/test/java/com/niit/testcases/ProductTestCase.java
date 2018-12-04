package com.niit.testcases;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

public class ProductTestCase {

	static ProductDAO productDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.niit");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	@Ignore
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductName("samsung");
		product.setProductDesc("smart phone");
		assertTrue("Probem in Adding the Product",productDAO.save(product));
	}
	
	//@Ignore
	@Test
	public void updateProductTest()
	{	
		Product product=productDAO.getProduct(13);
		product.setProductDesc("All kind of SamsungGalaxy Smartphones");	
		assertTrue("Problem in Updating the Product",productDAO.update(product));
	}
	@Ignore
	@Test
	public void deleteProductTest()
	{
		Product product=productDAO.getProduct(10);
		assertTrue("Problem in Delete the Product",productDAO.delete(product));
	}
	
	@Test
	public void listProductsTest()
	{
		List<Product> listproducts=productDAO.listproducts();
		
		assertTrue("Problem in Listing the Categories",listproducts.size()>0);
		
		for(Product product:listproducts)
		{
			System.out.print("Product ID:"+product.getProductId());
			System.out.print("   Product Name:"+product.getProductName());
			System.out.println("   Product Desc:"+product.getProductDesc());
		}
	}


}
