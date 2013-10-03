package edu.app.services;

import java.util.List;

import javax.ejb.Remote;

import edu.app.persistence.Category;
import edu.app.persistence.Product;


@Remote
public interface CategoryServiceRemote {
	
	void createCategory(Category category);
	void updateCategory(Category category);
	Category findCategoryById(int id);
	void deleteCategory(Category category);
	List<Category> findAllCategories();
	List<Product> findProductsByCategory(Category category);
	boolean isManaged(Category category);
	void link(Category category, Product... product);
}
