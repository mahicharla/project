package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Supplier;

public class SupplierDAOTest {

static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void preExecution() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
	
	@Ignore
	@Test
	public void addSupplierTest() {
		Supplier supplier=new Supplier();
		supplier.setSupplierName("anusha");
		supplier.setSupplierAddr("kasaragod");
		assertTrue("Error in Adding Supplier",supplierDAO.addSupplier(supplier));
	}
	@Ignore
	@Test
	public void updateSupplierTest()
	{
		Supplier supplier=supplierDAO.getSupplier(10);
		supplier.setSupplierName("Anil");
		assertTrue("Problem in Updating",supplierDAO.updateSupplier(supplier));
	}
	
	@Ignore
	@Test
	public void deleteSupplierTest() {
		Supplier supplier=supplierDAO.getSupplier(8);
		assertTrue("Problem in deletion of supplier", supplierDAO.deleteSupplier(supplier));
	}
	@Ignore
	@Test
	public void listSuppliersTest() {
		List<Supplier> list =supplierDAO.listSuppliers();
		for(Supplier supplier:list) {
			System.out.println(supplier.getSupplierId()+"\t"+supplier.getSupplierName()+"\t\t\t"+supplier.getSupplierAddr());
		}
		assertNotNull("problem in retreiving",list);
	}
	

}
