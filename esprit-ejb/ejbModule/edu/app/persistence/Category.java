package edu.app.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="t_category")
public class Category implements Serializable {

	
	private int id;
	private String name;
	private static final long serialVersionUID = 1L;
	
	private List<Product> products;

	public Category() {
	}   
	
	
	
	public Category(int id, String name) {
		this.id = id;
		this.name = name;
	}



	@Id    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany( mappedBy = "category")
	public List<Product> getProducts() {
		if (products == null) {
			products = new ArrayList<Product>();
		}
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

	//gestion des deux bout de l'association
	public void addProduct(Product product) {
		product.setCategory(this);
		this.getProducts().add(product);
		
	}
	
	
   
}
