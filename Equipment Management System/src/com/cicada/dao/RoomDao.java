package com.cicada.dao;

import java.util.List;
import java.util.Map;

import com.cicada.entity.Room;

public interface RoomDao {
	//查询roomList分页数据
	List<Room> queryRoomPage(Map<Object, Object> map);
	//查询roomList分页总数据
	int queryRoomPageCount(Map<Object, Object> map);
	//根据id删除信息
	void deleteById(int id);
	//根据id修改信息
	void updateById(Room room);
	//新增room
	void add(Room room);
	//根据id获取信息
	Room getRoomMessageById(int id);
	//获取所有房间id和number信息
	List<Room> getRoom();
}
