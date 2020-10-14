package com.th.dao;


import com.th.entity.Tree;

import java.util.List;
import java.util.Map;


public interface TreeDao {
	
	/**
	 * ���ݸ��ڵ�  ������  �������������ids֮��
	 * map �� father��-1�� ��   ids(1.2.5.6.9.4.4.)
	 * 
	 * mapֻ���ids���������� ids(1.2.5.6.9.4.4.)    �������Ӧ�þ�������realm ���� shire ��Ȩ��� ����ids��tree
	 * 
	 * ���ݸ��ڵ� �ò˵�  û�й�������  ��Ȩ���ڵ�ʱ��Ҫ��
	 */
	 List<Tree> getTreesByFatherOrIds(Map<String,Object> map);
	
	 Tree findById(Integer id);
}