package com.nttdata.app.msitems.service;

import java.util.List;

import com.nttdata.app.msitems.models.Item;

public interface ItemService {
	public List<Item> findAll();
	public Item findById (Long id, Integer cantidad);

}
