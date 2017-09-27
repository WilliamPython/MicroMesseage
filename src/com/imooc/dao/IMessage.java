package com.imooc.dao;

import java.util.List;
import java.util.Map;

import com.imooc.bean.Message;

/**
 * ��Message�����ļ����Ӧ�Ľӿ�
 *
 */
public interface IMessage {
	/**
	 * ���ݲ�ѯ������ѯ��Ϣ�б�
	 */
	public List<Message> queryMessageList(Map<String,Object> parameter);
	
	/**
	 * ���ݲ�ѯ������ѯ��Ϣ�б������
	 */
	public int count(Message message);
	
	/**
	 * ���ݲ�ѯ������ҳ��ѯ��Ϣ�б�
	 */
	public List<Message> queryMessageListByPage(Map<String,Object> parameter);
}
