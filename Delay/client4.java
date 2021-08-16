import java.io.*;
import java.net.*;

class client4
{	
	public static Socket cs[]=new Socket[3];
	public static Socket soc,in1;
	public static boolean flag=true;

	public static void main(String ar[])
	{
		try
		{
			cs[0]=new Socket(InetAddress.getLocalHost(),4545);
			System.out.println("Client4 IS CONNECTED TO Network Manager:");
			cs[1]=new Socket(InetAddress.getLocalHost(),4002);
			System.out.println("client4 is connected to client2.");
			cs[2]=new Socket(InetAddress.getLocalHost(),4003);
			System.out.println("client4 is connected to client3.\n");
			
			ServerSocket s=new ServerSocket(4004);	
			in1=s.accept();
			
			new GetSignal4().start();						
			new ByPass4().start();					
		}			
		catch(Exception er)
		{
			System.out.println("error at :"+er);
		}	
	}
}

class GetSignal4 extends Thread
{
	private BufferedReader in;
	//private PrintWriter out;
	int i;
	PrintWriter outss;
	GetSignal4(){}
	
	public void run()
	{
	     try
	     {
		   outss= new PrintWriter(client4.in1.getOutputStream(),true);  
			   	
		   while(true)
		   {			
			in = new BufferedReader(new InputStreamReader(client4.cs[2].getInputStream()));				
	         	String mess=in.readLine();

			if(mess.equalsIgnoreCase("yes"))
				client4.flag=true;
			else if(mess.equalsIgnoreCase("no"))
				client4.flag=false;			

			else
			{
			       System.out.println("Message Recieved is:"+mess);
			       outss.println(mess);
			}
		   }
	      }
	      catch(Exception er){}
	}
}

class ByPass4 extends Thread
{
	private BufferedReader in;
//	private PrintWriter out;
	PrintWriter outss;
	int i;

	ByPass4(){}

	public void run()
	{
	    try
	    {
		outss= new PrintWriter(client4.in1.getOutputStream(),true);  
		while(true)
		{			
			in=new BufferedReader(new InputStreamReader(client4.cs[1].getInputStream()));					
			String mess=in.readLine();			
			System.out.println("Message Recieved is:"+mess);			
			outss.println(mess);
		}
		  
	    }
	    catch(Exception e1){}
	}
}
