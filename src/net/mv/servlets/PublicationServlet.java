package net.mv.servlets;


import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.mv.email.Email;
import net.mv.pojo.Publication;
import net.mv.service.LoginService;
import net.mv.service.PublicationService;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublicationServlet extends Action{
	
	@Autowired
	private LoginService login;
	
	@Autowired
	private PublicationService publication;

	@Override
	public ActionForward execute (ActionMapping mapping, ActionForm form, 
			HttpServletRequest req, HttpServletResponse res)
			throws AddressException, UnsupportedEncodingException, MessagingException{
		
		List<Publication> list;
	
		String action = req.getParameter("action");
		System.out.println(action);
		
		if(action.equals("Login")){
			String username = req.getParameter("username");
			String password = req.getParameter("password");
	
			System.out.println("Username and Password: " + username + ", "
					+ password);
			
			boolean loggedIn = login.LogIn(username, password);
	
			if(loggedIn){
				System.out.println(username + " is logged in");
				
				list = publication.GetPublications();
				String role = login.GetRole(username);

				HttpSession session = req.getSession();
	            session.setAttribute("list", list);
	            session.setAttribute("role", role);
	            
				return mapping.findForward("LoginSuccess");
			}
			else {
				System.out.println("login failed");
				return mapping.findForward("LoginFailed");
			}
		}
		else if (action.equals("Move")){
						
			System.out.println("At move");
			String id = req.getParameter("id");
			System.out.println("User id is " + id);
			
			if(publication.getNeedApproval(id).equals("True") &&
					publication.getApproved(id).equals("False"))
				return mapping.findForward("NoGood");
			
			publication.Move(id);

		}
		else if(action.equals("GetRequest")){
			System.out.println("at get request");
			
			String id = req.getParameter("id");
			if(publication.getNeedApproval(id).equals("False") ||
					publication.getApproved(id).equals("True"))
				return mapping.findForward("NoGood");
			
			publication.Request(id);
		}
		else if(action.equals("Approve")){
			
			String id = req.getParameter("id");
			
			if(publication.getNeedApproval(id).equals("False") ||
					publication.getApproved(id).equals("True"))
				return mapping.findForward("NoGood");
			
			publication.Approve(id);

			Email email = new Email();
			email.makeEmail("Your message was approved");
			

		}
		else if(action.equals("Deny")){;
			String id = req.getParameter("id");
		
			if(publication.getNeedApproval(id).equals("False") ||
				publication.getApproved(id).equals("True"))
			return mapping.findForward("NoGood");
		
			publication.Deny(id);
			Email email = new Email();
			email.makeEmail("Your message was denied");

		}
		else if(action.equals("Complete Another Action")){		
			return mapping.findForward("Action");
		}
		
		list = publication.GetPublications();
		HttpSession session = req.getSession();
		session.setAttribute("list", list);   	
		
		return mapping.findForward("WereGood");
	}

}
