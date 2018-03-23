package com.niit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.UserDetail;

public class UserDetailDAOImpl implements UserDetailDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	
	public boolean addUser(UserDetail userDetail) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().save(userDetail);
			return true;
		}
		catch(Exception e) {
			System.out.println("Exception arised"+e);
			return false;
		}
	}
@Transactional
	
	public boolean updateUser(UserDetail userDetail) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(userDetail);
			return true;
		}
		catch(Exception e) {
			System.out.println("Exception arised"+e);
			return false;
		}
}
		public UserDetail getUser(String userName) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.openSession();
			UserDetail user=session.get(UserDetail.class, userName);
			session.close();
			return user;
	}
		@Transactional
		public boolean deleteUser(UserDetail userDetail) {
			// TODO Auto-generated method stub
			try {
				sessionFactory.getCurrentSession().delete(userDetail);
				return true;
			}
			catch(Exception e) {
				return false;
			}
		}
		public List<UserDetail> listUsers() {
			// TODO Auto-generated method stub
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from UserDetail");
			List<UserDetail> list=(List<UserDetail>)query.list();
			return list;
		}
}
