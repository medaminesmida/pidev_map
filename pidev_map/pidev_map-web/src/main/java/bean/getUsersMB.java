package bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import Entities.User;
import Interfaces.UserServiceLocal;



@ManagedBean
@ViewScoped
public class getUsersMB {
	
	@EJB
	UserServiceLocal service;
	public List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public void init(){
		users= service.getAll();
	}
	
	
}
