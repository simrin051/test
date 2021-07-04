package com.main.services;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
//import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.main.model.CartItemModel;
//import com.main.model.CartModel;
import com.main.model.EarringsModel;
import com.main.model.ItemModel;
import com.main.model.UserModel;
import com.main.repository.CartRepository;
import com.main.repository.EarringsRepository;
import com.main.repository.UserRepository;

@Service
public class CartService {
	@Autowired
    CartRepository cartrepository;

	@Autowired
	UserRepository  userrepository;
	
	 List<CartItemModel>  cartitems;
	
	    public  List<CartItemModel> listcartItems(Optional<UserModel> opusermodel) {
	    	
	    	UserModel  user= opusermodel.get();
	    
	        cartitems = user.getCartitemlist();
	        System.out.println("Length in cart items length"+cartitems.size());
	       return cartitems;
	       
	       	
	    }
/**
	    private static boolean itemswithsameusername(CartItemModel item, List<CartItemModel> cartitems, String username) {
	        return cartitems.stream().
	                filter(l -> l..equals(item.getUsermodel().getUsername())).
	                findAny().
	                isPresent();
	    }
**/
	
	    public void addToCart(UserModel usermodel)
	    {
	 
	    	userrepository.save(usermodel);
	  	    System.out.println("Savved");
	  	
	    }
	    public Optional<UserModel> currentUserName(String username) {
	    	return userrepository.findByUsername(username);
	    	
		}
	  
	    public void save(CartItemModel model)
	    {
	    	cartrepository.save(model);
	    	
	    }
	   
	    public void delete(CartItemModel model) {
	    //	Optional<CartItemModel> model=cartrepository.findById(id);
	    	if(model!=null)
	    	{
	        cartrepository.delete(model);
	  
	        if(model==null)
	        {
	        	System.out.println("Item is deleted");
	        }
	    	}
	    }
	  /**
	    public void setOrders(CartModel model)
	    {
	    	cartrepository.save(model);
	    }
	    public UserModel currentUserName(Authentication authentication) {
	    	return userrepo.findByUsername(authentication.getName());
	    	
		}
		**/
		
}
