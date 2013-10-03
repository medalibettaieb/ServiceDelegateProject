package edu.app.tests;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.app.persistence.Product;
import edu.app.services.ProductServiceRemote;

public class TestCreateProduct {
	private static final String jndiName = "ejb:/esprit-ejb/ProductService!edu.app.services.ProductServiceRemote";
	
	public static void main(String[] args) throws NamingException {
		ProductServiceRemote remote = null;
		Context ctx =  new InitialContext();
		remote = (ProductServiceRemote) ctx.lookup(jndiName);
		
		Product product1 = new Product(1, "Nokia 3310", 1);
		Product product2 = new Product(2, "iPhone 5", 1000);
		Product product3 = new Product(3, "Asus N7245", 1150);
		remote.createProduct(product1);
		remote.createProduct(product2);
		remote.createProduct(product3);
		
		
	}

}
