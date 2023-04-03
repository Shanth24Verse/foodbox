package com.foodbox.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

	private long id;
	private String name;
	private String url;
	private String catagory;
	private double price;
	private int quantity;
}
