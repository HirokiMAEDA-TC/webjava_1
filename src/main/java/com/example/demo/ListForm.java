package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class ListForm {

	private  int itemId;
	private int num;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}



}