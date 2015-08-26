package net.mv.dao;

import java.util.List;

import net.mv.pojo.Worker;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LoginDao {

	@Autowired
	private SessionFactory sessionFactory;


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Worker getPersonByUserName(String username) {
		
		Session session  = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Worker.class);
		
		criteria.add(Restrictions.eq("username", username));
	
		List<Worker> list = criteria.list();
		

		if (list.isEmpty()){
			System.out.println("login list is empty");
			return null;
		}
		else{
			
			System.out.println("login list not empty");
			return list.get(0);
		}
	}
}
