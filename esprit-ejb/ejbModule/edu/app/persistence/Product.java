package edu.app.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "t_product" )
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3159398667788438475L;
	
	
	
	private int id;
	private String name;
	private float unitCost;
	
	private Category category;
	
	
	
	public Product() {
	}
	
	public Product(int id, String name, float unitCost) {
		this.id = id;
		this.name = name;
		this.unitCost = unitCost;
	}
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column( name = "unit_cost" )
	public float getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(float unitCost) {
		this.unitCost = unitCost;
	}
	
	@ManyToOne
	@JoinColumn( name = "category_fk" )
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", unitCost="
				+ unitCost + "]";
	}

	
	

	
	
	

}
