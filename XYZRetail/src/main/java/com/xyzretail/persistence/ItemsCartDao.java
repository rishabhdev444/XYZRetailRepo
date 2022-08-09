package com.xyzretail.persistence;

import java.util.List;

import com.xyzretail.bean.ItemDetails;
import com.xyzretail.bean.ItemsCart;

public interface ItemsCartDao {
	public int addItemToCart(ItemDetails item, String customer, int reqQuantity, double tax, double totalCost );
	public int deleteItemFromCart(String customer);
	List<ItemsCart> getAllItemsInCart(String customer);
	public int unselectFromCart(String itemId, String customer);
	public boolean searchItemById(String itemId,String customer);
	public int modifyQuantityOfCartItems(String customer,String itemId,int modifiedQuantity,double tax,double cost);
	public ItemsCart getItemById(String itemId,String customer);
}
