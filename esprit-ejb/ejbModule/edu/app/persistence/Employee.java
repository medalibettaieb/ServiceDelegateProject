package edu.app.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Employee extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3883095068717838819L;
	private String firstname;
	private String lastname;

	private List<Project> projects;

	public Employee() {
	}

	public Employee(String login, String password, String firstname,
			String lastname) {
		super(login, password);
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@ManyToMany(mappedBy = "employees")
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
