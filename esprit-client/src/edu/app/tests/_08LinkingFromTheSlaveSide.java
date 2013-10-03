package edu.app.tests;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;

import edu.app.persistence.Category;
import edu.app.persistence.Product;
import edu.app.services.CategoryServiceRemote;
import edu.app.services.ProductServiceRemote;

public class _08LinkingFromTheSlaveSide {
	
	private static final String pJndiName = "ejb:/esprit-ejb/ProductService!edu.app.services.ProductServiceRemote";
	private static final String cJndiName = "ejb:/esprit-ejb/CategoryService!edu.app.services.CategoryServiceRemote";	
	public static void main(String[] args) throws NamingException {
		ProductServiceRemote pRemote = null;
		CategoryServiceRemote cRemote = null;
		
		Context ctx =  new InitialContext();
		
		pRemote = (ProductServiceRemote) ctx.lookup(pJndiName);
		cRemote = (CategoryServiceRemote) ctx.lookup(cJndiName);
		
		Category category2 = cRemote.findCategoryById(2);
		System.out.println("Is c2 managed? : " + cRemote.isManaged(category2));
		Product product3 = pRemote.findProductById(3);
		Product product4 = pRemote.findProductById(4);
		System.out.println("Is p3 managed? : " + pRemote.isManaged(product3));
		System.out.println("Is p4 managed? : " + pRemote.isManaged(product4));
//		List<Product> products = cRemote.findProductsByCategory(category2);
//		products.add(product3);
//		products.add(product4);
//		category2.setProducts(products);
//		product3.setCategory(category2);
		cRemote.link(category2, product4);
		
	}

}
