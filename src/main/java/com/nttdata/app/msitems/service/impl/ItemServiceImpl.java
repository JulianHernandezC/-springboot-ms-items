package com.nttdata.app.msitems.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id",  id.toString());
		
		Producto producto = clienteRestProductos.getForObject("http://localhost:8001/listar/{id}", 
																Producto.class, pathVariables);
		return new Item(producto, cantidad);
	}

}
