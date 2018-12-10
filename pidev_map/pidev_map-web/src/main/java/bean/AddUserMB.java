package bean;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entities.User;
import Interfaces.UserServiceLocal;


@ManagedBean
@SessionScoped
public class AddUserMB {
	@EJB
	private UserServiceLocal service;
	private User user = new User() ; 
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@PostConstruct
	public void init(){
		
	}
	
	public void doadd() {
		
		service.AddUser(user);
	}

	
	
	public String getParam (String id)
	{
		FacesContext fc=FacesContext.getCurrentInstance();
		Map<String,String> params =fc.getExternalContext().getRequestParameterMap();
		return params.get(id);
		
		
	}
	
	
	
}
