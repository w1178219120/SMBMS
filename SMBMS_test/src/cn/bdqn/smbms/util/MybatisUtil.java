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
		//��ȡ�ļ���
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
		//2.����SqlSessionFactory
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
	}
	
	
	//��ȡsqlsession
	public static SqlSession getSqlSession(){
		return sqlSessionFactory.openSession();
	}
	
	
	//�ر�sqlsession
	public static void closeSqlSession(SqlSession session){
		if(session != null){
			session.close();
		}
	}
}