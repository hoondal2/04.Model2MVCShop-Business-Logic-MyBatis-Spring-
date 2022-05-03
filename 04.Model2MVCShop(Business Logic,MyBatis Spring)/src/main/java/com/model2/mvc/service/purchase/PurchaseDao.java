package com.model2.mvc.service.purchase;

import java.util.HashMap;
import java.util.List;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;

public interface PurchaseDao {

	// INSERT
	public void addPurchase(Purchase purchase) throws Exception;

	// SELECT ONE
	public Purchase getPurchase(int tranNo) throws Exception;

	// SELECT LIST
	public List<Purchase> getPurchaseList(Search search) throws Exception;

	// UPDATE
	public void updatePurchase(Purchase purchase) throws Exception;

	
	public void updateTranCode(Purchase purchase) throws Exception;

}
