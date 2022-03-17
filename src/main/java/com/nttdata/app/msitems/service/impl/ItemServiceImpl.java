package com.nttdata.app.msitems.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nttdata.app.msitems.models.Item;
import com.nttdata.app.msitems.models.Producto;
import com.nttdata.app.msitems.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private RestTemplate clienteRestProductos;

	@Override
	public List<Item> findAll() {
		List<Producto> productos = Arrays.asList(		
				clienteRestProductos.getForObject("http://localhost:8001/listar", Producto[].class)
		);
		
		/*List<Item> l = new ArrayList<Item>();
		for (Producto p: productos) {
			l.add( new Item(p, 1)   );
		}
		return l;*/
		
		return productos.stream().map( p -> new Item(p, 1) ).collect(Collectors.toList());
		
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		// TODO Auto-generated method stub
		return null;
	}

}
