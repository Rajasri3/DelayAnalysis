import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.io.*;
import java.io.*;
import java.util.*;


public class Reciever1 extends MIDlet
{
	static protected Display display;
	protected Displayable displayable;

	Form form1;
	Ticker tick1;
	
	//Form form2;
	//Ticker tick1;

	GetMessage gm;

	public Reciever1()
	{
		display = Display.getDisplay(this);

		form1=new Form("WELCOME TO CHAT");
		tick1=new Ticker("YOU ARE CONNECTED");
		gm=new GetMessage();
	}

	public void startApp()
	{
		try
		{		
			display.setCurrent(form1);
			form1.setTicker(tick1);
			gm.start();		
		}
		catch(Exception ex)
		{		
			//System.out.println("Exeption in start"+ex);
    		}    		
	}	

	public void pauseApp(){}

	public void destroyApp(boolean unconditional) 
	{
		display = null;
		displayable = null;
	}
}

class GetMessage extends Thread
{
	StreamConnection stream1;
	PrintStream out1;
	InputStream in1;

	public void run()
	{
		try
		{
			stream1 = (StreamConnection) Connector.open("socket://localhost:4500");
			out1 = new PrintStream(stream1.openOutputStream());
			in1 = stream1.openInputStream();	
			System.out.println("Connected");
			
		}
		catch(Exception ex)
		{
			//System.out.println("In Thread:"+ex);
		}

		while(true)
		{
			try
			{
				byte b[]=new byte[100];
				System.out.println("Iam waiting");

				int w=in1.read(b);				

				String type1=new String(b,0,w);				

				String from=type1.trim();

				Alert currentAlert = new Alert("Message For You");
				currentAlert.setTimeout(5000);
				        
			    
					 
			   	currentAlert.setString("From:"+from+"\n");
				currentAlert.setType(AlertType.INFO);
			 	Reciever1.display.setCurrent(currentAlert);
                  
				System.out.println("From:"+from);
				StringToken token = new StringToken(from.trim(),",");
			   from=SECURE1.encmsg(token.nextToken(),"hello");
			long sender_time=System.currentTimeMillis()/1000;
		    long receiver_time=System.currentTimeMillis();							
		    double delay=((double)(receiver_time-sender_time)/1000);
		    System.out.println("Message delay is:"+delay);
		    
			}catch(Exception ex){}
		}
	}
}
class SECURE1
{

//ENCRYPTION ALGORITHM
 
static char en(char plainchar,String passs)
	{
//plain Text
String PT="";
String pass=passs;
	char pctext=plainchar;
	System.out.println("Plain Text:  "+pctext);	
	int ptext=(int)pctext;

	System.out.println("Plain Text (Integer type):  "+ptext);	
	String ptb=Integer.toBinaryString(ptext);
	System.out.println("Plain Text (Binary):  "+ptb);	
	System.out.println(Integer.valueOf(ptb));			
	if(ptb.length()<8)
	{
	int zl=8-ptb.length();

	//8 bit format of Pl Text

		for(int i=0;i<zl;i++)
	 	{
		PT=PT.concat("0");
		}
	PT=PT.concat(ptb);
	System.out.println("Plain Text ( 8 bit Binary):  "+PT);	
	}

//32 bit of assword
	System.out.println("pass Start");
	System.out.println("PassWord Text :  "+pass);	
	String Pass="";
	for(int i=0;i<pass.length();i++)
	{
	int pa=(int)pass.charAt(i);
//
	
		String passb=Integer.toBinaryString(pa);
		if(passb.length()<8)
		{
		int zl=8-passb.length();

			String passch="";
			for(int j=0;j<zl;j++)
		 	{
			passch=passch.concat("0");
			}
			passch=passch.concat(passb);
			System.out.println(pass.charAt(i)+"="+pa+"="+passch);
			Pass=Pass.concat(passch);

		}
		
	System.out.println("PassWord Text ( Binary):  "+Pass);	
	
	}
	System.out.println("PassWord Text (32 Bit Binary):  "+Pass);	

// Derive the Leaders (L1 to L16) from the Password.	
		System.out.println("Derive the Leaders (L1 to L16) from the Password");	
		 Hashtable leader = new Hashtable();
		 int  j=1;		
		for(int i=0;i<Pass.length();i++)
		{
		String Leader=Pass.substring(i,i+2);

		System.out.println("Leader"+j+"="+Leader);
		leader.put("L"+j, Leader	);

		//System.out.println(Pass.charAt(i)+"="+pa);	
		j++;
		i++;
		}
		//System.out.println("L1="+leader.get("L16"));	

//test xor opration			
			String aaa=(String)leader.get("L14");
			String bbb=(String)leader.get("L15");
			int aa=Integer.valueOf(aaa).intValue() ^ Integer.valueOf(bbb).intValue();
			System.out.println(aa );
			
//Encryption
	System.out.println("Encryption start");
	System.out.println("PT="+PT);
	
//
for(int k=1;k<17;k++)
{
String xorout="";
		String ftwo=PT.substring(0,2);
		//System.out.println(leader.get("L"+k));
		int xop=Integer.valueOf(ftwo).intValue() ^ Integer.valueOf((String)leader.get("L"+k)).intValue();
		String sbit=String.valueOf(xop);
		if(sbit.length()==1)
		{

		
			if(sbit.equals("0"))
			{

			sbit=sbit.concat("0");	

			}
			else
			{
			sbit="01";

			}

		xop=Integer.valueOf(sbit).intValue();
		
		}
System.out.println(xop+"   "+sbit);

		//xorout=xorout.concat(String.valueOf(xop));
		xorout=xorout.concat(sbit);
		System.out.println(xorout);
		
		
		for(int i=2;i<PT.length();i++)
		{
		xop=xop ^ Integer.valueOf(PT.substring(i,i+2)).intValue();
		//System.out.println(xop);
		System.out.println(String.valueOf(xop));
		sbit=String.valueOf(xop);
		if(sbit.length()==1)
		{

		
			if(sbit.equals("0"))
			{

			sbit=sbit.concat("0");	

			}
			else
			{
			sbit="01";

			}

		xop=Integer.valueOf(sbit).intValue();
		
		}


		//xorout=xorout.concat(String.valueOf(xop));
		xorout=xorout.concat(sbit);
		i++;
		}
	PT=xorout;
	// GENERATED 7bit binary
	System.out.println(xorout);
	String XOROUT="";
	if(xorout.length()<8)
	{
	int zl=8-xorout.length();

		for(int i=0;i<zl;i++)
	 	{
		XOROUT=XOROUT.concat("0");
		}
	XOROUT=XOROUT.concat(xorout);
	PT=XOROUT;
	System.out.println("Enrp Text ( 8 bit Binary) Rotation "+k +"th:"+PT);	
	}
   }
System.out.println("Cyper  Text  ="+ PT);
System.out.println("Cyper  Text ( int format) ="+Integer.parseInt(PT,2) );
System.out.println("Cyper  Text ( char) ="+(char)Integer.parseInt(PT,2) );	
return (char)Integer.parseInt(PT,2);
}


//Decryption
static char de(char cyperchar,String passs)
	{
//plain Text

int cyper=(int)cyperchar;

String PT="";
String pass=passs;
	String ptb=Integer.toBinaryString(cyper);
	if(ptb.length()==8)
	{
	PT=ptb;
	}
	if(ptb.length()<8)
	{
	int zl=8-ptb.length();

	//8 bit format of cyper Text

		for(int i=0;i<zl;i++)
	 	{
		PT=PT.concat("0");
		}
	PT=PT.concat(ptb);
	//System.out.println("Plain Text ( 8 bit Binary):  "+PT);	
	}
	
//32 bit of assword
	System.out.println("pass Start");
	
	System.out.println("PassWord Text :  "+pass);	
	String Pass="";
	for(int i=0;i<pass.length();i++)
	{
	int pa=(int)pass.charAt(i);
//
	
		String passb=Integer.toBinaryString(pa);
		if(passb.length()<8)
		{
		int zl=8-passb.length();

			String passch="";
			for(int j=0;j<zl;j++)
		 	{
			passch=passch.concat("0");
			}
			passch=passch.concat(passb);
			System.out.println(pass.charAt(i)+"="+pa+"="+passch);
			Pass=Pass.concat(passch);

		}
		
	System.out.println("PassWord Text ( Binary):  "+Pass);	
	
	}
	System.out.println("PassWord Text (32 Bit Binary):  "+Pass);	

// Derive the Leaders (L1 to L16) from the Password.	
		
		System.out.println("Derive the Leaders (L1 to L16) from the Password");	
		Hashtable leader = new Hashtable();
		int  j=1;		
		for(int i=0;i<Pass.length();i++)
		{
		String Leader=Pass.substring(i,i+2);

		System.out.println("Leader"+j+"="+Leader);
		leader.put("L"+j, Leader	);

		//System.out.println(Pass.charAt(i)+"="+pa);	
		j++;
		i++;
		}
		//System.out.println("L1="+leader.get("L16"));	

//test xor opration			
			String aaa=(String)leader.get("L14");
			String bbb=(String)leader.get("L15");
			int aa=Integer.valueOf(aaa).intValue() ^ Integer.valueOf(bbb).intValue();
			System.out.println(aa );
			
//decryption
	System.out.println("decryption start");
	System.out.println("PT="+PT);
	
//
for(int k=16;k>0;k--)
{


String xorout="";
		String ftwo=PT.substring(0,2);
		//System.out.println(leader.get("L"+k));
		int xop=Integer.valueOf(ftwo).intValue() ^ Integer.valueOf((String)leader.get("L"+k)).intValue();
		String sbit=String.valueOf(xop);
		if(sbit.length()==1)
		{

		
			if(sbit.equals("0"))
			{

			sbit=sbit.concat("0");	

			}
			else
			{
			sbit="01";

			}

		xop=Integer.valueOf(sbit).intValue();
		}
System.out.println(sbit);


		//xorout=xorout.concat(String.valueOf(xop));
		xorout=xorout.concat(sbit);
		//System.out.println(xorout);
				
		for(int i=2;i<PT.length();i++)
		{
		xop=Integer.valueOf(PT.substring(i-2,i)).intValue()^Integer.valueOf(PT.substring(i,i+2)).intValue();
		//System.out.println(xop);
		//System.out.println(String.valueOf(xop));
		sbit=String.valueOf(xop);
		//System.out.println(sbit);
		if(sbit.length()==1)
		{

		
			if(sbit.equals("0"))
			{

			sbit=sbit.concat("0");	

			}
			else
			{
			sbit="01";

			}

		xop=Integer.valueOf(sbit).intValue();
		}
System.out.println(sbit);

		xorout=xorout.concat(sbit);
		i++;
		}
	// GENERATED 7bit binary
PT=xorout;

		  System.out.println(xorout);
	String XOROUT="";
	if(xorout.length()<8)
	{
	int zl=8-xorout.length();

		for(int i=0;i<zl;i++)
	 	{
		XOROUT=XOROUT.concat("0");
		}
	XOROUT=XOROUT.concat(xorout);
	System.out.println("Enrp Text ( 8 bit Binary) Rotation "+k +"th:"+XOROUT);	
	PT=XOROUT;
	}
   }
System.out.println(" Original text(binary) ="+ PT);
System.out.println("Original text(int) ="+Integer.parseInt(PT,2) );
System.out.println("Original text(Char) ="+(char)Integer.parseInt(PT,2) );	
return (char)Integer.parseInt(PT,2);
}
static String encmsg( String msg,String password)
{
String MSG=msg;
String Emsg="";
int msglen=MSG.length();
char msgc[]=new char[msglen];
	for(int i=0;i<msglen;i++)
	{
	msgc[i]=SECURE1.en(MSG.charAt(i),password);	
	}
MSG=new String(msgc);
return MSG;
}
static String decmsg( String msg,String password)
{
String MSG=msg;
String Emsg="";
int msglen=MSG.length();
char msgc[]=new char[msglen];
	for(int i=0;i<msglen;i++)
	{
	msgc[i]=SECURE1.de(MSG.charAt(i),password);	
	}
MSG=new String(msgc);
return MSG;
}
}