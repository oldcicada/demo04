package com.cicada.service;

import com.cicada.common.PageDto;
import com.cicada.entity.Equipment;

public interface EquipmentService {
//查询equipment分页数据
	PageDto<Equipment> getEquipmentPage(int pageIndex, int pageSize, String name,String type, String state);

}
