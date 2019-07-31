package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ListService {

	public static List<Item> findItems() {
		List<Item> item = new ArrayList<>();

		item.add(new Item(
				1, "リンゴ", 100));
		item.add(new Item(
				2, "みかん", 80));
		item.add(new Item(
				3, "ブドウ", 500));

		return item;
	}
}
