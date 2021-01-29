package test;


import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;


import cn.bdqn.smbms.pojo.User;
import cn.bdqn.smbms.dao.role.RoleMapper;
import cn.bdqn.smbms.pojo.Bill;
import cn.bdqn.smbms.pojo.Role;
import cn.bdqn.smbms.util.MybatisUtil;


public class RoleTest {
	private Logger logger =Logger.getLogger(RoleTest.class);
	
	@Test
	public void getRole(){
		//int count = 0;
		List<Role> list = new ArrayList<Role>();
		
		SqlSession session = null;
		
		session = MybatisUtil.getSqlSession();
		
		list = session.getMapper(RoleMapper.class).getRole();
			session.commit();
			
			for (Role role : list) {
				logger.debug(role.getId()+role.getRoleCode()+role.getRoleName());
			}
			
				
		MybatisUtil.closeSqlSession(session);
	}
	
}
