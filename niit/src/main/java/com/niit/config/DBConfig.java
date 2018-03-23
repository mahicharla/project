package com.niit.config;

import javax.sql.DataSource;
import java.util.Properties;

//import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.niit.dao.CategoryDAO;
import com.niit.dao.CategoryDAOImpl;
import com.niit.dao.ProductDAO;
import com.niit.dao.ProductDAOImpl;
import com.niit.dao.SupplierDAO;
import com.niit.dao.SupplierDAOImpl;
import com.niit.dao.UserDetailDAO;
import com.niit.dao.UserDetailDAOImpl;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.UserDetail;

@Configuration 
@EnableTransactionManagement
public class DBConfig {
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:~/test/MAHI");
	
		dataSource.setUsername("mahi");
		dataSource.setPassword("mahi");
		
		System.out.println("---Data Source Object created-----");
		
		return dataSource;
	}
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProp=new Properties();
		
		hibernateProp.put("hibernate.hbm2ddl.auto","update");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		//hibernateProp.put("hibernate.show_sql", "true");
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getH2DataSource());
		factory.addProperties(hibernateProp);
		
		factory.addAnnotatedClass(Category.class);
		factory.addAnnotatedClass(Supplier.class);
		factory.addAnnotatedClass(UserDetail.class);
		factory.addAnnotatedClass(Product.class);
		SessionFactory sessionFactory=factory.buildSessionFactory();
		System.out.println("----SessionFactory Object Created------");	
		return sessionFactory;
		
	}
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO()
	{
		System.out.println("---Category Bean Created---");
		return (CategoryDAO) new CategoryDAOImpl();
	}
	@Bean(name="supplierDAO")
	public SupplierDAO getSupplierDAO()
	{
		System.out.println("---Supplier Bean Created---");
		return (SupplierDAO) new SupplierDAOImpl();
	}
	@Bean(name="productDAO")
	public ProductDAO getProductDAO()
	{
		System.out.println("---Product Bean Created---");
		return (ProductDAO) new ProductDAOImpl();
	}
	@Bean(name="userdetailDAO")
	public UserDetailDAO getUserDetailDAO()
	{
		System.out.println("----UserDetail Bean created---");
		return (UserDetailDAO) new UserDetailDAOImpl();
	}

	
	@Bean(name="txManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("---Hibernate Transaction Bean Created---");
		return new HibernateTransactionManager(sessionFactory);
	}


}
