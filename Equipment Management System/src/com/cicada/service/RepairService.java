package com.cicada.service;

import com.cicada.common.PageDto;
import com.cicada.entity.Repair;

public interface RepairService {
	// 查询维修分页数据
	PageDto<Repair> getRepairPage(int pageIndex, int pageSize, String name, String type, String state);

	// 处理维修请求
	void updateState(Repair repair);

	// 根据id获得repair信息
	Repair getRepairMessage(int id);
	//添加repair信息
	void addRepair(Repair repair);

}
