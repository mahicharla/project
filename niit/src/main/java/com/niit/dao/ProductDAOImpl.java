package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Product;

public class ProductDAOImpl implements ProductDAO{

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	@Transactional
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	
	@Transactional
	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Product product=session.get(Product.class, productId);
		return product;
	}

	public List<Product> listProducts() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> list=(List<Product>)query.list();
		return list;
	}
}
