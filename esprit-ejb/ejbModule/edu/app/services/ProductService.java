package edu.app.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.app.persistence.Product;

@Stateless
public class ProductService implements ProductServiceRemote, ProductServiceLocal {

	@PersistenceContext( unitName = "PU" )
	private EntityManager em;
	
    public ProductService() {
    }

	public void createProduct(Product product) {
		em.persist(product);
	}

	public void updateProduct(Product product) {
		em.merge(product);
	}

	public Product findProductById(int id) {
		return em.find(Product.class, id);
	}

	public void deleteProduct(Product product) {
		em.remove(em.merge(product));
	}

	public List<Product> findAllProducts() {
		return em.createQuery("select p from Product p", Product.class).getResultList();
	}

	public boolean isManaged(Product product) {
		return em.contains(product);
	}

}
