package edu.app.tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.app.services.UserServiceRemote;

public class TestInitBd {
	private static final String jndiName = "ejb:/esprit-ejb/UserService!"
			+ UserServiceRemote.class.getCanonicalName();

	public static void main(String[] args) throws NamingException {
		UserServiceRemote remote = null;
		Context ctx = new InitialContext();
		remote = (UserServiceRemote) ctx.lookup(jndiName);

		//remote.initDb();
		remote.link(1, 1);
	}

}
