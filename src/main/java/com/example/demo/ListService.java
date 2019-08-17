package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class ListService {

	// Item(itemid, 商品名、値段)
	public Item item1 = new Item(1, "リンゴ", 120);
	public Item item2 = new Item(2, "みかん", 80);
	public Item item3 = new Item(3, "ブドウ", 400);


	public ArrayList<Item> getItemList() {
		ArrayList<Item> itemList = new ArrayList<Item>();
	//item1~item3までitemリストに格納して受け渡しを行いたい
		itemList.add(item1);
		itemList.add(item2);
		itemList.add(item3);
		return itemList;
	}

}
