package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.product.ProductDao;
import com.model2.mvc.service.purchase.PurchaseDao;
import com.model2.mvc.service.purchase.PurchaseService;

@Service("purchaseServiceImpl")

public class PurchaseServiceImpl implements PurchaseService{
	
	///Field
	@Autowired
	@Qualifier("purchaseDaoImpl")
	private PurchaseDao purchaseDao;
	public void setProductDao(ProductDao productDao) {
		this.purchaseDao = purchaseDao;
		}
	
	public void addPurchase(Purchase purchaseVO) throws Exception{
		purchaseDao.addPurchase(purchaseVO);
	}
	
	public Purchase getPurchase(int tranNo) throws Exception{
		return purchaseDao.getPurchase(tranNo);
	}
	
	public HashMap<String, Object> getPurchaseList(Search search, String tranCode) throws Exception{
		
		List<Purchase> list = (List<Purchase>) purchaseDao.getPurchaseList(search);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		
		return map;
	}
	
	
	public Purchase updatePurchase(Purchase purchaseVO) throws Exception{
		purchaseDao.updatePurchase(purchaseVO);
		return purchaseVO;
	}
	
	public void updateTranCode(Purchase purchaseVO) throws Exception{
		purchaseDao.updateTranCode(purchaseVO);	
	}
	
}
