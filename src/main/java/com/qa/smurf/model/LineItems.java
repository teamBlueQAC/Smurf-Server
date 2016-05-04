package com.qa.smurf.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "LineItems")
public class LineItems {

	@ManyToOne
	@JoinTable(name = "ORDER_ID")
	private Order order;

	@ManyToOne
	@JoinTable(name = "PRODUCT_ID")
	private Product product;

	@Column(name = "QUANTITY", length = 10, nullable = false)
	@NotNull
	private int quantity;

	@Column(name = "SUBTOTAL", length = 12, nullable = false)
	@NotNull
	private double subtotal;

	@Column(name = "RETURNEDQTY", length = 10)
	private int returnedQty;

	public LineItems(Order order, Product product, int quantity, double subtotal, int returnedQty) {
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.subtotal = subtotal;
		this.returnedQty = returnedQty;
	}

	public Order getOrder() {
		return order;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public int getReturnedQty() {
		return returnedQty;
	}

	public void setOrder(Order o) {
		this.order = o;
	}

	public void setProduct(Product p) {
		this.product = p;
	}

	public void setQuantity(int q) {
		this.quantity = q;
	}

	public void setSubtotal(double s) {
		this.subtotal = s;
	}

	public void setReturnedQty(int rQty) {
		this.returnedQty = rQty;
	}
}
