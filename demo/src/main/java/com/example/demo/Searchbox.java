package com.example.demo;

import java.util.List;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@CrossOrigin("http://localhost:8080")
@RestController

 

public interface Searchbox{
	@RequestMapping(value = "/index/search",method= {RequestMethod.GET,RequestMethod.POST})
	@CrossOrigin("http://localhost:8080")
	
    static String getSearchContent(@RequestBody Bean list)
    {
		String entity = list.getwq();
		int type = list.gettype();
		String url = "bolt://localhost:7687";
		JSONObject mydata = new JSONObject();
        
		JSONArray nodes = new JSONArray();
		JSONArray links = new JSONArray();
        Driver driver =GraphDatabase.driver(url,AuthTokens.basic("neo4j","991205"));
        try(Session session = driver.session()){
        	
        	Result result = session.run(" MATCH A=(n:`疾病`)-[r]->(m) where n.name='"+entity+"'  RETURN n,type(r),m");
        	List  li = result.list();
        	
        	for(int i = 0;i<li.size();i++) {
        		Record record = (Record) li.get(i); 
        		JSONObject node = new JSONObject();
        		JSONObject link = new JSONObject();
        		if(record.get("m").get("conceptID").asString()!="null") {
        			//System.out.println(record.get("m").get("Termid")+"1");
        			node.put("id",Integer.parseInt(record.get("m").get("conceptID").asString()));
        			node.put("name",record.get("m").get("name").asString());
        			nodes.add(node);
        			link.put("source",record.get("n").get("conceptID").asString());
        			link.put("target",record.get("m").get("conceptID").asString());
        			link.put("value",record.get("type(r)").asString());
        			
        			links.add(link);
        		}
        		if(record.get("m").get("Termid").asString() != "null" ){
        			//System.out.println(record.get("m").get("Termid")+"2");
        			node.put("id",Integer.parseInt(record.get("m").get("Termid").asString()));
        			node.put("name",record.get("m").get("term").asString());
        			nodes.add(node);
        			link.put("source",record.get("n").get("conceptID").asString());
        			link.put("target",record.get("m").get("Termid").asString());
        			link.put("value",record.get("type(r)").asString());
        			links.add(link);
        		}
        		if(i ==li.size()-1) {
        		JSONObject node2 = new JSONObject();
        		node2.put("id",Integer.parseInt(record.get("n").get("conceptID").asString()));
        		node2.put("name",record.get("n").get("name").asString());
        		nodes.add(node2);
        		}
        	}
        	mydata.element("nodes",nodes);
    		mydata.element("links", links);
    		
        }catch(Exception ex) {
        	System.out.println(ex);
        }finally {
        	driver.close();
        }
		return mydata.toString();
    }
}