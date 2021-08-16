import java.io.*;
import java.net.*;
import java.lang.*;

class client3
{
	
	public static ServerSocket ss;
	public static Socket cs[]=new Socket[5];
	public static Socket soc;
	public static boolean flag=true;

	public static void main(String ar[])
	{
		try
		{
			cs[0]=new Socket(InetAddress.getLocalHost(),4545);
			System.out.println("Client3 IS CONNECTED TO NetWork Manager:");
			cs[1]=new Socket(InetAddress.getLocalHost(),4000);
			System.out.println("client3 is connected to client.\n");
			cs[3]=new Socket(InetAddress.getLocalHost(),4001);
			System.out.println("client3 is connected to client1.\n");
			cs[4]=new Socket(InetAddress.getLocalHost(),4002);
			System.out.println("client3 is connected to client2.\n");
			ss=new ServerSocket(4003);			
			cs[2]=ss.accept();			

			new SendSignal3().start();						
			new ByPass3();			
		}			
		catch(Exception er)
		{
			System.out.println("error at :"+er);
		}	
	}
}

class SendSignal3 extends Thread
{
	private BufferedReader in;
	private PrintWriter out;
	
	SendSignal3(){}
	
	public void run()
	{
		try
		{
		   while(true)
		   {
			System.out.println("Type in/out for mobile to be within range or out of range"); 
			in=new BufferedReader(new InputStreamReader(System.in));
	         	String mess=in.readLine();
			if(mess.equalsIgnoreCase("in"))
			{
				mess="yes";
				client3.flag=true;
			}
			else
			{
				mess="no";
				client3.flag=false;
			}
			
			for(int i=0;i<3;i++)
			{
				out=new PrintWriter(client3.cs[i].getOutputStream(),true); 
				out.println(mess);
				
			}
		   }
		}
		catch(Exception er){}
	}
}

class ByPass3 
{
	private BufferedReader in;
	private PrintWriter out;
//	Send send;
//Receive receive;
	

	ByPass3()
	{
	    try
	    {
		  while(true)
		  {	
			if(client3.flag)
			{				
				in=new BufferedReader(new InputStreamReader(client3.cs[1].getInputStream()));					
				String mess=in.readLine();			
				out=new PrintWriter(client3.cs[2].getOutputStream(),true); 
				out.println(mess);
				System.out.println("Message Recieved is:"+mess);
			}
		  }
	    }
	    catch(Exception e1){}
	}
}

