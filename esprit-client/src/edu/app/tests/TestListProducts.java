package edu.app.tests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.app.persistence.Product;
import edu.app.services.ProductServiceRemote;

public class TestListProducts {
	private static final String jndiName = "ejb:/esprit-ejb/ProductService!edu.app.services.ProductServiceRemote";
	
	public static void main(String[] args) throws NamingException {
		ProductServiceRemote remote = null;
		Context ctx =  new InitialContext();
		remote = (ProductServiceRemote) ctx.lookup(jndiName);
		
		List<Product> products = remote.findAllProducts();
		for(Product product: products){
			System.out.println(product);
		}
		
		
	}
}
