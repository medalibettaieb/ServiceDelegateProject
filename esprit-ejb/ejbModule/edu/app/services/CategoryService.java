package edu.app.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.app.persistence.Category;
import edu.app.persistence.Product;

@Stateless
public class CategoryService implements CategoryServiceRemote, CategoryServiceLocal {
	
	@PersistenceContext( unitName = "PU" )
	private EntityManager em;

    public CategoryService() {
    }

	public void createCategory(Category category) {
		em.persist(category);
	}

	public void updateCategory(Category category) {
		em.merge(category);
	}

	public Category findCategoryById(int id) {
		return em.find(Category.class, id);
	}

	public void deleteCategory(Category category) {
		em.remove(em.merge(category));
	}

	public List<Category> findAllCategories() {
		return em.createQuery("select c from Category c", Category.class).getResultList();
	}

	public List<Product> findProductsByCategory(Category category) {
		return em.createQuery("select p from Product p where p.category = :p1", Product.class).setParameter("p1", category).getResultList();
	}

	public boolean isManaged(Category category) {
		return em.contains(category);
	}

	public void link(Category category, Product... products) {
		List<Product> categoryProducts = findProductsByCategory(category);
		category.setProducts(categoryProducts);
		for(Product product : products){
			category.addProduct(product);
			em.merge(product);
		}
		em.merge(category);
	}

	

	

}
