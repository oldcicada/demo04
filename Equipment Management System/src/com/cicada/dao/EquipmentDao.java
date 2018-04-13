package com.cicada.dao;

import java.util.List;
import java.util.Map;

import com.cicada.entity.Equipment;

public interface EquipmentDao {
	//查询equipment分页数据
	List<Equipment> getEquipmentPage(Map<Object, Object> map);
	//查询equipment分页数据
	int getEquipmentPageCount(Map<Object, Object> map);
}
