package com.cicada.service;

import com.cicada.common.PageDto;
import com.cicada.entity.Equipment;

public interface EquipmentService {
//查询equipment分页数据
	PageDto<Equipment> getEquipmentPage(int pageIndex, int pageSize, String name,String type, String state);
//根据id删除设备
	void deleteById(int equipmentId);
	//获取room_id
	int getRoomId(int equipmentId);
	//添加设备
	void addEquipment(Equipment equip);
}
