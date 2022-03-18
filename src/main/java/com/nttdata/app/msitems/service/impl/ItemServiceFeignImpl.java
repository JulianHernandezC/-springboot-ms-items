package com.nttdata.app.msitems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.nttdata.app.msitems.clients.ProductoClienteRest;
import com.nttdata.app.msitems.models.Item;
import com.nttdata.app.msitems.service.ItemService;

public class ItemServiceFeignImpl implements ItemService {

	@Autowired
	private ProductoClienteRest clienteFeign;

	@Override
	public List<Item> findAll() {
		return clienteFeign.listar().stream().map( p -> new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(clienteFeign.detalle(id), cantidad);
	}

}
