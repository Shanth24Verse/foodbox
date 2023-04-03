package com.foodbox.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.foodbox.dto.ItemDto;
import com.foodbox.model.Item;

public interface ItemService {

	public String addItem(ItemDto itemdto);
	List<Item> getAllItems();
	public Item getItemById(long id);
	public String updateItem(ItemDto itemdto);
	public String deleteItemById(long id);
	public void saveMultiple(MultipartFile file);
	
	public List<Item> getSortedItem();
}
