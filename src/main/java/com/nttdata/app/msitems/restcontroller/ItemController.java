package com.nttdata.app.msitems.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.app.msitems.models.Item;
import com.nttdata.app.msitems.service.ItemService;

@RestController
public class ItemController {
	@Autowired
	private ItemService service;
	
	@GetMapping("/listar") 
	public List<Item> listar (){
		return service.findAll();
	}
	
	@GetMapping("/listar/{id}/{cantidad}") 
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return service.findById(id, cantidad);
	}
	
	
	
}
