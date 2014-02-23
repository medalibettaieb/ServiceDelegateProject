package edu.app.tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.app.persistence.Category;
import edu.app.persistence.Product;
import edu.app.services.CategoryServiceRemote;
import edu.app.services.ProductServiceRemote;

public class _03BetterLinkProductsToTheirCategories {

	private static final String pJndiName = "ejb:/esprit-ejb/ProductService!edu.app.services.ProductServiceRemote";
	private static final String cJndiName = "ejb:/esprit-ejb/CategoryService!edu.app.services.CategoryServiceRemote";

	public static void main(String[] args) throws NamingException {
		ProductServiceRemote pRemote = null;
		CategoryServiceRemote cRemote = null;

		Context ctx = new InitialContext();

		pRemote = (ProductServiceRemote) ctx.lookup(pJndiName);
		cRemote = (CategoryServiceRemote) ctx.lookup(cJndiName);

		Product product1 = new Product(1, "Nokia 3310", 1);
		Product product2 = new Product(2, "iPhone 5", 1000);
		Product product3 = new Product(3, "Asus N7245", 1150);
		Product product4 = new Product(4, "Mac Book Air", 2500);

		Category category1 = new Category(1, "Phones");
		Category category2 = new Category(2, "Laptops");

		category1.addProduct(product1);
		category1.addProduct(product2);

		// Object Level -> RDBMS
		pRemote.updateProduct(product1);
		pRemote.updateProduct(product2);

	}
}
