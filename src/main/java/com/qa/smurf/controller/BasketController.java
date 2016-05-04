package com.qa.smurf.controller;



import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qa.smurf.entities.LineItems;
import com.qa.smurf.entities.Order;
import com.qa.smurf.entities.User;
import com.qa.smurf.service.OrderService;

@Named(value = "basket")
@RequestScoped
public class BasketController {

	@Inject OrderService orderService;
	@Inject
	CurrentUser currentUser;
	private User user = orderService.getCurrentUser(currentUser.getUserId());
	private Order order = orderService.getUsersPendingOrder(currentUser.getUserId());
	private float totalPrice = orderService.calcOrderTotalPending(currentUser.getUserId());
	
	public String removeProductFromBasket(long productId){
		orderService.removeFromBasket(productId, currentUser.getUserId());
		return "basket";
	}
	
	public String updateQuantity(){
		orderService.updateQuantity(order, currentUser.getUserId());
		
		return "basket";
	}
	
	public String clearBasket(){
		orderService.clearBasket(currentUser.getUserId());
		return "basket";
	}
	
	//gets called when adding a product
	//calls the orderService to add a product to the basket.
	public void addToBasket(long productId){
		orderService.addToBasket(productId, currentUser.getUserId());
		
	}
	public void getLineItems(Order order){
		orderService.getLineItems(order, currentUser.getUserId());
	}
	
	public String placeOrder(){
		
		orderService.placeOrder(order, currentUser.getUserId());
		return "order";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public float getTotalPrice() {
		return totalPrice;
	}

}
