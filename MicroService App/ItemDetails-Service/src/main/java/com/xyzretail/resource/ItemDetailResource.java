package com.xyzretail.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.xyzretail.bean.ItemDetail;
import com.xyzretail.bean.ItemDetailsList;
import com.xyzretail.model.persistence.ItemDetailDao;
import com.xyzretail.model.service.ItemDetailService;

@RestController
public class ItemDetailResource {
	@Autowired
	private ItemDetailService itemDetailService;
//	@Autowired
//	private ItemDetailDao itemDetailDao;
	
	
//	@GetMapping(path="/Item_Details", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Item_Details getAllItem_Detailesource() {
//		return new Item_Details(item_DetailService.getAllItemDetails());
////		if(item_Details != null)
////			return new ResponseEntity<Item_Details> (item_Details, HttpStatus.FOUND);
////		return new ResponseEntity<Item_Details>(new Item_Details(), HttpStatus.NOT_FOUND);
//	}
	
	
	@GetMapping(path="/itemDetail", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ItemDetailsList> getAllItem_Detailesource() {
		ItemDetailsList itemDetailsList =new ItemDetailsList(itemDetailService.getAllItemDetails());
		return new ResponseEntity<ItemDetailsList> (itemDetailsList,HttpStatus.FOUND );

	}
	
	@GetMapping(path="/itemDetail/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ItemDetail getItemByIdResource(@PathVariable("id")String itemId) {
		return itemDetailService.findByItemId(itemId).orElse(new ItemDetail());
	}
	
	@GetMapping(path="/itemDetail/{id}/{quantity}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ItemDetail getItemByIdAndQuantityResource(@PathVariable("id")String itemId,@PathVariable("quantity")int availableQuantity) {
		ItemDetail id =itemDetailService.findByItemId_AndAvailable_Quantity(itemId, availableQuantity);
		if(id!=null)
			return id;
		else 
			return new ItemDetail()	;
	}
	
}










