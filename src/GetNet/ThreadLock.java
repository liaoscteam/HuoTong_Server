package GetNet;

import java.net.Socket;

public class ThreadLock {     //线程锁
    static synchronized void Add_Delete(String cmd,Socket socket,String username)
    {
    	  if(cmd.equals("add"))
    		  new ThreadLock().Add_user(socket, username);
    	  else 
    		  new ThreadLock().Delete_user();
    }
    private void Add_user(Socket socket,String username)
    {
	       UserList add=new UserList();
	       add.username=username;
	       add.socket=socket;
	       add.next=OnlineUser.first;
	       OnlineUser.first=add;
    }
    private void Delete_user()
    {
    	int sum=0;
    	if(OnlineUser.first==null) return;
		if(OnlineUser.first.next!=null)
			for(UserList last = null,mid=OnlineUser.first;mid!=null;last=mid,mid=mid.next)
			{
			 try{
			//	    System.out.println(mid.username);    //测试所用
					mid.socket.sendUrgentData(0xFF);
				}catch(Exception e){
		  //		System.out.println("DELETE "+mid.username);   //测试所用
					if(sum==0)
						OnlineUser.first=mid.next;
					else
					{
						last.next=mid.next;
					}
				}
			  sum++;
			}
		  System.gc();
    }
}
