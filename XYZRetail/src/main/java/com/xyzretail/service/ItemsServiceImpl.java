package com.xyzretail.service;

import java.util.List;

import com.xyzretail.bean.Item;
import com.xyzretail.client.Customer;

public class ItemsServiceImpl implements ItemsService {

	@Override
	public boolean addItem(Item item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Item> getItemDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double generateBill() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTax(Item item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean validateCustomer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double setTax(Item item) {
		double tax=0;
		if(item.getItemName()=="books")
		{
	 tax=	item.getItemPrice()*0.10;
		}
		else if(item.getItemName()=="cosmetics")
		{
			 tax=item.getItemPrice()*0.30;
		}
		else if(item.getItemName()=="CD")
		{
			tax=item.getItemPrice()*0.20;
		}
		return tax;
	}

	@Override
	public double calculateBooksCost(Item item) {

		
		return 0;
	}

	@Override
	public double calculateCDCost(Item item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculateCosmeticsCost(Item item) {

		
		
		
		return 0;
	}

	@Override
	public double calculateTaxAmount(Item category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item searchItemsById(String id, int reqQuantity) {
		// TODO Auto-generated method stub
		return null;
	}

}


