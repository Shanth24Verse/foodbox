package com.foodbox.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.model.Cart;
import com.foodbox.repository.CartRepository;
import com.foodbox.service.CartService;


@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository cartRepo;
	
	@Override
	public Cart addToCart(Cart cart) {
		return cartRepo.save(cart);
	}

	@Override
	public List<Cart> findAllByCustomerCart(long id) {
		return cartRepo.findAllByCustomerId(id);
	}
	
	@Override
	public void deleteCart(long id) {
		cartRepo.deleteById(id);
		
	}

	@Override
	public void updateCart(Cart cart, long id) {
		Cart updated = cartRepo.findById(id).get();
		updated = cart;
		cartRepo.save(updated);
	}

}
