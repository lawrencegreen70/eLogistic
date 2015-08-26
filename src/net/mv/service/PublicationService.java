package net.mv.service;

import java.util.List;

import net.mv.dao.PublicationDao;
import net.mv.pojo.Publication;
import net.mv.pojo.Worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublicationService {
	
	@Autowired
	private PublicationDao publicationDao; 


	public List<Publication> GetPublications( ){		
		
		List<Publication> list = publicationDao.getAllPublication();
		return list;
	}
	
	public void Move(String id){
		publicationDao.Move(id);
	}
	
	
	public void Request(String id){
		publicationDao.Request(id);	
	}
	
	public void Approve(String id){
		publicationDao.Approve(id);
	}
	
	public void Deny(String id){
		publicationDao.Deny(id);
	}
	
	public String getNeedApproval(String id){
		return publicationDao.getNeedApproval(id);
	}
	public String getApproved(String id){
		return publicationDao.getApproved(id);
	}
}

