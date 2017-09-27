package com.imooc.service;

import java.util.ArrayList;
import java.util.List;

import com.imooc.dao.MessageDao;

/**
 * 维护相关的业务功能
 *
 */
public class MaintainService {
	/**
	 * 单条删除
	 */
	public void deleteOne(String id) {
		if (id != null && !"".equals(id.trim())) {
			new MessageDao().deleteOne(Integer.valueOf(id));
		}
	}

	/**
	 * 多条删除
	 */
	public void deleteBatch(String[] ids) {
	  List<Integer> idList =new ArrayList<Integer>();
	  for(String id:ids){
		  idList.add(Integer.valueOf(id));
	  }
	  new MessageDao().deleteBatch(idList);
	}
}
