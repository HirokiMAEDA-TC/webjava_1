package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OrderList {

	@Autowired
	private ListService listService;

	//private ArrayList<Item> itemList;
	private int itemId;
	private ArrayList<Map<Integer, Integer>> itemNum = new ArrayList<Map<Integer, Integer>>();

	public ArrayList<Map<Integer, Integer>> getOrder() {
		return itemNum;
	}

	public void setOrder(ArrayList<Item> itemList,int[] num) {
		itemList = listService.getItemList();


		for(int i = 0; i<itemList.size(); i++) {
			this.itemId = itemList.get(i).itemId;

			Map<Integer, Integer> order = new HashMap<>();
			order.put(itemId, num[i]);

			itemNum.add(order);
		}
	}


}
