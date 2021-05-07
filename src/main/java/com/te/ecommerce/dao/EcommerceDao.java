package com.te.ecommerce.dao;


import java.util.List;

import com.te.ecommerce.bean.Admin;
import com.te.ecommerce.bean.Item;



public interface EcommerceDao {

	public Admin authenticate(Integer id, String password);
	
	public boolean addItem(Item item);
	
	public boolean removeItem(Integer id);
	
	public Item searchItem(Integer id);
	
	public List<Item> getAllItems();
	
	public boolean updateItem(Item item);
}
