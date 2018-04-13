package com.cicada.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.cicada.common.PageDto;
import com.cicada.dao.RepairDao;
import com.cicada.entity.Repair;
import com.cicada.service.RepairService;
import com.cicada.util.SqlSessionFactoryUtil;

public class RepairServiceImpl implements RepairService {
	private SqlSession sqlSession=null;
	private RepairDao rd=null;
	//查询维修分页数据
		public PageDto<Repair> getRepairPage(int pageIndex, int pageSize, String name, String type, String state){
			Map<Object,Object> map=new HashMap<>();
			map.put("start", (pageIndex-1)*pageSize);
			map.put("end", pageSize);
			map.put("name", "%"+name+"%");
			map.put("type","%"+type+"%");
			map.put("state","%"+state+"%");
			
			sqlSession = SqlSessionFactoryUtil.getSqlSession();
			rd = sqlSession.getMapper(RepairDao.class);
			int count=rd.getRepairPageCount(map);
			List<Repair> repairList = rd.getRepairPage(map);
			PageDto<Repair> dto=new PageDto<>();
			dto.setList(repairList);
			dto.setPageIndex(pageIndex);
			dto.setPageSize(pageSize);
			dto.setCount(count);
			dto.setPageTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
			return dto;
		}
}
