package com.main.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "user")
public class UserModel  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userId")
	private Long userId;
	@Column(name="username")
	private String username;
	@Column(name="email")
	private String email;
	@Column(name="lpassword")
	private String password;
	@Column(name="cpassword")
	private String confirmPassword;
	@Column(name="telephone")
	private String telephone;

	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="username",referencedColumnName="username")
	List<CartItemModel> cartitemlist = new ArrayList<CartItemModel>();
	
public List<CartItemModel> getCartitemlist() {
		return cartitemlist;
	}
	public void setCartitemlist(List<CartItemModel> cartitemlist) {
		this.cartitemlist = cartitemlist;
	} 
public Long getId() {
	return userId;
}
public void setId(Long id) {
	this.userId = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getConfirmPassword() {
	return confirmPassword;
}
public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}

public UserModel( String username, String email, String password, String confirmPassword, String telephone,	List<CartItemModel> cartitemlist) {
	super();
	
	this.username = username;
	this.email = email;
	this.password = password;
	this.confirmPassword = confirmPassword;
	this.telephone = telephone;
	this.cartitemlist=cartitemlist;
}
public UserModel()
{
	
}
}

