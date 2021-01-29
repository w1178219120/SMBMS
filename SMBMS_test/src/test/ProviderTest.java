package test;


import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;



import cn.bdqn.smbms.pojo.User;
import cn.bdqn.smbms.dao.provider.ProviderMapper;
import cn.bdqn.smbms.dao.role.RoleMapper;
import cn.bdqn.smbms.pojo.Bill;
import cn.bdqn.smbms.pojo.Provider;
import cn.bdqn.smbms.pojo.Role;
import cn.bdqn.smbms.util.MybatisUtil;



public class ProviderTest {
	
	private Logger logger =Logger.getLogger(ProviderTest.class);
	@Test
	public void addProvider(){
		int count = 0;
//		List<User> list = new ArrayList<User>();
		
		SqlSession session = null;
		Date date = new Date();
		session = MybatisUtil.getSqlSession();
		Provider  provider=new Provider();
		provider.setId(16);
		provider.setProCode("1");
		provider.setProName("2");
		provider.setProDesc("3");
		provider.setProContact("4");
		provider.setProPhone("5");
		provider.setProAddress("6");
		provider.setProFax("7");
		provider.setCreatedBy(1);
		provider.setCreationDate(date);
		provider.setModifyDate(date);
		provider.setModifyBy(1);
		
		count = session.getMapper(ProviderMapper.class).addProvider(provider);
		session.commit();
		
		logger.debug("添加成功!");
		MybatisUtil.closeSqlSession(session);
	}
	
	
	@Test
	public void getProviderList(){
		//int count = 0;
		List<Provider> list = new ArrayList<Provider>();
		
		SqlSession session = null;
		
		session = MybatisUtil.getSqlSession();
		
		list = session.getMapper(ProviderMapper.class).getProviderList("2","1");
			session.commit();
			
			for (Provider provider : list) {
				logger.debug(provider.toString());
			}
			MybatisUtil.closeSqlSession(session);
			}
			
				
	@Test
	public void deleteProviderById(){
		int count = 0;
//		List<User> list = new ArrayList<User>();
		
		SqlSession session = null;
		
		session = MybatisUtil.getSqlSession();
		
		count = session.getMapper(ProviderMapper.class).deleteProviderById(16);
			session.commit();
			
				logger.debug("删除成功!!");
			
		MybatisUtil.closeSqlSession(session);
	}
	
	@Test
	public void getProviderById(){
		//int count = 0;
		List<Provider> list = new ArrayList<Provider>();
		
		SqlSession session = null;
		
		session = MybatisUtil.getSqlSession();
		
		list = session.getMapper(ProviderMapper.class).getProviderById(2);
			session.commit();
			
			for (Provider provider : list) {
				logger.debug(provider.toString());
			}
			
		MybatisUtil.closeSqlSession(session);
	}
	
	@Test
	public void modify(){
		int count = 0;
//		List<User> list = new ArrayList<User>();
		
		SqlSession session = null;
		Date date = new Date();
		session = MybatisUtil.getSqlSession();
		Provider  provider=new Provider();
		provider.setId(1);
		provider.setProCode("1");
		provider.setProName("2");
		/*provider.setProDesc("3");
		provider.setProContact("4");
		provider.setProPhone("5");
		provider.setProAddress("6");
		provider.setProFax("7");
		provider.setCreatedBy(1);
		provider.setCreationDate(date);
		provider.setModifyDate(date);
		provider.setModifyBy(1);*/
		
		count = session.getMapper(ProviderMapper.class).modify(provider);
		session.commit();
		
		logger.debug("修改成功!");
		MybatisUtil.closeSqlSession(session);
	}
	
}

