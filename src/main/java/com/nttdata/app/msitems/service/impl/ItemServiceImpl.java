package com.nttdata.app.msitems.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nttdata.app.msitems.models.Item;
import com.nttdata.app.msitems.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private RestTemplate clienteRestProductos;

	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		// TODO Auto-generated method stub
		return null;
	}

}
