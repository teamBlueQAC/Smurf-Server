package com.qa.smurf.controller;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qa.smurf.entities.User;
import com.qa.smurf.service.OrderService;
import com.qa.smurf.service.WishlistService;

@Named(value = "wishlist")
@RequestScoped
public class WishListController {
	
	@Inject WishlistService wishlistService;
	@Inject
	CurrentUser currentUser;
	private User user = wishlistService.getCurrentUser(currentUser.getUserId());
	
	public String addToWishlist(long productId){
		wishlistService.addToWishlist(productId, currentUser.getUserId());
		return "wishlist";
	}
	
	public String removeFromWishlist(long productId){
		wishlistService.removeFromWishlist(productId, currentUser.getUserId());
		return "wishlist";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
