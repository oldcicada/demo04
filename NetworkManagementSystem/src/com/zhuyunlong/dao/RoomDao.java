package com.zhuyunlong.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.zhuyunlong.pojo.Room;
import com.zhuyunlong.util.JdbcUtil;

public class RoomDao {
	private QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());

	public List<Room> getALLRoom(int roomnumber) {
		String sql = "select * from room where roomnumber=?";
		int param = roomnumber;
		List<Room> list = new ArrayList<>();
		try {
			list = runner.query(sql, new BeanListHandler<Room>(Room.class), param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Room> getRoomList() {
		String sql = "select * from room ";
		List<Room> list = new ArrayList<>();
		try {
			list = runner.query(sql, new BeanListHandler<Room>(Room.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public int getRoomnum(int id) {
		String sql = "select roomnum from room where id=?";
		int param=id;
		int roomum=0;
		try {
			roomum=runner.query(sql, new ScalarHandler<Integer>(), param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roomum;
	}
	public Room getRoom(int roomnumber) {
		String sql = "select * from room where roomnumber=?";
		int param=roomnumber;
		Room room =new Room();
		try {
			room=runner.query(sql, new BeanHandler<Room>(Room.class), param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return room;
	}
	public void updateRoomnum(int roomnum,int id) {
		String sql = "UPDATE room SET roomnum=? WHERE id=?";
		Object[] params={roomnum,id};
		try {
			runner.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateRoomstate(int roomnumber,int state) {
		String sql = "UPDATE room SET state=? WHERE roomnumber=?";
		Object[] params={state,roomnumber};
		try {
			runner.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void add(int roomnumber,int roomnum) {
		String sql="insert into room(roomnumber,roomnum,state) value(?,?,1)";
		Object[] params={roomnumber,roomnum};
		try {
			runner.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
