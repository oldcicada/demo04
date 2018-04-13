package com.cicada.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.cicada.common.PageDto;
import com.cicada.dao.EquipmentDao;
import com.cicada.entity.Equipment;
import com.cicada.service.EquipmentService;
import com.cicada.util.SqlSessionFactoryUtil;

public class EquipmentServiceImpl implements EquipmentService {
	private SqlSession sqlSession=null;
	private EquipmentDao ed=null;
	//查询equipment分页数据
	public PageDto<Equipment> getEquipmentPage(int pageIndex, int pageSize, String name,String type, String state) {
		
		Map<Object,Object> map=new HashMap<>();
		map.put("start", (pageIndex-1)*pageSize);
		map.put("end", pageSize);
		map.put("name", "%"+name+"%");
		map.put("type","%"+type+"%");
		map.put("state","%"+state+"%");
		
		sqlSession = SqlSessionFactoryUtil.getSqlSession();
		ed = sqlSession.getMapper(EquipmentDao.class);
		int count=ed.getEquipmentPageCount(map);
		List<Equipment> equipList = ed.getEquipmentPage(map);
		PageDto<Equipment> dto=new PageDto<>();
		dto.setList(equipList);
		dto.setPageIndex(pageIndex);
		dto.setPageSize(pageSize);
		dto.setCount(count);
		dto.setPageTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		return dto;
	}
}
