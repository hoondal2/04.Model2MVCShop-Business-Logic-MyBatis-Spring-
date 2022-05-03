package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.Purchase;
import com.model2.mvc.service.purchase.PurchaseDao;

@Repository("purchaseDaoImpl")
public class PurchaseDaoImpl implements PurchaseDao {
	/// Field
	@Autowired
	@Qualifier("sqlSessionTemplate") // DB Connection
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	// Constructor
	public PurchaseDaoImpl() {
			System.out.println(this.getClass());
		}

	// Method
	public void addPurchase(Purchase purchase) throws Exception {
		sqlSession.insert("PurchaseMapper.addPurchase", purchase);
	}

	public Purchase getPurchase(int tranNo) throws Exception {
		return sqlSession.selectOne("PurchaseMapper.getPurchase", tranNo);
	}

	public void updatePurchase(Purchase purchase) throws Exception {
		sqlSession.update("PurchaseMapper.updateProduct", purchase);
	}

	public List<Purchase> getPurchaseList(Search search) throws Exception {
		return sqlSession.selectList("PurchaseMapper.getPurchaseList", search);
	}

	public void updateTranCode(Purchase purchase) throws Exception {
		sqlSession.update("ProductMapper.updateTranCode", purchase);
	}

}
