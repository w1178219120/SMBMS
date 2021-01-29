package cn.bdqn.smbms.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import cn.bdqn.smbms.pojo.User;

public class MybatisUtil {
	private static SqlSessionFactory sqlSessionFactory;
	static{
		String resource = "mybatis_config.xml";
		//获取文件流
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
		//2.创建SqlSessionFactory
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
	}
	
	
	//获取sqlsession
	public static SqlSession getSqlSession(){
		return sqlSessionFactory.openSession();
	}
	
	
	//关闭sqlsession
	public static void closeSqlSession(SqlSession session){
		if(session != null){
			session.close();
		}
	}
}