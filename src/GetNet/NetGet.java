package GetNet;
import java.net.ServerSocket;
import java.net.Socket;

import AnalysisInfo.Analysis;

public class NetGet 
{
     ServerSocket server;
     Socket socket=null;
     public NetGet(int port,int backlog)
    {
		try
		{
		   server=new ServerSocket(port,backlog);
		}catch(Exception e)    //端口被占用
		{
			System.out.println("Can't create the Server  :");
		}
	}
   public  void ConnectOn()
     {
	     new CheckOnline().start();     //动态判断连接状态线程启动
    	 try {
    		for(;;)
    		{
			   socket=server.accept();
			   if(socket!=null)
			   new GetInf(socket).start();    /*创建新线程*/
    		}
		} catch (Exception e) {
		   System.out.println("The Socket is close!");
		}
     }
}

 class GetInf extends Thread
 {
	 Socket socket;
	 GetInf(Socket sockt)
	 {
		 socket=sockt;
	 }
	 public void run()
	 {
		 try{
			 socket.sendUrgentData(0xFF);   //判断链接是否有效
		 }catch(Exception e){
			 return;
		 }
		 new Analysis(socket).begin();
	 }
 }




