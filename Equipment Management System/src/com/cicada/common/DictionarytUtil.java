package com.cicada.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cicada.entity.Dictionary;
import com.cicada.service.DictionaryService;
import com.cicada.serviceImpl.DictionaryServiceImpl;

public class DictionarytUtil {
	
	//根据类型保存数据字典值
	private static Map<String, List<Dictionary>> map=new HashMap<String, List<Dictionary>>();
	
	static {
		map=queryAllDictionary();
	}
	/**
	 * 根据类型查询
	 * @param type
	 */
	public static  List<Dictionary> queryDictionaryByType(String type){
		return map.get(type);
	}
	
	/**
	 * 根据类型和值查询名称
	 * @param type
	 */
	public static String queryDictionaryName(String type,String value){
		List<Dictionary> dictionarys=map.get(type);
		for (Dictionary dictionary : dictionarys) {
			if(dictionary.getValue().equals(value)){
				return dictionary.getTag();
			}
		}
		return "";
	}
	
	/**
	 * 查询所有字典信息
	 * @return
	 */
	private static Map<String, List<Dictionary>> queryAllDictionary(){
		DictionaryService ds=new DictionaryServiceImpl();
		List<Dictionary> dictionaryList=ds.queryAllDictionary();
		
		for (Dictionary dictionary : dictionaryList) {
			if(map.containsKey(dictionary.getType())){
				List<Dictionary> dicts=map.get(dictionary.getType());
				dicts.add(dictionary);
			}else{
				List<Dictionary> dicts=new ArrayList<Dictionary>();
				dicts.add(dictionary);
				map.put(dictionary.getType(), dicts);
			}
		}
		return map;
	}

}
