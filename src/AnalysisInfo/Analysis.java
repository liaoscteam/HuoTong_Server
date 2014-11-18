package AnalysisInfo;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import GetNet.OnlineUser;

import net.sf.json.JSONObject;

public class Analysis {      //分析数据入口，负责返回给客户端相应错误信息。
	 Socket socket;
	 InputStream in;
	 OutputStream out;
    public Analysis(Socket sockt)
    {
    	socket=sockt;
    	try{
    	in=socket.getInputStream();
    	out=socket.getOutputStream();
    	}catch(Exception e){
    		/* 这个异常不好处理*/
    		/*处理代码*/
    	}
    }
    public void begin()
    {
    	ObjectInputStream object_in;
    	ObjectOutputStream object_out;
    	String str_in;
    	String str_out;
    	String str;
    	String sava_name;                           //储存链接人数据
    	try {
             object_in=new ObjectInputStream(in);
             object_out=new ObjectOutputStream(out);
             
             object_out.writeObject(new String("You have already connected the HuoTong App,thank you"));    /*用做测试所用*/
             /*测试链接所用*/
   
             str_in=(String)object_in.readObject();
             str=str_in;
             JSONObject json=(new JSONObject()).fromObject(str_in);
       try{
             str_in=json.getString("post");                                //读取请求类型。
             sava_name=json.getString("userid");
             }catch(Exception e)                                              //接受到错误请求
            {
                 return;
            }
             OnlineUser.Add_user(socket, sava_name);       //存入连接用户
             
             str_out=new JSON().begin(str_in,str);                //开始处理发来的请求    //获取需要向客户端传递的信息。
              try{
           	  object_out.writeObject(str_out);
              }catch(Exception e){
            	    return;
              }
		} catch (Exception e) {    
			
		}
    }
}
