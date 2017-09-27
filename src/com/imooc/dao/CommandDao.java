package com.imooc.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.imooc.bean.Command;
import com.imooc.db.DBAccess;

/**
 * 与指令表对应的数据库操作类
 */
public class CommandDao {
	/**
	 * 根据查询条件查询指令列表
	 */
	public List<Command> queryCommandList(String name,String description) {
		List<Command> commandList = new ArrayList<Command>();
		SqlSession sqlSession = null;
		try {
			sqlSession = DBAccess.getDBAccess().getSqlSession();
			// 通过sqlSession执行SQL语句
			commandList = sqlSession.selectList("Command.queryCommandList", new Command(name, description));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return commandList;
	}
}
