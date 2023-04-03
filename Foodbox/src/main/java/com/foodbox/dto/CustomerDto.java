package com.foodbox.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

	private long id;
	private String name;
	private String email;
	private String password;
	private String location;
	private long phone;
}
