package com.imooc.db;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * �������ݿ���ࣨ�������ģʽ��
 */
public class DBAccess {
	private static final DBAccess dbAccess =new DBAccess();
	
	private DBAccess() {
	}
	
	public static DBAccess getDBAccess() {
		return dbAccess;
	}
	
	public SqlSession getSqlSession() throws IOException{
	  //ͨ�������ļ���ȡ���ݿ�������Ϣ
	  Reader reader =Resources.getResourceAsReader("com/imooc/config/Configuration.xml"); 
	  //ͨ��������Ϣ����һ��SqlSessionFactory
	  SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(reader);
	  //ͨ��SqlSessionFactory��һ�����ݿ�Ի�
	  return sqlSessionFactory.openSession();
  }
}
