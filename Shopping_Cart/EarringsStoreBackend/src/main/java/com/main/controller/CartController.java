package com.main.controller;

import java.security.Principal;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.config.WebSecurityConfig;
import com.main.model.BraceletsModel;
import com.main.model.CartItemModel;
import com.main.model.EarringsModel;
import com.main.model.ItemModel;
import com.main.model.UserModel;
import com.main.repository.CartRepository;
import com.main.repository.UserRepository;
import com.main.services.BraceletsSerice;
import com.main.services.CartService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CartController {

	@Autowired
	CartService cartService;
	
	@Autowired
	UserRepository  userRepo;
	
	@Autowired
	CartRepository cartRepo;
	

	//public @ResponseBody List<CartItemModel> findItemsCart(Model model, @AuthenticationPrincipal Authentication authentication) {

	@RequestMapping("/list/cart")	
	public @ResponseBody  List<CartItemModel> findItemsCart(Model model) {
		String username=SecurityContextHolder.getContext().getAuthentication().getName() ;

		Optional<UserModel> usermodel=cartService.currentUserName(WebSecurityConfig.currusername);
	List<CartItemModel> cartitems=cartService.listcartItems(usermodel);
	   for(int i=0;i<cartitems.size();i++)
	   {
		   CartItemModel model1=(CartItemModel) cartitems.get(i);
	
	   }

	   model.addAttribute("cartdata", cartitems);

	 return cartitems; 
	 
	}
	@RequestMapping("/modifiedlist/cart")	
	public @ResponseBody  List<CartItemModel> findModifiedItemsCart(Model model) {
		String username=SecurityContextHolder.getContext().getAuthentication().getName() ;

		Optional<UserModel> usermodel=cartService.currentUserName(WebSecurityConfig.currusername);
	List<CartItemModel> cartitems=cartService.listcartItems(usermodel);
	   for(int i=0;i<cartitems.size();i++)
	   {
		   CartItemModel model1=(CartItemModel) cartitems.get(i);
	
	   }

	   model.addAttribute("cartdata", cartitems);

	 return cartitems; 
	 
	}	
	
	@RequestMapping("/add/cart")
	public void addItemCart(@RequestBody CartItemModel cartdata) {
		try
		{
			System.out.println("Cart data "+cartdata.getName()+" "+cartdata.getPrice()+" "+cartdata.getUrl()+" "+cartdata.getQty());
			CartItemModel cartitem = new CartItemModel(cartdata.getName(),cartdata.getPrice(),cartdata.getUrl(),cartdata.getQty());
			
			/**
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		CartItemModel cartitem = new ObjectMapper().readValue(cartdata, CartItemModel.class); **/
			
		Optional<UserModel> optionaluser=userRepo.findByUsername(WebSecurityConfig.currusername);
		System.out.println("Web security config username "+WebSecurityConfig.currusername);
		UserModel user =optionaluser.get();
		user.getCartitemlist().add(cartitem);
		cartService.addToCart(user);
		System.out.println("Inside save method");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * 	@RequestMapping("/add/cart")
	public void addItemCart(@RequestBody CartItemModel model1, @AuthenticationPrincipal Authentication authentication) {
		
		UserModel usermodel=cartService.currentUserName(authentication);
		cartService.addToCart(usermodel, model1.getId());
		System.out.println("Inside save method");
	
	}
	@RequestMapping("/order")
	public void addtoOrders(@RequestBody CartModel model1) {
	
		cartService.setOrders(model1);
		System.out.println("Inside save method");
	
	} **/
	
	@RequestMapping("/item/cart")
	public void updateItem(@RequestBody CartItemModel cartdata)
	{
		System.out.println(cartdata.getName()+" "+cartdata.getPrice()+" "+cartdata.getQty()+" "+cartdata.getUrl());
		Optional<UserModel> optionaluser=userRepo.findByUsername(WebSecurityConfig.currusername);
		System.out.println("Web security config username "+WebSecurityConfig.currusername);
		UserModel user =optionaluser.get();
		List<CartItemModel> cartitemmodels=user.getCartitemlist();
		Iterator itr= cartitemmodels.iterator();
		while(itr.hasNext())
		{
			CartItemModel model =(CartItemModel)itr.next();
			System.out.println(model.getName()+","+cartdata.getName());
			if(model.getName().contentEquals(cartdata.getName()))
			{
				model.setQty(cartdata.getQty());
				cartRepo.save(model);
				System.out.println("model set Qty updated with "+cartdata.getQty());
			}
		}
	}
	
	@RequestMapping("/delete/{name}")  
	public void deleteItem(@PathVariable String name)  
	{  
	System.out.println("Delete user" +name);	
	Optional<UserModel> optionaluser=userRepo.findByUsername(WebSecurityConfig.currusername);
	UserModel user=optionaluser.get();
	List<CartItemModel> cartitems=user.getCartitemlist();
	for(int i=0;i<cartitems.size();i++)
	{
		if(cartitems.get(i).getName().equals(name))
		{
			CartItemModel cartitem=cartitems.get(i);
			cartitems.remove(i);
			cartService.delete(cartitem);
			System.out.println("Cart item is removed");
		}
	}
//	user.getCartitemlist().remove(0);
//	cartService.deleteById(id);  
	
	}  
}
