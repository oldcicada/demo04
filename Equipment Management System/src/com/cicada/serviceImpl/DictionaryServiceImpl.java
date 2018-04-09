package com.cicada.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

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
	public List<Dictionary> queryDictionaries(String type, String tag) {
		SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession();
		DictionaryDao dd = sqlSession.getMapper(DictionaryDao.class);
		Map<String, String> map = new HashMap<>();
		map.put("type", "%" + type + "%");
		map.put("tag", "%" + tag + "%");
		List<Dictionary> dictionaries = dd.queryDictionaries(map);
		System.out.println(dictionaries.toString());
		sqlSession.close();
		return dictionaries;
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
