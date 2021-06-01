package com.example.demo;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;
import org.springframework.web.bind.annotation.RequestBody;

public interface Contronller extends Searchbox,GetList {
	static void Controller(){}
	public static void createDriver() {
		String url = "bolt://localhost:7687";
        Driver driver =GraphDatabase.driver(url,AuthTokens.basic("neo4j","991205"));
        Session session = driver.session();
        System.out.println('2');
	}
	public static void getWQ() {
		Bean list=null;
		String wq = Searchbox.getSearchContent(list);
		System.out.println('3'+wq);
	}
	
}
