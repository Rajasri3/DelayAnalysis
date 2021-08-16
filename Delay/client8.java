import java.io.*;
import java.net.*;
import java.lang.*;

class client8{
        public static ServerSocket ss;
	public static Socket cs[]=new Socket[4];
	public static Socket soc;
	
	
	public static void main(String ar[])
	{
		try{
			cs[0]=new Socket(InetAddress.getLocalHost(),4545);
			System.out.println("client8 IS CONNECTED TO Network Manager:");
			cs[1]=new Socket(InetAddress.getLocalHost(),4006);
			System.out.println("client8 is connected to client.\n");
			cs[3]=new Socket(InetAddress.getLocalHost(),4007);
			System.out.println("client8 is connected to client7.\n");
			ss=new ServerSocket(4008);			
			cs[2]=ss.accept();
			
			new SendSignal8().start();
						
			new ByPass8().start();							
			
		}catch(Exception er)	{System.out.println("error at :"+er);}	
	}
}

class SendSignal8 extends Thread {
	private BufferedReader in;
	private PrintWriter out;
	
	SendSignal8(){}
	
	public void run(){
		try{
		   while(true)	   {
			System.out.println("Type in/out for mobile to be within range or out of range"); 
			in=new BufferedReader(new InputStreamReader(System.in));
	         	String mess=in.readLine();
			if(mess.equalsIgnoreCase("in"))
				mess="yes";
			else
				mess="no";
			for(int i=0;i<4;i++)	{

				out=new PrintWriter(client8.cs[i].getOutputStream(),true); 
				out.println(mess);

			}
		   }
		} catch(Exception er){}
	}
}

class ByPass8 extends Thread {

	private BufferedReader in;
	private PrintWriter out;
	//Send send;
	//Receive receive;
	ByPass8(){}

	public void run(){
	    try    {
		while(true){			
			in=new BufferedReader(new InputStreamReader(client8.cs[1].getInputStream()));					
			String mess=in.readLine();			
			out=new PrintWriter(client8.cs[2].getOutputStream(),true); 
			out.println(mess);
			System.out.println("Message Recieved :"+mess);
		}
	    }    catch(Exception e1){}
      }
}