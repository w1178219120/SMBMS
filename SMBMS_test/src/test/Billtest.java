package test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import cn.bdqn.smbms.dao.bill.BillMapper;
import cn.bdqn.smbms.pojo.Bill;
import cn.bdqn.smbms.util.MybatisUtil;



public class Billtest {
	private Logger logger = Logger.getLogger(Billtest.class);

	@Test
	public void test() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		Bill bill = new Bill();
		bill.setBillCode("RB_G20");
		bill.setProductName("机器人");
		bill.setProductDesc("玩具");
		bill.setProductUnit("个");
		BigDecimal b1 = new BigDecimal(50);
		bill.setProductCount(b1);
		BigDecimal b2 = new BigDecimal(50);
		bill.setTotalPrice(b2);
		bill.setIsPayment(1);
		bill.setCreatedBy(1);
		bill.setProviderId(4);
		int add=0;
		try {
			add = sqlSession.getMapper(BillMapper.class).add(bill);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sqlSession.commit();
		logger.debug(add);
	}
	@Test
	public void getBillList(){
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		Bill bill = new Bill();
		bill.setProductName("玩具车");
		bill.setProviderId(4);
		try {
			List<Bill> billList = sqlSession.getMapper(BillMapper.class).getBillList(bill);
			for (Bill bill2 : billList) {
				logger.debug(bill2.getProductName()+bill2.getTotalPrice());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void deleteBillById(){
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		try {
			int num = sqlSession.getMapper(BillMapper.class).deleteBillById(21);
			sqlSession.commit();
			logger.debug(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void getBillById(){
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		try {
			Bill bill = sqlSession.getMapper(BillMapper.class).getBillById(19);			
			logger.debug(bill.getProductName()+bill.getTotalPrice());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void modify(){
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		Bill bill = new Bill();
		bill.setId(6);
		bill.setBillCode("RB-G6");
		try {
			int num = sqlSession.getMapper(BillMapper.class).modify(bill);
			sqlSession.commit();
			logger.debug(num);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	@Test
	public void getBillCountByProviderId(){
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		Bill bill = new Bill();
		bill.setProviderId(14);
		try {
			int num = sqlSession.getMapper(BillMapper.class).getBillCountByProviderId(bill);
			logger.debug(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
