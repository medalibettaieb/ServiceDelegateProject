package edu.app.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name="t_user")
public class User implements Serializable {

	
	private int id;
	private String login;
	private String password;
	
	
	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}

	private static final long serialVersionUID = 1L;

	public User() {
	}   
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	@Column( unique = true )
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
   
}
