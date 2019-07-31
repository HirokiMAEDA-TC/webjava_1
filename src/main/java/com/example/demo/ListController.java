package com.example.demo;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListController {

	@GetMapping("/List")
	public String index(@ModelAttribute("ListForm") ListForm listForm) {
		return "ListView";		//ListView.htmlを返す。
	}

	//編集中→Listで値の受け渡しができるようにする
	@RequestMapping(value="ListService", method=RequestMethod.GET)
	public String show(Model model) {
		List<Item> item = ListService.findItems();

		model.addAttribute("itemid", Arrays.asList(itemid.values()));


		return "ListView";
	}




	@RequestMapping(value="/Cart", method=RequestMethod.POST)
	public String order(
			@RequestParam(name="itemid") int itemid,
			@RequestParam(name="num") int num,
			Model model
			) {

		model.addAttribute("itemid", itemid);
		model.addAttribute("num", num);
		return "Cart";
	}
}
