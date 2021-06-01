
package com.example.demo;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;




@SpringBootApplication

@RestController

public class DemoApplication implements Contronller {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
		
	@CrossOrigin("http://localhost:8080")
	@GetMapping("/index")
	public String hello(@RequestParam(value = "wq" ,defaultValue = "hello") String wq) {
		String url = "bolt://localhost:7687";
        Driver driver =GraphDatabase.driver(url,AuthTokens.basic("neo4j","991205"));
        try(Session session = driver.session()){
        	Result result = session.run("MATCH p=(m)-[r:`相关概念`]->(n) RETURN m,n,r limit 100");
        	while(result.hasNext()) {
        		Record record = result.next();
        		System.out.println(record);
        		
        	}
        }catch(Exception ex) {
        	System.out.println(ex);
        }finally {
        	driver.close();
        }
		
		return wq;
	}
	
	

}
