package com.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class ItemModel {
	
	@Column(name="name")
	String name;
	@Column(name="price")
	String price;
	@Column(name="url")
	String url;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="item_Id")
	int  itemid;
	@Column(name="qty")
	int  qty;
	

	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
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
	public int getId() {
		return itemid;
	}
	public void setId(int id) {
		this.itemid = id;
	}
	
}
