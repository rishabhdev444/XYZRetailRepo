package com.xyzretail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xyzretail.bean.Customer;
import com.xyzretail.bean.ItemBill;
import com.xyzretail.bean.ItemDetails;
import com.xyzretail.service.BillService;
import com.xyzretail.service.CartService;
import com.xyzretail.service.ItemsService;
import com.xyzretail.service.TransactionService;

@Controller
public class XyzRetailController {
	
	@Autowired
	private ItemsService itemsService;



	@Autowired
	private CartService cartService;
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private BillService bill;
	
	
	
	@RequestMapping("/showAllItems")
	public ModelAndView showAllItemsController() {
		List<ItemDetails> items=itemsService.getAllItems();
		
		return new ModelAndView("showAllItem", "items", items);
	}

	
	@RequestMapping("/generateBill")
	public ModelAndView generateBillController(@ModelAttribute Customer customer,@ModelAttribute ItemBill bill) {
		ModelAndView modelAndView=new ModelAndView();
		//ItemBill itemsBill=
		
		return modelAndView;
		
	}
	
		
}
