package com.nagarro.dao;

import com.nagarro.dto.User;
import com.nagarro.utils.SessionUtil;

import javax.persistence.NoResultException;

//import org.hibernate.HibernateException;
//import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    /**
     * authentication function to check user
     * @param username
     * @param password
     * @return user
     */
    
    public User validate(String username, String password) {
        User user = null;
	    try {
	    	Session session = SessionUtil.getSession();
	        String hql = "FROM User WHERE username=:username AND password=:password";
	        Query query = session.createQuery(hql);
		    query.setParameter("username", username);
		    query.setParameter("password", password);
		    user = (User) query.getSingleResult();
	    } catch (NoResultException e) {
	    	System.out.println("incorrect");
	        return null;
	    }
        return user;
    }

}