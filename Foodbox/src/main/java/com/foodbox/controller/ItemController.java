package com.foodbox.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.foodbox.dto.ItemDto;
import com.foodbox.helper.Helper;
import com.foodbox.model.Item;
import com.foodbox.service.ItemService;


@RestController
@RequestMapping("/item")
@CrossOrigin("http://localhost:4200/")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@PostMapping("/addItem")
	public String addItem(@RequestBody ItemDto dto) {
		return itemService.addItem(dto);
	}
	
	@GetMapping("/getAll")
	public List<Item> getAllItems(){
		return itemService.getAllItems();
	}
	
	@GetMapping("/getItem/{id}")
	public Item getItemById(@PathVariable long id) {
		return itemService.getItemById(id);
	}
	
	@PutMapping("/updateitem")
	public String updateItem(@RequestBody ItemDto dto) {
		return itemService.updateItem(dto);
	}
	
	@DeleteMapping("deleteItem/{id}")
	public String deleteItem(@PathVariable long id) {
		return itemService.deleteItemById(id);
	}
	
	@PostMapping("/add-bulk-items")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
		if(Helper.checkExelFormat(file))
		{
			this.itemService.saveMultiple(file);
			return ResponseEntity.ok(Map.of("message","file is uploaded"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload excel file only");
		
	}
	@GetMapping("/get-sorted-item")
	public List<Item> getSortedItem(){
		return itemService.getSortedItem();
	}
}
