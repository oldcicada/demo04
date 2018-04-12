package com.cicada.dao;

import java.util.List;
import java.util.Map;

import com.cicada.entity.Dictionary;

public interface DictionaryDao {
	//根据id查询字典信息
	public Dictionary queryDictionaryMessage(int id);
	//查询所有字典信息
	List<Dictionary> queryAllDictionary();
	//删除指定id的字典信息
	public void deleteDictionary(int id);
	//查询生成列表
	List<Dictionary> queryDictionaries(Map<Object, Object> map);
	//查询列表count
	int queryDictionariesCount(Map<Object, Object> map);
	//添加字典值
	public void addDictionary(Dictionary dic);
	//修改字典值
	public void updateDictionary(Dictionary dic);
}
