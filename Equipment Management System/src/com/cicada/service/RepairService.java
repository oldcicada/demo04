package com.cicada.service;

import com.cicada.common.PageDto;
import com.cicada.entity.Repair;

public interface RepairService {
//查询维修分页数据
	PageDto<Repair> getRepairPage(int pageIndex, int pageSize, String name, String type, String state);

}
