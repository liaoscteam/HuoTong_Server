import GetNet.NetGet;


public class MainService
{
	NetGet net;
	public MainService(int port,int backlog)
	{
		net=new NetGet(port,backlog);
	}
	public static void main(String[] args) 
	{
		MainService ms=new MainService(8888,20000);
	    ms.net.ConnectOn();
	}

}
