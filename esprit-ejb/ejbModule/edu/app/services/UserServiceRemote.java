package edu.app.services;

import javax.ejb.Remote;

import edu.app.persistence.User;

@Remote
public interface UserServiceRemote {

	void create(User user);

	User authenticate(String login, String password);

	void initDb();

	void link(int idUser, int idProject);

}
