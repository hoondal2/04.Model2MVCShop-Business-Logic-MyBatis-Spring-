package com.model2.mvc.service.purchase.test;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.purchase.PurchaseService;


/*
 *	FileName :  PurchaseServiceTest.java
 * �� JUnit4 (Test Framework) �� Spring Framework ���� Test( Unit Test)
 * �� Spring �� JUnit 4�� ���� ���� Ŭ������ ���� ������ ��� ���� �׽�Ʈ �ڵ带 �ۼ� �� �� �ִ�.
 * �� @RunWith : Meta-data �� ���� wiring(����,DI) �� ��ü ����ü ����
 * �� @ContextConfiguration : Meta-data location ����
 * �� @Test : �׽�Ʈ ���� �ҽ� ����
 */

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/commonservice.xml" })
public class PurchaseServiceTest {

	//==>@RunWith,@ContextConfiguration �̿� Wiring, Test �� instance DI
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;

	@Test
	public void testAddPurchase() throws Exception {
		Purchase purchase = new Purchase();

		User user = new User();
		user.setUserId("user10");
		purchase.setBuyer(user);
		
		Product product = new Product();
		product.setProdNo(10062);
		purchase.setPurchaseProd(product);
		
		purchase.setTranNo(777);
		purchase.setPaymentOption("a");
		purchase.setReceiverName("testReceiverName");
		purchase.setReceiverPhone("01095007753");
		purchase.setDivyAddr("���ı� ���ݷ�");
		purchase.setDivyRequest("������");
		purchase.setDivyDate("20220503");
		
		purchaseService.addPurchase(purchase);
		
		purchase = purchaseService.getPurchase(777);

		//==> console Ȯ��
		//System.out.println(purchase);
		
		//==> API Ȯ��
		Assert.assertEquals("1", purchase.getPaymentOption());
		Assert.assertEquals("testReceiverName", purchase.getReceiverName());
		Assert.assertEquals("010-9500-7753", purchase.getReceiverPhone());
		Assert.assertEquals("���ı� ���ݷ�", purchase.getDivyAddr());
		Assert.assertEquals("������", purchase.getDivyRequest());
		Assert.assertEquals("20220503", purchase.getDivyDate());
	}
}
	
	//@Test
//	public void testGetPurchase() throws Exception {
//		
//		Purchase purchase = new Purchase();
		//==> �ʿ��ϴٸ�...
//		purchase.setPurchaseId("testPurchaseId");
//		purchase.setPurchaseName("testPurchaseName");
//		purchase.setPassword("testPasswd");
//		purchase.setSsn("1111112222222");
//		purchase.setPhone("111-2222-3333");
//		purchase.setAddr("��⵵");
//		purchase.setEmail("test@test.com");
		
