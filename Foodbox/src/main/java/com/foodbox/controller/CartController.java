package com.foodbox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.model.Cart;
import com.foodbox.model.Customer;
import com.foodbox.model.Item;
import com.foodbox.service.CartService;
import com.foodbox.service.CustomerService;
import com.foodbox.service.ItemService;


@RestController
@RequestMapping("/cart")
@CrossOrigin("http://localhost:4200/")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/add/{itemId}/{customerId}")
	public ResponseEntity<Cart> addCart(@PathVariable long itemId,@PathVariable long customerId) {

		Item item = itemService.getItemById(itemId);
		Customer customer = customerService.getCustomerById(customerId);
		Cart cart = new Cart(customer, item);
		cart.setUnit(1);
		cart.setTotalprice(cart.getUnit()*item.getPrice());
		Cart addCart = cartService.addToCart(cart);
		return new ResponseEntity<Cart>(addCart, HttpStatus.CREATED);

	}

	@DeleteMapping("/delete/{cartId}")
	public ResponseEntity<?> deletCart(@PathVariable long cartId) {

		cartService.deleteCart(cartId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/update-cart/{cid}")
	public void updateCart(@RequestBody Cart cart, @PathVariable long cid) {
		cartService.updateCart(cart, cid);
		
	}
	
}
