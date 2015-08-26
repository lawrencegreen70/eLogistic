package net.mv.service;

import net.mv.dao.LoginDao;
import net.mv.pojo.Worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
		
		@Autowired
		private LoginDao loginDao; 
		Worker	worker = new Worker();

		public boolean LogIn(String username, String password ){		
			
			Worker	worker = new Worker();
			
			System.out.println("getting ready to update worker");
			worker = (Worker) loginDao.getPersonByUserName(username);
			System.out.println("worker is updated");
		
			
			//is returning true check in detail
			if( worker !=null &&  worker.getPassword().equals(password))
			{
   				System.out.println(worker);
				return true;
			}
			return false;	
		}
		
		public String GetRole(String username){
			
			worker = (Worker) loginDao.getPersonByUserName(username);
			return worker.getRole();
			
		}
}
