package com.cicada.service;

import java.util.List;

import com.cicada.common.PageDto;
import com.cicada.entity.Room;

public interface RoomService {
	// 查询roomList分页数据
	PageDto<Room> queryRoomPage(int pageIndex, int pageSize, String address, String number, String type);

	// 根据id删除信息
	void deleteById(int roomId);

	// 根据id修改信息
	void updateById(Room room);

	// 新增room
	void add(Room room);
	
	// 根据id获取信息
	Room getRoomMessageById(int id);
//获取所有房间id和number信息
	List<Room> getRoom();
}
