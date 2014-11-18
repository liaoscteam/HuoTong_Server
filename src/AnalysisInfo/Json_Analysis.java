package AnalysisInfo;

import java.util.HashMap;
import java.util.Map;

interface Json_Analysis {                          //接口
     String Json_get(String json);
}


class JSON{                                                 //用map 获取处理对象
	static Map map=new HashMap();
	JSON()
	{
		map.put("register", new register());
		map.put("add", new Add());
		map.put("connect", new Connect());
		map.put("login", new Login());
		map.put("publish", new Publish());
		map.put("title", new Title());
		map.put("userinfo", new Userinfo());
	}
	String begin(String value,String json)
	{
		Json_Analysis js_analysis;
		js_analysis=(Json_Analysis) map.get(value);    //从map中获取子类对象
		return js_analysis.Json_get(json);                    //多态
	}
}
