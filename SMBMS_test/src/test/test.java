package test;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.bdqn.smbms.dao.bill.BillMapper;
import cn.bdqn.smbms.dao.provider.ProviderMapper;
import cn.bdqn.smbms.dao.user.UserMapper;
import cn.bdqn.smbms.pojo.Bill;
import cn.bdqn.smbms.pojo.Provider;
import cn.bdqn.smbms.pojo.User;



public class test {

	Logger logger=Logger.getLogger(test.class);
	
	@Test
	public void test() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
		
		ProviderMapper providerMapper = (ProviderMapper) applicationContext.getBean("providerMapper");
		Bill bill2 = new Bill();
		bill2.setProductName("Âö¶¯");
		bill2.setProviderId(2);
		
		try {
			for (Provider provider : providerMapper.getProviderList("2", "1")) {
				logger.info("+++"+provider.getProContact());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
