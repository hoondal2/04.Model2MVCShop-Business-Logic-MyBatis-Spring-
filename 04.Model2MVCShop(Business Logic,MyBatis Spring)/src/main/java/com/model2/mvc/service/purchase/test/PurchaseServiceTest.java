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
 * ㅇ JUnit4 (Test Framework) 과 Spring Framework 통합 Test( Unit Test)
 * ㅇ Spring 은 JUnit 4를 위한 지원 클래스를 통해 스프링 기반 통합 테스트 코드를 작성 할 수 있다.
 * ㅇ @RunWith : Meta-data 를 통한 wiring(생성,DI) 할 객체 구현체 지정
 * ㅇ @ContextConfiguration : Meta-data location 지정
 * ㅇ @Test : 테스트 실행 소스 지정
 */

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/commonservice.xml" })
public class PurchaseServiceTest {

	//==>@RunWith,@ContextConfiguration 이용 Wiring, Test 할 instance DI
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
		purchase.setDivyAddr("송파구 오금로");
		purchase.setDivyRequest("빨리요");
		purchase.setDivyDate("20220503");
		
		purchaseService.addPurchase(purchase);
		
		purchase = purchaseService.getPurchase(777);

		//==> console 확인
		//System.out.println(purchase);
		
		//==> API 확인
		Assert.assertEquals("1", purchase.getPaymentOption());
		Assert.assertEquals("testReceiverName", purchase.getReceiverName());
		Assert.assertEquals("010-9500-7753", purchase.getReceiverPhone());
		Assert.assertEquals("송파구 오금로", purchase.getDivyAddr());
		Assert.assertEquals("빨리요", purchase.getDivyRequest());
		Assert.assertEquals("20220503", purchase.getDivyDate());
	}
}
	
	//@Test
//	public void testGetPurchase() throws Exception {
//		
//		Purchase purchase = new Purchase();
		//==> 필요하다면...
//		purchase.setPurchaseId("testPurchaseId");
//		purchase.setPurchaseName("testPurchaseName");
//		purchase.setPassword("testPasswd");
//		purchase.setSsn("1111112222222");
//		purchase.setPhone("111-2222-3333");
//		purchase.setAddr("경기도");
//		purchase.setEmail("test@test.com");
		
//		purchase = purchaseService.getPurchase("testPurchaseId");
//
//		//==> console 확인
//		//System.out.println(purchase);
//		
//		//==> API 확인
//		Assert.assertEquals("testPurchaseId", purchase.getPurchaseId());
//		Assert.assertEquals("testPurchaseName", purchase.getPurchaseName());
//		Assert.assertEquals("testPasswd", purchase.getPassword());
//		Assert.assertEquals("111-2222-3333", purchase.getPhone());
//		Assert.assertEquals("경기도", purchase.getAddr());
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
//		Assert.assertEquals("경기도", purchase.getAddr());
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
//		//==> console 확인
//		//System.out.println(purchase);
//			
//		//==> API 확인
//		Assert.assertEquals("change", purchase.getPurchaseName());
//		Assert.assertEquals("777-7777-7777", purchase.getPhone());
//		Assert.assertEquals("change", purchase.getAddr());
//		Assert.assertEquals("change@change.com", purchase.getEmail());
//	 }
//	 
//	//@Test
//	public void testCheckDuplication() throws Exception{
//
//		//==> 필요하다면...
////		Purchase purchase = new Purchase();
////		purchase.setPurchaseId("testPurchaseId");
////		purchase.setPurchaseName("testPurchaseName");
////		purchase.setPassword("testPasswd");
////		purchase.setSsn("1111112222222");
////		purchase.setPhone("111-2222-3333");
////		purchase.setAddr("경기도");
////		purchase.setEmail("test@test.com");
////		
////		purchaseService.addPurchase(purchase);
//		
//		//==> console 확인
//		System.out.println(purchaseService.checkDuplication("testPurchaseId"));
//		System.out.println(purchaseService.checkDuplication("testPurchaseId"+System.currentTimeMillis()) );
//	 	
//		//==> API 확인
//		Assert.assertFalse( purchaseService.checkDuplication("testPurchaseId") );
//	 	Assert.assertTrue( purchaseService.checkDuplication("testPurchaseId"+System.currentTimeMillis()) );
//		 	
//	}
//	
//	 //==>  주석을 풀고 실행하면....
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
//		//==> console 확인
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
//	 	//==> console 확인
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
//		//==> console 확인
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
//		//==> console 확인
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
//		//==> console 확인
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
//		//==> console 확인
//	 	System.out.println(list);
//	 	
//	 	totalCount = (Integer)map.get("totalCount");
//	 	System.out.println(totalCount);
//	 }	 
//}