package com.example.demo;

import java.net.URLEncoder;
import java.util.List;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sourceforge.pinyin4j.PinyinHelper;

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

public interface GetList{
	@RequestMapping(value = "/list",method= {RequestMethod.GET,RequestMethod.POST})
	@CrossOrigin("http://localhost:8080")
	static String getList()  {
		String url = "bolt://localhost:7687";
		JSONObject data = new JSONObject();
		JSONArray[] mydata = new JSONArray[27];
		for(int j = 0;j<27;j++) {
			mydata[j] = new JSONArray();
		}
		
        Driver driver =GraphDatabase.driver(url,AuthTokens.basic("neo4j","991205"));
        try(Session session = driver.session()){
        	
        	Result result = session.run(" MATCH (n:`疾病`)   RETURN n.name  limit 1200");
        	List  li = result.list();
        	for(int i = 0;i<li.size();i++) {
        		Record record = (Record) li.get(i); 
        		JSONObject nodes = new JSONObject();
        		String res = record.get("n.name").asString();
        		nodes.put("label",res);
        		System.out.println(nodes.toString());
        		char temp = res.charAt(0);
        		System.out.println(temp);
        		char temp2;
        		byte[] buffer=String.valueOf(temp).getBytes("UTF-8");
        		byte[] buffer_2=String.valueOf(temp).getBytes("GBK");
        		System.out.println(buffer);
        		//if(temp!='Ⅰ'&&temp!='Ⅱ'&&temp!='Ⅲ'&&temp!='Ⅳ'
        			//	&&temp!='Ⅴ'&&temp!='Ⅵ'&&temp!='Ⅶ'&&temp!='Ⅷ'&&temp!='Ⅸ'&&temp!='Ⅹ'
        				//&&temp>='z'&&temp<='a'&&temp>='Z'&&temp<='A'){
        		if( '\u4e00' <= temp&&temp <= '\u9fff') {
        		String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(temp);
        		System.out.println(pinyinArray[0].charAt(0));
        		temp2 = pinyinArray[0].charAt(0);
        		}
        		else {
        			temp2=temp;
        		}
        		switch(temp2){
        		case 'A':{mydata[0].add(nodes);break;}
        		case 'B':{mydata[1].add(nodes);break;}
        		case	'C':{mydata[2].add(nodes);break;}
        		case	'D':{mydata[3].add(nodes);break;}
        		case	'E':{mydata[4].add(nodes);break;}
        		case	'F':{mydata[5].add(nodes);break;}
        		case	'G':{mydata[6].add(nodes);break;}
        		case	'H':{mydata[7].add(nodes);break;}
        		case	'I':{mydata[8].add(nodes);break;}
        		case	'J':{mydata[9].add(nodes);break;}
        		case	'K':{mydata[10].add(nodes);break;}
        		case	'L':{mydata[11].add(nodes);break;}
        		case	'M':{mydata[12].add(nodes);break;}
        		case	'N':{mydata[13].add(nodes);break;}
        		case	'O':{mydata[14].add(nodes);break;}
        		case	'P':{mydata[15].add(nodes);break;}
        		case	'Q':{mydata[16].add(nodes);break;}
        		case	'R':{mydata[17].add(nodes);break;}
        		case	'S':{mydata[18].add(nodes);break;}
        		case	'T':{mydata[19].add(nodes);break;}
        		case	'U':{mydata[20].add(nodes);break;}
        		case	'V':{mydata[21].add(nodes);break;}
        		case	'W':{mydata[22].add(nodes);break;}
        		case	'X':{mydata[23].add(nodes);break;}
        		case	'Y':{mydata[24].add(nodes);break;}
        		case	'Z':{mydata[25].add(nodes);break;}	
        		case 'a':{mydata[0].add(nodes);break;}
        		case 'b':{mydata[1].add(nodes);break;}
        		case	'c':{mydata[2].add(nodes);break;}
        		case	'd':{mydata[3].add(nodes);break;}
        		case	'e':{mydata[4].add(nodes);break;}
        		case	'f':{mydata[5].add(nodes);break;}
        		case	'g':{mydata[6].add(nodes);break;}
        		case	'h':{mydata[7].add(nodes);break;}
        		case	'i':{mydata[8].add(nodes);break;}
        		case	'j':{mydata[9].add(nodes);break;}
        		case	'k':{mydata[10].add(nodes);break;}
        		case	'l':{mydata[11].add(nodes);break;}
        		case	'm':{mydata[12].add(nodes);break;}
        		case	'n':{mydata[13].add(nodes);break;}
        		case	'o':{mydata[14].add(nodes);break;}
        		case	'p':{mydata[15].add(nodes);break;}
        		case	'q':{mydata[16].add(nodes);break;}
        		case	'r':{mydata[17].add(nodes);break;}
        		case	's':{mydata[18].add(nodes);break;}
        		case	't':{mydata[19].add(nodes);break;}
        		case	'u':{mydata[20].add(nodes);break;}
        		case	'v':{mydata[21].add(nodes);break;}
        		case	'w':{mydata[22].add(nodes);break;}
        		case	'x':{mydata[23].add(nodes);break;}
        		case	'y':{mydata[24].add(nodes);break;}
        		case	'z':{mydata[25].add(nodes);break;}	
        		default:{mydata[26].add(nodes);break;}
        		}	
        	}
        	data.element("A",mydata[0]);
        	data.element("B",mydata[1]);
        	data.element("C",mydata[2]);
        	data.element("D",mydata[3]);
        	data.element("E",mydata[4]);
        	data.element("F",mydata[5]);
        	data.element("G",mydata[6]);
        	data.element("H",mydata[7]);
        	data.element("I",mydata[8]);
        	data.element("J",mydata[9]);
        	data.element("K",mydata[10]);
        	data.element("L",mydata[11]);
        	data.element("M",mydata[12]);
        	data.element("N",mydata[13]);
        	data.element("O",mydata[14]);
        	data.element("P",mydata[15]);
        	data.element("Q",mydata[16]);
        	data.element("R",mydata[17]);
        	data.element("S",mydata[18]);
        	data.element("T",mydata[19]);
        	data.element("U",mydata[20]);
        	data.element("V",mydata[21]);
        	data.element("W",mydata[22]);
        	data.element("X",mydata[23]);
        	data.element("Y",mydata[24]);
        	data.element("Z",mydata[25]);
        	data.element("#",mydata[26]);
        	
        }catch(Exception ex) {
        	System.out.println(ex);
        	
        }finally {
        	driver.close();
        }
		return data.toString();
	}
	
	
	
}
