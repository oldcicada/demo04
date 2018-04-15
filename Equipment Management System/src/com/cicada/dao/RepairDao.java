package com.cicada.dao;

import java.util.List;
import java.util.Map;

import com.cicada.entity.Repair;

public interface RepairDao {

	int getRepairPageCount(Map<Object, Object> map);

	List<Repair> getRepairPage(Map<Object, Object> map);
	//处理维修请求
	void updateState(Repair repair);

	// 根据id获得repair信息
	Repair getRepairMessage(int id);
//添加repair信息
	void addRepair(Repair repair);
}
