import java.io.*;
import java.net.*;
import java.lang.*;

class client2
{
	public static ServerSocket ss;	
	public static Socket cs[]=new Socket[3];
	public static Socket soc;
	public static boolean flag=true;	
	

	public static void main(String args[])
	{
		try
		{
			cs[0]=new Socket(InetAddress.getLocalHost(),4545);
			System.out.println("Client2 IS CONNECTED TO Network Manager:");
			cs[1]=new Socket(InetAddress.getLocalHost(),4001);
			System.out.println("client2 is connected to client1.");

			ss=new ServerSocket(4002);			
			cs[2]=ss.accept();				
						
			new ByPass2();			
		}			
		catch(Exception er)
		{
			System.out.println("error at :"+er);
		}	
	}
}

class ByPass2
{
	private BufferedReader in;
	private PrintWriter out;
	
	ByPass2()	
	{
	    try
	    {
		   while(true)
		   {			
			in=new BufferedReader(new InputStreamReader(client2.cs[1].getInputStream()));					
			String mess=in.readLine();

			if(mess.equalsIgnoreCase("yes"))
				client2.flag=true;
			else if(mess.equalsIgnoreCase("no"))
				client2.flag=false;
			else			
			{								
				out=new PrintWriter(client2.cs[2].getOutputStream(),true); 
				out.println(mess);
				System.out.println("Message Recieved is:"+mess);
				
			}
		   }
	     }
	     catch(Exception e1){}
	}
}