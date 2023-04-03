package com.foodbox.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.foodbox.dto.ItemDto;
import com.foodbox.exception.ResourceNotFoundException;
import com.foodbox.helper.Helper;
import com.foodbox.model.Item;
import com.foodbox.repository.ItemRepository;
import com.foodbox.service.ItemService;




@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemRepository itemRepo;
	
	@Override
	public String addItem(ItemDto itemdto) {
		Item item = new Item();
		item.setName(itemdto.getName());
		item.setUrl(itemdto.getUrl());
		item.setCatagory(itemdto.getCatagory());
		item.setPrice(itemdto.getPrice());
		item.setQuantity(itemdto.getQuantity());
		itemRepo.save(item);
		return "New Item Record added";
	}

	@Override
	public List<Item> getAllItems() {
		
		return itemRepo.findAll();
	}

	@Override
	public Item getItemById(long id) {
		
		return itemRepo.findById(null).orElseThrow(() -> new ResourceNotFoundException("Item Not found: "+id));
	}

	@Override
	public String updateItem(ItemDto itemdto) {
		Item itemToUpdate = new Item();
		itemToUpdate.setName(itemdto.getName());
		itemToUpdate.setUrl(itemdto.getUrl());
		itemToUpdate.setCatagory(itemdto.getCatagory());
		itemToUpdate.setPrice(itemdto.getPrice());
		itemToUpdate.setQuantity(itemdto.getQuantity());
		itemRepo.save(itemToUpdate);
		return "Record Updated";
	}

	@Override
	public String deleteItemById(long id) {
		itemRepo.deleteById(id);
		return "Record Deleted";
	}

	@Override
	public void saveMultiple(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
			List<Item> item= Helper.convertExcelToListOfProducts(file.getInputStream());
			this.itemRepo.saveAll(item);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public List<Item> getSortedItem() {
		// TODO Auto-generated method stub
		return itemRepo.findAll(Sort.by("catagory"));
	}

	
	
}
