package com.cicada.service;

import java.util.List;

import com.cicada.entity.Dictionary;

public interface DictionaryService {
	//根据id查询字典信息
	public Dictionary queryDictionaryMessage(int id);
	//查询所有字典信息
	public List<Dictionary> queryAllDictionary();
	//删除指定id的字典信息
	public void deleteDictionary(int id);
	//查询生成列表
	public List<Dictionary> queryDictionaries(String type, String tag);
	//添加字典值
	public void addDictionary(Dictionary dic);
	//修改字典值
	public void updateDictionary(Dictionary dic);
}
