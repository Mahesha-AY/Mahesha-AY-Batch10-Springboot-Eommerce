package com.te.ecommerce.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.ecommerce.bean.Item;
import com.te.ecommerce.bean.ItemResponse;
import com.te.ecommerce.service.EcommerceService;



@RestController
public class EcommerceRestController {

	@Autowired
	private EcommerceService service;
	
	@GetMapping(path = "/getItem/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ItemResponse getItem(@PathVariable(name = "id") Integer id) {
		ItemResponse response = new ItemResponse();
		Item item = service.searchItem(id);
		if(item != null) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setItem(item);
		} else {
			response.setStatusCode(404);
			response.setMessage("failed");
		}
		return response;
	}
	
	@GetMapping(path = "/getAll", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ItemResponse getAllItems() {
		ItemResponse response = new ItemResponse();
		List<Item> items = service.getAllItems();
		if(items != null) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setItemList(items);
		} else {
			response.setStatusCode(404);
			response.setMessage("failed");
		}
		return response;
	}
	
	@PostMapping(path = "/addItem", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ItemResponse addItem(@RequestBody Item item) {
		ItemResponse response = new ItemResponse();
		if(service.addItem(item)) {
			response.setStatusCode(200);
			response.setMessage("success");
		} else {
			response.setStatusCode(404);
			response.setMessage("failed");
		}
		return response;
	}
	
	@PutMapping(path = "/updateItem", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ItemResponse updateItem(@RequestBody Item item) {
		ItemResponse response = new ItemResponse();
		if(service.updateItem(item)) {
			response.setStatusCode(200);
			response.setMessage("failed");
		} else {
			response.setStatusCode(404);
			response.setMessage("failed");
		}
		return response;
	}
	
	@DeleteMapping(path = "/deleteItem/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ItemResponse deleteItem(@PathVariable(name ="id") Integer id) {
		ItemResponse response = new ItemResponse();
		if(service.removeItem(id)) {
			response.setStatusCode(200);
			response.setMessage("success");
		} else {
			System.out.println("Inside else bock in handler");
		}
		return response;
	}

}
