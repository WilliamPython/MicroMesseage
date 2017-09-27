package com.imooc.service;

import java.util.ArrayList;
import java.util.List;

import com.imooc.dao.MessageDao;

/**
 * ά����ص�ҵ����
 *
 */
public class MaintainService {
	/**
	 * ����ɾ��
	 */
	public void deleteOne(String id) {
		if (id != null && !"".equals(id.trim())) {
			new MessageDao().deleteOne(Integer.valueOf(id));
		}
	}

	/**
	 * ����ɾ��
	 */
	public void deleteBatch(String[] ids) {
	  List<Integer> idList =new ArrayList<Integer>();
	  for(String id:ids){
		  idList.add(Integer.valueOf(id));
	  }
	  new MessageDao().deleteBatch(idList);
	}
}
