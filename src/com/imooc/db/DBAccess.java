package com.imooc.db;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 访问数据库的类（单例设计模式）
 */
public class DBAccess {
	private static final DBAccess dbAccess =new DBAccess();
	
	private DBAccess() {
	}
	
	public static DBAccess getDBAccess() {
		return dbAccess;
	}
	
	public SqlSession getSqlSession() throws IOException{
	  //通过配置文件获取数据库连接信息
	  Reader reader =Resources.getResourceAsReader("com/imooc/config/Configuration.xml"); 
	  //通过配置信息构建一个SqlSessionFactory
	  SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(reader);
	  //通过SqlSessionFactory打开一个数据库对话
	  return sqlSessionFactory.openSession();
  }
}
