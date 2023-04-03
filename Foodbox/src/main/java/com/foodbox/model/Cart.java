package com.foodbox.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart_foodbox")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cart_id")
	private long id;
	private int unit;
	private double totalprice;
	
	@OneToOne(targetEntity = Customer.class,fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "customer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;
	
	public Cart(Customer customer, Item item) {
		this.customer = customer;
		this.item = item;
	}
}
