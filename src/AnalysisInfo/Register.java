package AnalysisInfo;

import net.sf.json.JSONObject;

class register implements Json_Analysis{          //注册类
	public String Json_get(String json)
	{	
		JSONObject json_obj=new JSONObject().fromObject(json);
		DATA_Register data_re=new DATA_Register();
		try{
			data_re.Username(json_obj.getString("username"));
			data_re.Password(json_obj.getString("password"));
			data_re.Phone(json_obj.getString("phone"));
			data_re.Email(json_obj.getString("email"));
			data_re.Sex(json_obj.getString("sex"));
			data_re.Question(json_obj.getString("question"));
			data_re.Answer(json_obj.getString("answer"));
			data_re.Interest1(json_obj.getString("interest1"));
			data_re.Interest2(json_obj.getString("interest2"));
			data_re.Interest3(json_obj.getString("interest3"));
		}catch(Exception e){
			//  异常为未正确得到　json数据.
		}
		return data_re.return_info();      //调用函数向数据库写入，并返回处理数据
	}
}