package com.foodbox.service;

import java.util.List;
import com.foodbox.model.Cart;

public interface CartService {

	public Cart addToCart(Cart cart);
	List<Cart> findAllByCustomerCart(long id);
	public void deleteCart(long id);
	public void updateCart(Cart cart, long id);
}
