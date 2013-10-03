package edu.app.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
@Entity
public class Admin extends User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7206440470618015491L;
	private int adminLevel;
	
	public Admin() {
	}
	
	public Admin(String login, String password, int adminLevel){
		super(login, password);
		this.adminLevel = adminLevel;
	}

	public int getAdminLevel() {
		return adminLevel;
	}

	public void setAdminLevel(int adminLevel) {
		this.adminLevel = adminLevel;
	}
	
	

}
