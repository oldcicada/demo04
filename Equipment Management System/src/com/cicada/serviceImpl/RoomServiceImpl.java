package com.cicada.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.cicada.common.DictionaryUtil;
import com.cicada.common.PageDto;
import com.cicada.dao.RoomDao;
import com.cicada.entity.Room;
import com.cicada.service.RoomService;
import com.cicada.util.SqlSessionFactoryUtil;

public class RoomServiceImpl implements RoomService {
	private RoomDao rd = null;
	private SqlSession sqlSession = null;

	// 查询roomList分页数据
	public PageDto<Room> queryRoomPage(int pageIndex, int pageSize, String address, String number, String type) {
		sqlSession = SqlSessionFactoryUtil.getSqlSession();
		rd = sqlSession.getMapper(RoomDao.class);
		Map<Object, Object> map = new HashMap<>();
		map.put("start", (pageIndex - 1) * pageSize);
		map.put("end", pageSize);
		map.put("address", "%" + address + "%");
		map.put("number", "%" + number + "%");
		map.put("type", "%" + type + "%");
		List<Room> roomList = rd.queryRoomPage(map);
		for (Room room : roomList) {
			String roomtype = DictionaryUtil.queryDictionaryName("roomtype", room.getType());
			room.setType(roomtype);
			String roomState = DictionaryUtil.queryDictionaryName("roomstate", room.getState());
			room.setState(roomState);
		}
		PageDto<Room> dto = new PageDto<>();
		dto.setPageIndex(pageIndex);
		dto.setPageSize(pageSize);
		int count = rd.queryRoomPageCount(map);
		dto.setCount(count);
		dto.setList(roomList);
		dto.setPageTotal(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
		sqlSession.commit();
		sqlSession.close();
		return dto;
	}

	// 根据id删除信息
	public void deleteById(int roomId) {
		sqlSession = SqlSessionFactoryUtil.getSqlSession();
		rd = sqlSession.getMapper(RoomDao.class);
		rd.deleteById(roomId);
		sqlSession.commit();
		sqlSession.close();

	}

	// 根据id修改信息
	public void updateById(Room room) {
		sqlSession = SqlSessionFactoryUtil.getSqlSession();
		rd = sqlSession.getMapper(RoomDao.class);
		rd.updateById(room);
		sqlSession.commit();
		sqlSession.close();
	}

	// 新增room
	public void add(Room room) {
		sqlSession = SqlSessionFactoryUtil.getSqlSession();
		rd = sqlSession.getMapper(RoomDao.class);
		rd.add(room);
		sqlSession.commit();
		sqlSession.close();
	}

	// 根据id获取信息
	public Room getRoomMessageById(int id) {
		sqlSession = SqlSessionFactoryUtil.getSqlSession();
		rd = sqlSession.getMapper(RoomDao.class);
		Room room = rd.getRoomMessageById(id);
		sqlSession.close();
		return room;
	}
}