//		purchase = purchaseService.getPurchase("testPurchaseId");
//
//		//==> console Ȯ��
//		//System.out.println(purchase);
//		
//		//==> API Ȯ��
//		Assert.assertEquals("testPurchaseId", purchase.getPurchaseId());
//		Assert.assertEquals("testPurchaseName", purchase.getPurchaseName());
//		Assert.assertEquals("testPasswd", purchase.getPassword());
//		Assert.assertEquals("111-2222-3333", purchase.getPhone());
//		Assert.assertEquals("��⵵", purchase.getAddr());
//		Assert.assertEquals("test@test.com", purchase.getEmail());
//
//		Assert.assertNotNull(purchaseService.getPurchase("purchase02"));
//		Assert.assertNotNull(purchaseService.getPurchase("purchase05"));
//	}
//	
//	//@Test
//	 public void testUpdatePurchase() throws Exception{
//		 
//		Purchase purchase = purchaseService.getPurchase("testPurchaseId");
//		Assert.assertNotNull(purchase);
//		
//		Assert.assertEquals("testPurchaseName", purchase.getPurchaseName());
//		Assert.assertEquals("111-2222-3333", purchase.getPhone());
//		Assert.assertEquals("��⵵", purchase.getAddr());
//		Assert.assertEquals("test@test.com", purchase.getEmail());
//
//		purchase.setPurchaseName("change");
//		purchase.setPhone("777-7777-7777");
//		purchase.setAddr("change");
//		purchase.setEmail("change@change.com");
//		
//		purchaseService.updatePurchase(purchase);
//		
//		purchase = purchaseService.getPurchase("testPurchaseId");
//		Assert.assertNotNull(purchase);
//		
//		//==> console Ȯ��
//		//System.out.println(purchase);
//			
//		//==> API Ȯ��
//		Assert.assertEquals("change", purchase.getPurchaseName());
//		Assert.assertEquals("777-7777-7777", purchase.getPhone());
//		Assert.assertEquals("change", purchase.getAddr());
//		Assert.assertEquals("change@change.com", purchase.getEmail());
//	 }
//	 
//	//@Test
//	public void testCheckDuplication() throws Exception{
//
//		//==> �ʿ��ϴٸ�...
////		Purchase purchase = new Purchase();
////		purchase.setPurchaseId("testPurchaseId");
////		purchase.setPurchaseName("testPurchaseName");
////		purchase.setPassword("testPasswd");
////		purchase.setSsn("1111112222222");
////		purchase.setPhone("111-2222-3333");
////		purchase.setAddr("��⵵");
////		purchase.setEmail("test@test.com");
////		
////		purchaseService.addPurchase(purchase);
//		
//		//==> console Ȯ��
//		System.out.println(purchaseService.checkDuplication("testPurchaseId"));
//		System.out.println(purchaseService.checkDuplication("testPurchaseId"+System.currentTimeMillis()) );
//	 	
//		//==> API Ȯ��
//		Assert.assertFalse( purchaseService.checkDuplication("testPurchaseId") );
//	 	Assert.assertTrue( purchaseService.checkDuplication("testPurchaseId"+System.currentTimeMillis()) );
//		 	
//	}
//	
//	 //==>  �ּ��� Ǯ�� �����ϸ�....
//	 //@Test
//	 public void testGetPurchaseListAll() throws Exception{
//		 
//	 	Search search = new Search();
//	 	search.setCurrentPage(1);
//	 	search.setPageSize(3);
//	 	Map<String,Object> map = purchaseService.getPurchaseList(search);
//	 	
//	 	List<Object> list = (List<Object>)map.get("list");
//	 	Assert.assertEquals(3, list.size());
//	 	
//		//==> console Ȯ��
//	 	//System.out.println(list);
//	 	
//	 	Integer totalCount = (Integer)map.get("totalCount");
//	 	System.out.println(totalCount);
//	 	
//	 	System.out.println("=======================================");
//	 	
//	 	search.setCurrentPage(1);
//	 	search.setPageSize(3);
//	 	search.setSearchCondition("0");
//	 	search.setSearchKeyword("");
//	 	map = purchaseService.getPurchaseList(search);
//	 	
//	 	list = (List<Object>)map.get("list");
//	 	Assert.assertEquals(3, list.size());
//	 	
//	 	//==> console Ȯ��
//	 	//System.out.println(list);
//	 	
//	 	totalCount = (Integer)map.get("totalCount");
//	 	System.out.println(totalCount);
//	 }
//	 
//	 //@Test
//	 public void testGetPurchaseListByPurchaseId() throws Exception{
//		 
//	 	Search search = new Search();
//	 	search.setCurrentPage(1);
//	 	search.setPageSize(3);
//	 	search.setSearchCondition("0");
//	 	search.setSearchKeyword("admin");
//	 	Map<String,Object> map = purchaseService.getPurchaseList(search);
//	 	
//	 	List<Object> list = (List<Object>)map.get("list");
//	 	Assert.assertEquals(1, list.size());
//	 	
//		//==> console Ȯ��
//	 	//System.out.println(list);
//	 	
//	 	Integer totalCount = (Integer)map.get("totalCount");
//	 	System.out.println(totalCount);
//	 	
//	 	System.out.println("=======================================");
//	 	
//	 	search.setSearchCondition("0");
//	 	search.setSearchKeyword(""+System.currentTimeMillis());
//	 	map = purchaseService.getPurchaseList(search);
//	 	
//	 	list = (List<Object>)map.get("list");
//	 	Assert.assertEquals(0, list.size());
//	 	
//		//==> console Ȯ��
//	 	//System.out.println(list);
//	 	
//	 	totalCount = (Integer)map.get("totalCount");
//	 	System.out.println(totalCount);
//	 }
//	 
//	 //@Test
//	 public void testGetPurchaseListByPurchaseName() throws Exception{
//		 
//	 	Search search = new Search();
//	 	search.setCurrentPage(1);
//	 	search.setPageSize(3);
//	 	search.setSearchCondition("1");
//	 	search.setSearchKeyword("SCOTT");
//	 	Map<String,Object> map = purchaseService.getPurchaseList(search);
//	 	
//	 	List<Object> list = (List<Object>)map.get("list");
//	 	Assert.assertEquals(3, list.size());
//	 	
//		//==> console Ȯ��
//	 	System.out.println(list);
//	 	
//	 	Integer totalCount = (Integer)map.get("totalCount");
//	 	System.out.println(totalCount);
//	 	
//	 	System.out.println("=======================================");
//	 	
//	 	search.setSearchCondition("1");
//	 	search.setSearchKeyword(""+System.currentTimeMillis());
//	 	map = purchaseService.getPurchaseList(search);
//	 	
//	 	list = (List<Object>)map.get("list");
//	 	Assert.assertEquals(0, list.size());
//	 	
//		//==> console Ȯ��
//	 	System.out.println(list);
//	 	
//	 	totalCount = (Integer)map.get("totalCount");
//	 	System.out.println(totalCount);
//	 }	 
//}