package com.imooc.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Message;
import com.imooc.db.DBAccess;


/**
 * 和message表相关的数据库操作
 * 
 */
public class MessageDao {
	/**
	 * 根据查询条件查询消息列表
	 */
	public List<Message> queryMessageList(Map<String,Object> parameter) {
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = DBAccess.getDBAccess().getSqlSession();
			// 通过sqlSession执行SQL语句
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			messageList = imessage.queryMessageList(parameter);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;
	}
	
	/**
	 * 根据查询条件查询消息列表的条数
	 */
	public int count(Message message) {
		SqlSession sqlSession = null;
		int result = 0;
		try {
			sqlSession = DBAccess.getDBAccess().getSqlSession();
			// 通过sqlSession执行SQL语句
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			result = imessage.count(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return result;
	}
	/**
	 * 根据查询条件分页查询消息列表
	 */
	public List<Message> queryMessageListByPage(Map<String,Object> parameter) {
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = DBAccess.getDBAccess().getSqlSession();
			// 通过sqlSession执行SQL语句
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			messageList = imessage.queryMessageListByPage(parameter);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;
	}
    /**
     * 单条删除
     * @param id
     */
	public void deleteOne(int id) {
		SqlSession sqlSession = null;
		try {
			sqlSession = DBAccess.getDBAccess().getSqlSession();
			// 通过sqlSession执行sql语句
			sqlSession.delete("Message.deleteOne",id);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}

		}
	}
	/**
     * 多条删除
     * @param id
     */
	public void deleteBatch(List<Integer> ids) {
		SqlSession sqlSession = null;
		try {
			sqlSession = DBAccess.getDBAccess().getSqlSession();
			// 通过sqlSession执行sql语句
			sqlSession.delete("Message.deleteBatch",ids);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}

		}
	}
	
	/**
	 * 利用JDBC根据查询条件查询消息列表
	 * @param command
	 * @param description
	 * @return
	 */
	/*public List<Message> queryMessageList(String command, String description) {
		List<Message> messageList = new ArrayList<Message>();
		try {
			Connection conn = DBHelper.getConnection();
			StringBuilder sql = new StringBuilder(
					"select ID,COMMAND,DESCRIPTION,CONTENT from message where 1=1");
			List<String> paramList = new ArrayList<String>();

			if (command != null && !"".equals(command.trim())) {
				sql.append(" and COMMAND =?");
				paramList.add(command);
			}
			if (description != null && !"".equals(description.trim())) {
				sql.append(" and DESCRIPTION like '%' ? '%'");
				paramList.add(description);
			}
			PreparedStatement statement = conn.prepareStatement(sql.toString());
			for (int i = 0; i < paramList.size(); i++) {
				statement.setString(i + 1, paramList.get(i));
			}
			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Message m = new Message();
				messageList.add(m);
				m.setId(rs.getInt("ID"));
				m.setCommand(rs.getString("COMMAND"));
				m.setDescription(rs.getString("DESCRIPTION"));
				m.setContent(rs.getString("CONTENT"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return messageList;

	}*/
}
