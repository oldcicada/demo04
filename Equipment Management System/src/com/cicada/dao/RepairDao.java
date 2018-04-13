package com.cicada.dao;

import java.util.List;
import java.util.Map;

import com.cicada.entity.Repair;

public interface RepairDao {

	int getRepairPageCount(Map<Object, Object> map);

	List<Repair> getRepairPage(Map<Object, Object> map);

}
