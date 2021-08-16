import java.io.*;
import java.net.*;

class client9
{	
	public static Socket cs[]=new Socket[5];
	public static Socket soc,in1;
	public static boolean flag=true;

	public static void main(String ar[])
	{
		try
		{
			cs[0]=new Socket(InetAddress.getLocalHost(),4545);
			System.out.println("Client9 IS CONNECTED TO Network Manager:");
			cs[1]=new Socket(InetAddress.getLocalHost(),4003);
			System.out.println("client9 is connected to client3.");
			cs[2]=new Socket(InetAddress.getLocalHost(),4004);
			System.out.println("client9 is connected to client4.\n");
			cs[3]=new Socket(InetAddress.getLocalHost(),4007);
			System.out.println("client9 is connected to client7.\n");
			cs[4]=new Socket(InetAddress.getLocalHost(),4008);
			System.out.println("client9 is connected to client8.\n");
			
			ServerSocket s=new ServerSocket(4500);	
			in1=s.accept();
			
			new GetSignal9().start();						
			new ByPass9().start();					
		}			
		catch(Exception er)
		{
			System.out.println("error at :"+er);
		}	
	}
}

class GetSignal9 extends Thread
{
	private BufferedReader in;
	//private PrintWriter out;
	int i;
	PrintWriter outss;
	GetSignal9(){}
	
	public void run()
	{
	     try
	     {
		   outss= new PrintWriter(client9.in1.getOutputStream(),true);  
			   	
		   while(true)
		   {			
			in = new BufferedReader(new InputStreamReader(client9.cs[2].getInputStream()));				
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

class ByPass9 extends Thread
{
	private BufferedReader in;
//	private PrintWriter out;
	PrintWriter outss;
	int i;

	ByPass9(){}

	public void run()
	{
	    try
	    {
		outss= new PrintWriter(client9.in1.getOutputStream(),true);  
		while(true)
		{			
			in=new BufferedReader(new InputStreamReader(client9.cs[1].getInputStream()));					
			String mess=in.readLine();			
			System.out.println("Message Recieved is:"+mess);			
			outss.println(mess);
		}
		  
	    }
	    catch(Exception e1){}
	}
}
