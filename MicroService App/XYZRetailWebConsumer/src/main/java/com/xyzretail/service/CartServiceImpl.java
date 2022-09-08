package com.xyzretail.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public List<ItemsCart> getAllItemsInCart(String customer) {
		ItemsCartList cartList= restTemplate.getForObject("http://itemsCart-service/cart/all/"+customer, ItemsCartList.class);
		System.out.println(cartList);
		if(cartList!=null)
			return cartList.getItemsCartList();
		return null;
	}

	@Override
	public boolean addItemToCart(String customer,String itemId, int reqQuantity) {
		
		ItemsCart itemCart=restTemplate.postForObject("http://itemsCart-service/cart/all/"+itemId+reqQuantity+customer, itemId, ItemsCart.class);
		
		if(itemCart!=null) {
			return true;
		}
		
		return false;
		
	}


	
	@Override
	public void deleteItemFromCart(String customer) {
		restTemplate.delete("http://itemsCart-service/cart/delete/all/"+customer, ItemsCartList.class);
		
	}

	@Override
	public int unselectFromCart(String itemId, String customer) {
		restTemplate.delete("http://itemsCart-service/cart/delete/"+itemId+customer, ItemsCart.class);
		return 1;
	}

	@Override
	public boolean modifyItemsInCart(String customer, String itemId, int modifiedQuantity) {
		if(getItemByIDandUser(itemId,customer)) {
			restTemplate.put("http://itemsCart-service/cart/update/"+ itemId+modifiedQuantity+customer,ItemsCart.class);
			return true;	
		}
		return false;
	}

	@Override
	public boolean getItemByIDandUser(String itemId, String customer) {
		ItemsCart item=restTemplate.getForObject("http://itemsCart-service/cart/all/"+itemId+customer, ItemsCart.class);
		if(item!=null) {
			return true;
		}
		return false;
	
	}
		
}
