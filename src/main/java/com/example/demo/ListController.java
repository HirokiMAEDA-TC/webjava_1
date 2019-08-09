package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListController {

	@Autowired
	private ListService listService;
	private ListForm listForm;

	@RequestMapping(value="/View", method= RequestMethod.GET)
	public ModelAndView show(ModelAndView mav) {

		mav.addObject("itemList", listService.getItemList());

		mav.setViewName("ListView");
		return mav;

	}





}
