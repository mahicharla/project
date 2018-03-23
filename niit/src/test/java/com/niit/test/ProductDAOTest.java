package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;

public class ProductDAOTest {
static ProductDAO productDAO;
	@BeforeClass
	public static void preExecution() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	@Ignore
	@Test
	public void addProductTest() {
		Product product=new Product();
		product.setPrice(8000);
		product.setProductDesc("nokia_mobile");
		product.setCategoryId(2);
		product.setProductName("nokia");
		product.setStock(7);
		product.setSupplierId(10);
		assertTrue("Error in adding product",productDAO.addProduct(product));
	}
	
	@Ignore
	@Test
	public void updateProductTest() {
		Product product=productDAO.getProduct(6);
		product.setCategoryId(5);
		assertTrue("Error in updating",productDAO.updateProduct(product));
	}
	
	@Ignore
	@Test
	public void deleteProductTest() {
		Product product=productDAO.getProduct(5);
		assertTrue("Error in deleting",productDAO.deleteProduct(product));
	}
	@Ignore
	@Test
	public void listProductsTest() {
		List<Product> list =productDAO.listProducts();
		for(Product product:list) {
			System.out.println(product.getProductId()+"\t\t"+product.getCategoryId()+"\t\t"+product.getSupplierId()+"\t\t"+product.getProductName()+"\t\t"+product.getProductDesc()+"\t\t"+product.getPrice()+"\t\t"+product.getStock()+"\t\t");
		}
		assertNotNull("Error in listing products",productDAO.listProducts());
	}
}
