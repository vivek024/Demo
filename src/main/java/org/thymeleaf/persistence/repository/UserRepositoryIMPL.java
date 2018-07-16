/**
 * 
 */
package org.thymeleaf.persistence.repository;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.thymeleaf.persistence.model.User;

/**
 * @author V
 *
 */
@Repository
public class UserRepositoryIMPL implements UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private HttpServletRequest request;

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @param request
	 *            the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	private Session getSession() {
		Session session = getSessionFactory().getCurrentSession();
		if (session == null) {
			session = getSessionFactory().openSession();
		}
		return session;
	}

	@Override
	public void registeruser(User user) {

		user.setCreatedate(Calendar.getInstance());
		getSession().persist(user);
	}

}
