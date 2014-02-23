package edu.app.services;

import java.util.List;

import javax.ejb.Remote;

import edu.app.persistence.Product;

@Remote
public interface ProductServiceRemote {
	
	void createProduct(Product product);
	void updateProduct(Product product);
	Product findProductById(int id);
	void deleteProduct(Product product);
	List<Product> findAllProducts();
	boolean isManaged(Product product);

}
