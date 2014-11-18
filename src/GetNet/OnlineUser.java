package GetNet;

import java.net.Socket;

public class OnlineUser {
	static UserList first=null;
    static  public void Add_user(Socket socket,String username)   //在线用户链表
           {
    	         ThreadLock.Add_Delete("add", socket, username);
           }
}

class UserList{
	String username;
	Socket socket;
    UserList next=null;
}

class CheckOnline extends Thread{    //清空失去连接用户
	public void run()
  {
	for(;;)
	 {
		ThreadLock.Add_Delete("delete", null, null);
	try {
			sleep(5000);
		} catch (InterruptedException e) {
			 //进程无法休眠
		  }
	   }
	}
}
