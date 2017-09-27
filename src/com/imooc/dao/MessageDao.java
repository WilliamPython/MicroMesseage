package com.imooc.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Message;
import com.imooc.db.DBAccess;


/**
 * ��message����ص����ݿ����
 * 
 */
public class MessageDao {
	/**
	 * ���ݲ�ѯ������ѯ��Ϣ�б�
	 */
	public List<Message> queryMessageList(Map<String,Object> parameter) {
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = DBAccess.getDBAccess().getSqlSession();
			// ͨ��sqlSessionִ��SQL���
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
	 * ���ݲ�ѯ������ѯ��Ϣ�б������
	 */
	public int count(Message message) {
		SqlSession sqlSession = null;
		int result = 0;
		try {
			sqlSession = DBAccess.getDBAccess().getSqlSession();
			// ͨ��sqlSessionִ��SQL���
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
	 * ���ݲ�ѯ������ҳ��ѯ��Ϣ�б�
	 */
	public List<Message> queryMessageListByPage(Map<String,Object> parameter) {
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = DBAccess.getDBAccess().getSqlSession();
			// ͨ��sqlSessionִ��SQL���
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
     * ����ɾ��
     * @param id
     */
	public void deleteOne(int id) {
		SqlSession sqlSession = null;
		try {
			sqlSession = DBAccess.getDBAccess().getSqlSession();
			// ͨ��sqlSessionִ��sql���
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
     * ����ɾ��
     * @param id
     */
	public void deleteBatch(List<Integer> ids) {
		SqlSession sqlSession = null;
		try {
			sqlSession = DBAccess.getDBAccess().getSqlSession();
			// ͨ��sqlSessionִ��sql���
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
	 * ����JDBC���ݲ�ѯ������ѯ��Ϣ�б�
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
