package com.main.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.main.model.UserModel;

@Entity
@Table(name="cart_items")
public class CartItemModel  implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	@Column(name="name")
	String name;
	@Column(name="price")
	String price;
	@Column(name="url")
	String url;
	
	@Column(name="qty")
	int  qty;
	
	
	
	public  CartItemModel()
	{
		
	}


	public CartItemModel(String name, String price, String url,  int qty ) {
		super();

		this.name = name;
		this.price = price;
		this.url = url;
		this.qty = qty;
	  
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}



	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}



}
