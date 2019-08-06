package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListController {

	@Autowired
	private ListService listService;
	private OrderList orderList;
	private ListForm listForm;

	@RequestMapping(value="/View", method= RequestMethod.GET)
	public ModelAndView show(ModelAndView mav) {

		mav.setViewName("ListView");
		mav.addObject("itemList", listService.getItemList());

		return mav;

	}

	@RequestMapping(value="/Cart", method=RequestMethod.POST)
	public ModelAndView order(@RequestParam("num") int[] num,
						ListForm form,
						ModelAndView mav) {

		listForm.setNum(num);

		orderList.setOrder(listService.getItemList(), listForm.getNum());
		mav.setViewName("Cart");
		mav.addObject("order", orderList.getOrder());
		//mav.addObject("num", num);

		return mav;
	}
}
