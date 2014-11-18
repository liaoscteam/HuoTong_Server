package AnalysisInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import net.sf.json.JSONObject;

public class Format {
   static String DATA_URL="jdbc:mysql://localhost/HuoTong";
   static String DATA_USER="root";
   static String DATA_PSW="liaosc";
   Statement sql;
   Connection connection;
   JSONObject return_json;           //将数据库操作执行情况,返回给客户端
   public Format()
   {
	   try{
		return_json=new JSONObject();
	   Class.forName("com.mysql.jdbc.Driver").newInstance();
	   connection=DriverManager.getConnection(DATA_URL,DATA_USER,DATA_PSW);
	   sql=connection.createStatement();
	   }catch(Exception e){
		   System.out.println("数据库未链接成功！"+e.toString());
	   }
   }
}
