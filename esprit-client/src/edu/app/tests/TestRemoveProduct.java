package edu.app.tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.app.persistence.Product;
import edu.app.services.ProductServiceRemote;

public class TestRemoveProduct {
	private static final String jndiName = "ejb:/esprit-ejb/ProductService!edu.app.services.ProductServiceRemote";
	
	public static void main(String[] args) throws NamingException {
		ProductServiceRemote remote = null;
		Context ctx =  new InitialContext();
		remote = (ProductServiceRemote) ctx.lookup(jndiName);
		Product product = new Product();
		product.setId(9);
		remote.deleteProduct(product);
		
	}
}
