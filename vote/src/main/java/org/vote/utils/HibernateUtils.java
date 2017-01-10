package org.vote.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtils {

		//定义一个EntityMaageerFactory，用于创建EntityManager对象
		//它用于取代hibernate的SessionFactory
	private static EntityManagerFactory emFactory;
	
	//初始化工厂
	static{
		//通过Presistence类的静态方法创建一个EntityManagerFactory
		//createEntityManagerFactory方法的参数指定持久化单元的名称
		emFactory =Persistence.createEntityManagerFactory("mysql_jpa");
	}
	//提供一个用于获取EntityManager对象
	//EntityManager对象取代hibernate中的Session
	public static EntityManager getEntityManager(){
		//通过EntityManagerFactory来创建EntityManager对象
		return emFactory.createEntityManager();
		
	}
	
	public static void main(String[] args) {
		System.out.println(getEntityManager());
	}
}
