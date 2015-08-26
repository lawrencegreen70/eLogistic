package net.mv.dao;

import java.util.List;

import net.mv.pojo.Publication;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PublicationDao {

	@Autowired
	private SessionFactory sessionFactory;


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Publication> getAllPublication() {
		System.out.println("in get all publication");
		Session session  = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Publication.class);
		
		

		List<Publication> list = criteria.list();
		

		if (list.isEmpty()){
			System.out.println("publication list is empty");
			return null;
		}
		else{
			
			System.out.println("publication list not empty");
			System.out.println(list);
			return list;
		}
	}
	
	@Transactional 
	public void Move(String id){
		System.out.println("made it in the move method in publication dao");
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("from Publication where id = :var");
		query.setString("var", id);
		
		List<Publication> list = query.list();
		System.out.println(list);
		if (list.size() > 0){
			Publication p = list.get(0);

			if(p.getLocation().equals("Warehouse"))
				p.setLocation("Outlet");
			else
				p.setLocation("Warehouse");
			p.setApproved("False");
			sessionFactory.getCurrentSession().save(p);
		}
			
	}
	
	
	@Transactional 
	public void Request(String id){

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("from Publication where id = :var");
		query.setString("var", id);
		
		List<Publication> list = query.list();
		System.out.println(list);
		if (list.size() > 0){
			Publication p = list.get(0);

			p.setRequested("True");
			sessionFactory.getCurrentSession().save(p);
		}
			
	}
	
	
	@Transactional 
	public void Approve(String id){

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("from Publication where id = :var");
		query.setString("var", id);
		
		List<Publication> list = query.list();
		System.out.println(list);
		if (list.size() > 0){
			Publication p = list.get(0);

			p.setApproved("True");
			p.setRequested("False");
			sessionFactory.getCurrentSession().save(p);
		}		
	}
	
	@Transactional 
	public void Deny(String id){

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("from Publication where id = :var");
		query.setString("var", id);
		
		List<Publication> list = query.list();
		System.out.println(list);
		if (list.size() > 0){
			Publication p = list.get(0);

			p.setRequested("False");
			sessionFactory.getCurrentSession().save(p);
		}		
	}
	
	
	@Transactional 
	public String getNeedApproval(String id){

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("from Publication where id = :var");
		query.setString("var", id);
		
		List<Publication> list = query.list();
		System.out.println(list);
		if (list.size() > 0){
			Publication p = list.get(0);
			return p.getNeedApproval();	
		}
		return null;
			
	}
	
	@Transactional 
	public String getApproved(String id){

		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("from Publication where id = :var");
		query.setString("var", id);
		
		List<Publication> list = query.list();
		System.out.println(list);
		if (list.size() > 0){
			Publication p = list.get(0);
			return p.getApproved();	
		}
		return null;
			
	}
	
	
}

