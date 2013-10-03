package edu.app.client.delegate;

import edu.app.client.locator.ServiceLocator;
import edu.app.persistence.User;
import edu.app.services.UserServiceRemote;

public class UserServiceDelegate{

	private static final String jndiName = "ejb:/esprit-ejb/UserService!edu.app.services.UserServiceRemote";
	
	private static UserServiceRemote getProxy(){
		return (UserServiceRemote)ServiceLocator
				.getInstance().
				 	getProxy(jndiName);
	}
	
	public static void create(User user) {
		getProxy().create(user);
		
	}

	public static User authenticate(String login, String password) {
		return getProxy().authenticate(login, password);
	}

}
