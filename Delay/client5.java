import java.io.*;
import java.net.*;
import java.lang.*;

class client5{
        public static ServerSocket ss;
	public static Socket cs[]=new Socket[3];
	public static Socket soc;
	
	
	public static void main(String ar[]){
		try{
			cs[0]=new Socket(InetAddress.getLocalHost(),4545);
			System.out.println("client5 IS CONNECTED TO Network Manager:");
			cs[1]=new Socket(InetAddress.getLocalHost(),4000);
			System.out.println("client5 is connected to client.\n");

			ss=new ServerSocket(4005);			
			cs[2]=ss.accept();
			
			new SendSignal5().start();
						
			new ByPass5().start();							
			
		}catch(Exception er)	{System.out.println("error at :"+er);}	
	}
}

class SendSignal5 extends Thread {
	private BufferedReader in;
	private PrintWriter out;
	
	SendSignal5(){}
	
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
			for(int i=0;i<3;i++)	{

				out=new PrintWriter(client5.cs[i].getOutputStream(),true); 
				out.println(mess);

			}
		   }
		} catch(Exception er){}
	}
}

class ByPass5 extends Thread {

	private BufferedReader in;
	private PrintWriter out;
	//Send send;
	//Receive receive;
	ByPass5(){}

	public void run(){
	    try    {
		while(true){			
			in=new BufferedReader(new InputStreamReader(client5.cs[1].getInputStream()));					
			String mess=in.readLine();			
			out=new PrintWriter(client5.cs[2].getOutputStream(),true); 
			out.println(mess);
			System.out.println("Message Recieved :"+mess);
		}
	    }    catch(Exception e1){}
      }
}