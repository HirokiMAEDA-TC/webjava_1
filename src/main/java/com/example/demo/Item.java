package com.example.demo;

public class Item {
	private int itemid;
	private String name;
	private int price;

	public Item(int itemid, String name, int price) {
		this.itemid = itemid;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return itemid;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
}
