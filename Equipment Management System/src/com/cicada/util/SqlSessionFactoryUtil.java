package com.cicada.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtil {
private static SqlSessionFactory sqlSessionFactory;
	
	//静态代码块:只加载一次。
		/* 1、从 XML 中构建 SqlSessionFactory
		 * 每个基于 MyBatis 的应用都是以一个 SqlSessionFactory 的实例为中心的。
		 * SqlSessionFactory 的实例可以通过 SqlSessionFactoryBuilder 获得。
		 * 而 SqlSessionFactoryBuilder 则可以从 XML 
		 * 配置文件或一个预先定制的 Configuration 的实例构建出 SqlSessionFactory 的实例。
		 * */
	static {
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream= Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*既然有了 SqlSessionFactory ，顾名思义，我们就可以从中获得 SqlSession 的实例了。
	 * SqlSession 完全包含了面向数据库执行 SQL 命令所需的所有方法。
	 * 你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
	 */
	public static SqlSession getSqlSession(){
		return sqlSessionFactory.openSession();
	}
	
	
}
