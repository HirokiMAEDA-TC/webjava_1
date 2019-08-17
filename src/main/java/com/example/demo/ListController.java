package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListController {

	@Autowired
	HttpSession session; //セッション管理
	private ListService listService;


	@RequestMapping(value="/View", method=RequestMethod.GET)
	public ModelAndView show(ModelAndView mav) {

		Map<Integer, Item> itemListMap = getItemListMap();
		mav.addObject("itemList", itemListMap);

		Cart cart = getCart();
		mav.addObject("order", cart.getOrderList());

		mav.setViewName("ListView");
		return mav;

	}

	//アイテムIDと商品情報をマップで紐づける
	private Map<Integer, Item> getItemListMap() {
		ArrayList<Item> itemList = listService.getItemList();

		Map<Integer, Item> itemListMap = new HashMap<Integer, Item>();
		for (Item item: itemList) {
			itemListMap.put(item.getItemId(), item);
		}

		return itemListMap;
	}

	//カートを作成
	private Cart getCart() {
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);

		}

		return cart;
	}


	@RequestMapping(value="/View", method=RequestMethod.POST)
	public ModelAndView order(ModelAndView mav, @Valid ListForm listForm,
			BindingResult bindingResult, HttpServletRequest request) {

		Cart cart = getCart();

		/*
		if (bindingResult.getAllErrors().size() > 0) {
			mav.addObject("listForm", listForm);

			Map<Integer, Item> itemListMap = getItemListMap();
			mav.addObject("itemList", itemListMap);

			mav.setViewName("ListView");

			return mav;
		}
		*/


		Order order = new Order();
		order.setItemId(listForm.getItemId());
		order.setNum(listForm.getNum());
		cart.add(order);

		session.setAttribute("cart", cart);
		return new ModelAndView("redirect:/View");

	}

}


	/* 20190816 自分のやつ
	@Autowired
	private ListService listService;
	private ListForm listForm;

	@RequestMapping(value="/View", method=RequestMethod.GET)
	public ModelAndView show(ModelAndView mav) {

		mav.addObject("itemList", listService.getItemList();

		mav.setViewName("ListView");
		return mav;

	@RequestMapping(value="/View", method=RequestMethod.POST)
	public ModelAndView order(ModelAndView mav, @Valid ListForm listForm) {


			Map<Item, Integer> itemListMap = getItemListMap(listForm.getNum());
			mav.addObject("order", itemListMap);

			mav.setViewName("ListView");
			return mav;
		}


	Map<Item, Integer> getItemListMap(int num) {
		ArrayList<Item> itemList = listService.getItemList();

		Map<Item, Integer> itemListMap = new HashMap<Item, Integer>();

		for(Item item : itemList) {
			itemListMap.put(item, num);
		}

		return itemListMap;
	}
	*/





