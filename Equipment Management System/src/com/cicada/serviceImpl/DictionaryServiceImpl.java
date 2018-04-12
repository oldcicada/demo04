package com.cicada.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.cicada.common.PageDto;
import com.cicada.dao.DictionaryDao;
import com.cicada.entity.Dictionary;
import com.cicada.service.DictionaryService;
import com.cicada.util.SqlSessionFactoryUtil;

public class DictionaryServiceImpl implements DictionaryService {
	// 根据id查询字典信息
	public Dictionary queryDictionaryMessage(int id) {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		DictionaryDao dd = sqlSession.getMapper(DictionaryDao.class);
		Dictionary dictionary = dd.queryDictionaryMessage(id);
		sqlSession.close();
		return dictionary;
	}

	// 查询所有字典信息
	public List<Dictionary> queryAllDictionary() {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		DictionaryDao dd = sqlSession.getMapper(DictionaryDao.class);
		List<Dictionary> dictionaryList = dd.queryAllDictionary();
		sqlSession.close();
		return dictionaryList;
	}

	// 删除指定id的字典信息
	public void deleteDictionary(int id) {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		DictionaryDao dd = sqlSession.getMapper(DictionaryDao.class);
		dd.deleteDictionary(id);
		sqlSession.commit();
		sqlSession.close();
	}

	// 查询生成列表
	public PageDto<Dictionary> queryDictionaries(int pageIndex,int pageSize,String type, String tag) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("start", (pageIndex-1)*pageSize);
		map.put("end", pageSize);
		map.put("type", "%" + type + "%");
		map.put("tag", "%" + tag + "%");
		
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		DictionaryDao dd = sqlSession.getMapper(DictionaryDao.class);
		List<Dictionary> dictionaries = dd.queryDictionaries(map);
		int count=dd.queryDictionariesCount(map);
		
		PageDto<Dictionary> dto=new PageDto<>();
		dto.setCount(count);
		dto.setList(dictionaries);
		dto.setPageIndex(pageIndex);
		dto.setPageTotal(count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
		sqlSession.close();
		return dto;
	}

	// 添加字典值
	public void addDictionary(Dictionary dic) {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		DictionaryDao dd = sqlSession.getMapper(DictionaryDao.class);
		dd.addDictionary(dic);
		sqlSession.commit();
		sqlSession.close();
	}

	// 修改字典值
	public void updateDictionary(Dictionary dic) {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		DictionaryDao dd = sqlSession.getMapper(DictionaryDao.class);
		dd.updateDictionary(dic);
		sqlSession.commit();
		sqlSession.close();
	}
}
