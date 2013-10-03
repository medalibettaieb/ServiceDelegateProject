package edu.app.tests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.app.persistence.Category;
import edu.app.persistence.Product;
import edu.app.services.CategoryServiceRemote;
import edu.app.services.ProductServiceRemote;

public class _05FetchingProducts {
	
	private static final String pJndiName = "ejb:/esprit-ejb/ProductService!edu.app.services.ProductServiceRemote";
	private static final String cJndiName = "ejb:/esprit-ejb/CategoryService!edu.app.services.CategoryServiceRemote";	
	public static void main(String[] args) throws NamingException {
		ProductServiceRemote pRemote = null;
		CategoryServiceRemote cRemote = null;
		
		Context ctx =  new InitialContext();
		
		pRemote = (ProductServiceRemote) ctx.lookup(pJndiName);
		cRemote = (CategoryServiceRemote) ctx.lookup(cJndiName);
		
		
		
		Category category1 = cRemote.findCategoryById(1);
		
		List<Product> products = category1.getProducts(); 
		
		for(Product p :products){
			System.out.println(p);
		}
		
	}

}
