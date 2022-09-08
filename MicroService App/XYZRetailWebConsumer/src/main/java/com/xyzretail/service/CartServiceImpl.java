package com.xyzretail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xyzretail.bean.ItemDetail;
import com.xyzretail.bean.ItemsCart;
import com.xyzretail.bean.ItemsCartList;
//import com.xyzretail.persistence.ItemsCartDao;
@Service("cartService")
public class CartServiceImpl implements CartService {
//	private ItemsCartDao itemsCartDao;
	private ItemsService itemsService;
	
	@Autowired
	private RestTemplate restTemplate;
//	
//	@Autowired
//	public void setItemsCartDao(ItemsCartDao itemsCartDao) {
//		this.itemsCartDao = itemsCartDao;
//	}
	@Autowired
	public void setItemsService(ItemsService itemsService) {
		this.itemsService = itemsService;
	}
	
	@Override
	public ItemsCartList getAllItemsInCart(String customer) {
		ItemsCartList cartList= restTemplate.getForObject("http://itemCart-service/cart/all/"+customer, ItemsCartList.class);
		System.out.println(cartList);
		if(cartList!=null)
			return cartList;
		return null;
	}

	@Override
	public boolean addItemToCart(String customer,String itemId, int reqQuantity) {
//		System.out.println("customer name ="+customer);
		if (reqQuantity <1 )
		{
			System.out.println("enter positive value !!");
			return false ;
		}
		ItemDetail item=itemsService.searchItemsById(itemId);
		if(itemsService.searchItemsById(itemId, reqQuantity)) {
		
//		double tax=getTax(item.getItemCategory());
		
//		double cost=(item.getItemPrice()*(double)(tax*0.01))+item.getItemPrice();
//
//		double totalCost=cost*reqQuantity;
//		
		
//		if(!itemsCartDao.searchItemById(itemId, customer)){
//			return itemsCartDao.addItemToCart(item,customer, reqQuantity, tax, totalCost);
//		}
//		else {
//			ItemsCart itemCart=itemsCartDao.getItemById(itemId, customer);
//			reqQuantity+=itemCart.getPurchaseQuantity();
//			totalCost+=itemCart.getTotalCost();
//			itemsCartDao.unselectFromCart(itemId, customer);
//			return itemsCartDao.addItemToCart(item,customer, reqQuantity, tax, totalCost);
//		}
//	}
//	else {
//
//		System.out.println(reqQuantity+" "+ item.getItemName() +" is Not available in our Stock :( ");
//		return false;
	}
		return false ;
	}


	
	@Override
	public void deleteItemFromCart(String customer) {
//		itemsCartDao.deleteItemFromCart(customer);
	}

	@Override
	public int unselectFromCart(String itemId, String customer) {
//		return itemsCartDao.unselectFromCart(itemId, customer);
		return 0;
	}

	@Override
	public boolean modifyItemsInCart(String customer, String itemId, int modifiedQuantity) {
//		if(modifiedQuantity <1) {
//			System.out.println("enter positive value greater than 0");
//			return false;
//		}
//		if(itemsService.searchItemsById(itemId, modifiedQuantity) && itemsCartDao.searchItemById(itemId, customer)) {
//			ItemDetails item=itemsService.searchItemsById(itemId);	
//			double tax=getTax(item.getItemCategory());
//			
//			double cost=(item.getItemPrice()*(double)(tax*0.01))+item.getItemPrice();
//
//			double totalCost=cost*modifiedQuantity;
//	
//			itemsCartDao.modifyQuantityOfCartItems(customer, itemId, modifiedQuantity, tax ,totalCost);
//			
//			return true;
//		}
		return false;
	}
		
}
