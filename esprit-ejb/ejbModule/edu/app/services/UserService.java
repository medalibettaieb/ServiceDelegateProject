package edu.app.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.app.persistence.Employee;
import edu.app.persistence.Project;
import edu.app.persistence.User;

@Stateless
public class UserService implements UserServiceRemote {

	@PersistenceContext(unitName = "PU")
	private EntityManager entityManager;

	public UserService() {
	}

	public void create(User user) {
		entityManager.persist(user);
	}

	public User authenticate(String login, String password) {
		User found = null;
		String jpql = "select u from User u where u.login=:p1 and u.password=:p2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("p1", login);
		query.setParameter("p2", password);
		try {
			found = (User) query.getSingleResult();
		} catch (Exception e) {
		}

		return found;
	}

	@Override
	public void initDb() {
		Employee employee = new Employee("daly", "daly", "daly", "daly");
		Employee employee2 = new Employee("d", "d", "d", "d");

		Project project = new Project("jee");
		Project project2 = new Project("dotnet");

		List<Project> projects = new ArrayList<Project>();
		projects.add(project);
		projects.add(project2);

		for (Project p : projects) {
			entityManager.persist(p);
		}
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee);
		employees.add(employee2);

		for (Employee e : employees) {
			entityManager.persist(e);
		}

	}

	@Override
	public void link(int idUser, int idProject) {
		Project projectFound = entityManager.find(Project.class, idProject);
		projectFound.getEmployees().add(
				entityManager.find(Employee.class, idUser));

		entityManager.merge(projectFound);
	}

}
