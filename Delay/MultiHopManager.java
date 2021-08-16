import java.awt.*;
import java.applet.*;
import java.awt.event.*;
//import javax.swing.*;
import java.net.*;
import java.io.*;

//<applet code="MultiHopManager" height=800 width=800> </applet>

public class MultiHopManager extends Applet implements ActionListener
{	
	String msg;	
	int i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16;
	Button but1;
	Button but2;
	Button but3;
	Container con; 
	TextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16;
	int s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12;
	Label l1;
	Label l2;
	Label l3;
	Label l4;
	Label l5;
	Label l6;
	Label l7;
	Label l8;
	Label l9;
	Label l10;	
	Label l11;
	Label l12;
	Label l13;
	Label l14;
	Label l15;
	Label l16;

	Font f=new Font("SansSerif",Font.BOLD, 30);
	Font f1=new Font("SansSerif",Font.BOLD, 10);
	Font f2=new Font("SansSerif",Font.BOLD, 20);
	Font f3=new Font("SansSerif",Font.BOLD, 12);
	public static Socket cs[]=new Socket[10];
	public static ServerSocket ss;
	public static PrintWriter pw;
	public static String mobile[]=new String[10];
	
	String tree="";
	
	public void init()
	{		
		setBackground(new Color(210,100,100));		
		setSize(1000,600);
		setLayout(null);
		repaint();
		
		l1=new Label("d1(c-c1)     :");
		l2=new Label("d2(c1-c2)   :");
		l3=new Label("d3(c1-c3)   :");
		l4=new Label("d4(c2-c4)   :");
		l5=new Label("d5(c-c5)     :");
		l6=new Label("d6(c5-c6)   :");
		l7=new Label("d7(c3-c7)   :");
		l8=new Label("d8(c6-c8)   :");
		l9=new Label("d9(c8-c9)   :");
		l10=new Label("d10(c-c3)   :");
		l11=new Label("d11(c7-c8):");
		l12=new Label("d12(c2-c3):");
		l13=new Label("d13(c3-c4):");		
		l14=new Label("d14(c3-c9):");
		l15=new Label("d15(c7-c9):");
		l16=new Label("d16(c4-c9):");	
		
		setFont(f3);
		setForeground(Color.BLACK);
		
		
		l1.setBounds(500, 250, 80, 30) ;
		l2.setBounds(500, 270, 80,30);
		l3.setBounds(500, 290, 80,30);
		l4.setBounds(500, 310, 80,30);
		l5.setBounds(500, 330, 80,30);
		l6.setBounds(500, 350, 80,30);
		l7.setBounds(500, 370, 80,30);
		l8.setBounds(500, 390, 80,30);
		l9.setBounds(500, 410, 80,30);
		l10.setBounds(500, 430, 80,30);
		l11.setBounds(500, 450, 80,30);
		l12.setBounds(500, 470, 80,30);
		l13.setBounds(500, 490, 80,30);
		l14.setBounds(500, 510, 80,30);
		l15.setBounds(500, 530, 80,30);
		l16.setBounds(500, 550, 80,30);
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(l10);
		add(l11);
		add(l12);
		add(l13);
		add(l14);
		add(l15);
		add(l16);
		
		t1=new TextField();
		t2=new TextField();
		t3=new TextField();
		t4=new TextField();
		t5=new TextField();
		t6=new TextField();
		t7=new TextField();
		t8=new TextField();
		t9=new TextField();
		t10=new TextField();
		t11=new TextField();
		t12=new TextField();
		t13=new TextField();
		t14=new TextField();
		t15=new TextField();
		t16=new TextField();
		
		
		add(t1);
		t1.addActionListener(this);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(t6);
		add(t7);
		add(t8);
		add(t9);
		add(t10);
		add(t11);
		add(t12);
		add(t13);
		add(t14);
		add(t15);
		add(t16);
	

	    t1.setBounds(650, 250, 50, 20) ;
		t2.setBounds(650, 270, 50,20);
		t3.setBounds(650, 290, 50,20);
		t4.setBounds(650, 310, 50,20);
		t5.setBounds(650, 330, 50,20);
		t6.setBounds(650, 350, 50,20);
		t7.setBounds(650, 370, 50,20);
		t8.setBounds(650, 390, 50,20);
		t9.setBounds(650, 410, 50,20);
		t10.setBounds(650, 430, 50,20);
		t11.setBounds(650, 450, 50,20);
		t12.setBounds(650, 470, 50,20);
		t13.setBounds(650, 490, 50,20);
		t14.setBounds(650, 510, 50,20);
		t15.setBounds(650, 530, 50,20);
		t16.setBounds(650, 550, 50,20);

		but1=new Button(" Start Network Manager ");
		but1.setBounds(30,300,150,30);
	    add(but1);
		but1.addActionListener(this);

		but2=new Button(" Node Mapping ");
		but2.setBounds(200,300,100,30);
		but2.setVisible(false);
		add(but2);		
		but2.addActionListener(this);		
		
		// but3=new Button(" Routing Analysis ");
		// but3.setBounds(270,400,110,30);
		// but3.setVisible(true);
		// add(but3);		
		// but3.addActionListener(this);	
		
		
	}	

	public void paint(Graphics g)
	{

		if(mobile[0].equals("yes"))
		{
			g.setFont(f1);	
			g.drawString("C (SOURCE)",120,100);			
	 		g.fillOval(100,100,20,20);
		}
		
		if(mobile[1].equals("yes"))
		{	
			g.setFont(f1);	
			g.drawString("C1",30,150);		
	 		g.fillOval(50,150,20,20);			
		}

		if(mobile[2].equals("yes"))
		{	
			g.setFont(f1);
			g.drawString("C2",50,230);			
	 		g.fillOval(70,200,20,20);
			g.setFont(f2);
			if(!mobile[3].equals("yes"))
			{
				//g.drawString("PACKETS ROUTING THRO",500,600);	
				 s1=i5+i6+i8+i9;
				 s2=i10+i7+i11+i8+i9;
				 s3=i10+i7+i15;
				 s4=i10+i14;
				 s5=i10+i13+i16;
				 s6=i10+i12+i4+16;
				 s7=i1+i2+i4+i16;
				 s8=i1+i3+i12+i4+i16;
				 s9=i1+i3+i13+i16;
				 s10=i1+i3+i14;
				 s11=i1+i3+i7+i15;
				 s12=i1+i3+i7+i11+i9;


				if(s1<=s2 && s1<=s3 && s1<=s4 && s1<=s5 && s1<=s6 && s1<=s7 && s1<=s8 && s1<=s9 && s1<=s10 && s1<=s11 && s1<=s12)
				{
				//	g.drawString("shortest path is C->C5->C6->c8->c9",500,620);
				}
				else
				{//1
				if(s2<=s1 && s2<=s3 && s2<=s4 && s2<=s5 && s2<=s6 && s2<=s7 && s2<=s8 && s2<=s9 && s2<=s10 && s2<=s11 && s2<=s12)
				{
					//g.drawString("shortest path is C->C3->C7->c8->c9",500,620);
				}
				else
				{//2
				if(s3<=s1 && s3<=s2 &&  s3<=s4 && s3<=s5 && s3<=s6 && s3<=s7 && s3<=s8 && s3<=s9 && s3<=s10 && s3<=s11 && s3<=s12)
				{
				//	g.drawString("shortest path is C->C3->C7->c9",500,620);
				}
				else
				{//3
				if(s4<=s1 && s4<=s2 && s4<=s3 &&  s4<=s5 && s4<=s6 && s4<=s7 && s4<=s8 && s4<=s9 && s4<=s10 && s4<=s11 && s4<=s12)
				{
				//	g.drawString("shortest path is C->C3->c9",500,620);
				}
				else
				{//4
				if(s5<=s1 && s5<=s2 && s5<=s3 && s5<=s4 && s5<=s6 && s5<=s7 && s5<=s8 && s5<=s9 && s5<=s10 && s5<=s11 && s5<=s12)
				{
				//	g.drawString("shortest path is C->C3->C4->c9",500,620);
				}
				else
				{//5
				if(s6<=s1 && s6<=s2 && s6<=s3 && s6<=s4 && s6<=s5 && s6<=s7 && s6<=s8 && s6<=s9 && s6<=s10 && s6<=s11 && s6<=s12)
				{
				//	g.drawString("shortest path is C->C3->C2->c4->c9",500,620);
				}
				else
				{//6
				if(s7<=s1 && s7<=s2 && s7<=s3 && s7<=s4 && s7<=s5 && s7<=s6 && s7<=s8 && s7<=s9 && s7<=s10 && s7<=s11 && s7<=s12)
				{
				//	g.drawString("shortest path is C->C1->C2->c4->c9",500,620);
				}
				else
				{//7
				if(s8<=s1 && s8<=s2 && s8<=s3 && s8<=s4 && s8<=s5 && s8<=s6 && s8<=s7 && s8<=s9 && s8<=s10 && s8<=s11 && s8<=s12)
				{
				//	g.drawString("shortest path is C->C1->C3->c2->c4->c9",500,620);
				}
				else
				{//8
				if(s9<=s1 && s9<=s2 && s9<=s3 && s9<=s4 && s9<=s5 && s9<=s6 && s9<=s7 && s9<=s8 &&  s9<=s10 && s9<=s11 && s9<=s12)
				{
				//	g.drawString("shortest path is C->C1->C3->c4->c9",500,620);
				}
				else
				{//9
				if(s10<=s1 && s10<=s2 && s10<=s3 && s10<=s4 && s10<=s5 && s10<=s6 && s10<=s7 && s10<=s8 && s10<=s9 &&  s10<=s11 && s10<=s12)
				{
				//	g.drawString("shortest path is C->C1->C3->c9",500,620);
				}
				else
				{//10
				if(s11<=s1 && s11<=s2 && s11<=s3 && s11<=s4 && s11<=s5 && s11<=s6 && s11<=s7 && s11<=s8 && s11<=s9 && s11<=s10 && s11<=s12  )
				{
				//	g.drawString("shortest path is C->C1->C3->c7->c9",500,620);
				}
				else
				{//11
				if(s12<=s1 && s12<=s2 && s12<=s3 && s12<=s4 && s12<=s5 && s12<=s6 && s12<=s7 && s12<=s8 && s12<=s9 && s12<=s10 && s12<=s11 )
				{
				//	g.drawString("shortest path is C->C1->C3->c7->c8->c9",500,620);
				}
				}//1
				}//2
				}//3
				}//4
				}//5
				}//6
				}//7
				}//8
				}//9
				}//10
				}//11
					
			}
		}

		if(mobile[4].equals("yes"))
		{
			g.setFont(f1);
			g.drawString("C4",150,230);			
	 		g.fillOval(120,200,20,20);	
			but2.setVisible(true);		
		}

		if(mobile[3].equals("yes"))
		{
			g.setFont(f1);	
			g.drawString("C3",180,150);		
	 		g.fillOval(150,150,20,20);
			g.setFont(f2);
		//	g.drawString("PACKETS ROUTING THRO",500,600);	
			 s1=i5+i6+i8+i9;
			 s2=i10+i7+i11+i8+i9;
			 s3=i10+i7+i15;
			 s4=i10+i14;
			 s5=i10+i13+i16;
			 s6=i10+i12+i4+16;
			 s7=i1+i2+i4+i16;
			 s8=i1+i3+i12+i4+i16;
			 s9=i1+i3+i13+i16;
			 s10=i1+i3+i14;
			 s11=i1+i3+i7+i15;
			 s12=i1+i3+i7+i11+i9;


			if(s1<=s2 && s1<=s3 && s1<=s4 && s1<=s5 && s1<=s6 && s1<=s7 && s1<=s8 && s1<=s9 && s1<=s10 && s1<=s11 && s1<=s12)
			{
			//	g.drawString("shortest path is C->C5->C6->c8->c9",500,620);
			}
			else
			{//1
			if(s2<=s1 && s2<=s3 && s2<=s4 && s2<=s5 && s2<=s6 && s2<=s7 && s2<=s8 && s2<=s9 && s2<=s10 && s2<=s11 && s2<=s12)
			{
			//	g.drawString("shortest path is C->C3->C7->c8->c9",500,620);
			}
			else
			{//2
			if(s3<=s1 && s3<=s2 &&  s3<=s4 && s3<=s5 && s3<=s6 && s3<=s7 && s3<=s8 && s3<=s9 && s3<=s10 && s3<=s11 && s3<=s12)
			{
			//	g.drawString("shortest path is C->C3->C7->c9",500,620);
			}
			else
			{//3
			if(s4<=s1 && s4<=s2 && s4<=s3 &&  s4<=s5 && s4<=s6 && s4<=s7 && s4<=s8 && s4<=s9 && s4<=s10 && s4<=s11 && s4<=s12)
			{
			//	g.drawString("shortest path is C->C3->c9",500,620);
			}
			else
			{//4
			if(s5<=s1 && s5<=s2 && s5<=s3 && s5<=s4 && s5<=s6 && s5<=s7 && s5<=s8 && s5<=s9 && s5<=s10 && s5<=s11 && s5<=s12)
			{
			//	g.drawString("shortest path is C->C3->C4->c9",500,620);
			}
			else
			{//5
			if(s6<=s1 && s6<=s2 && s6<=s3 && s6<=s4 && s6<=s5 && s6<=s7 && s6<=s8 && s6<=s9 && s6<=s10 && s6<=s11 && s6<=s12)
			{
			//	g.drawString("shortest path is C->C3->C2->c4->c9",500,620);
			}
			else
			{//6
			if(s7<=s1 && s7<=s2 && s7<=s3 && s7<=s4 && s7<=s5 && s7<=s6 && s7<=s8 && s7<=s9 && s7<=s10 && s7<=s11 && s7<=s12)
			{
			//	g.drawString("shortest path is C->C1->C2->c4->c9",500,620);
			}
			else
			{//7
			if(s8<=s1 && s8<=s2 && s8<=s3 && s8<=s4 && s8<=s5 && s8<=s6 && s8<=s7 && s8<=s9 && s8<=s10 && s8<=s11 && s8<=s12)
			{
			//	g.drawString("shortest path is C->C1->C3->c2->c4->c9",500,620);
			}
			else
			{//8
			if(s9<=s1 && s9<=s2 && s9<=s3 && s9<=s4 && s9<=s5 && s9<=s6 && s9<=s7 && s9<=s8 &&  s9<=s10 && s9<=s11 && s9<=s12)
			{
			//	g.drawString("shortest path is C->C1->C3->c4->c9",500,620);
			}
			else
			{//9
			if(s10<=s1 && s10<=s2 && s10<=s3 && s10<=s4 && s10<=s5 && s10<=s6 && s10<=s7 && s10<=s8 && s10<=s9 &&  s10<=s11 && s10<=s12)
			{
			//	g.drawString("shortest path is C->C1->C3->c9",500,620);
			}
			else
			{//10
			if(s11<=s1 && s11<=s2 && s11<=s3 && s11<=s4 && s11<=s5 && s11<=s6 && s11<=s7 && s11<=s8 && s11<=s9 && s11<=s10 && s11<=s12  )
			{
			//	g.drawString("shortest path is C->C1->C3->c7->c9",500,620);
			}
			else
			{//11
			if(s12<=s1 && s12<=s2 && s12<=s3 && s12<=s4 && s12<=s5 && s12<=s6 && s12<=s7 && s12<=s8 && s12<=s9 && s12<=s10 && s12<=s11 )
			{
			//	g.drawString("shortest path is C->C1->C3->c7->c8->c9",500,620);
			}
			}//1
			}//2
			}//3
			}//4
			}//5
			}//6
			}//7
			}//8
			}//9
			}//10
			}//11
			
		}
			//g.drawString("Shortest Path : c-->c3-->c4-->c9",500,600);		
		
		if(mobile[5].equals("yes"))
		{
			g.setFont(f1);	
			g.drawString("C5",200,100);			
	 		g.fillOval(180,100,20,20);
		}if(mobile[6].equals("yes"))
		{
			g.setFont(f1);	
			g.drawString("C6",280,100);			
	 		g.fillOval(260,100,20,20);
		}
		if(mobile[7].equals("yes"))
		{
			g.setFont(f1);	
			g.drawString("C7",220,150);			
	 		g.fillOval(200,150,20,20);
		}
		if(mobile[8].equals("yes"))
		{
			g.setFont(f1);	
			g.drawString("c8",300,150);			
	 		g.fillOval(280,150,20,20);
		}
		if(mobile[9].equals("yes"))
		{
			g.setFont(f1);	
			g.drawString("C9 (DESTINATION)",220,230);			
	 		g.fillOval(200,200,20,20);
		}
		
		if(tree.equals("yes"))
		{
			if(mobile[1].equals("yes"))
			{
				g.drawLine(110,100,60,150);
				new delay();
				g.drawLine(110,110,190,110);
				new delay();
				g.drawLine(190,110,270,110);
				new delay();
				g.drawLine(60,150,80,200);
				new delay();
				g.drawLine(270,100,290,150);
				new delay();
				g.drawLine(160,160,210,160);
				new delay();
				g.drawLine(210,160,280,160);
				new delay();
				g.drawLine(130,210,200,210);
				new delay();
				g.drawLine(300,160,220,210);
				new delay();
				g.drawLine(210,160,210,200);
			}
			g.drawLine(90,210,120,210);
			
			if(mobile[3].equals("yes"))
			{				
				g.drawLine(110,100,160,150);
				new delay();
				g.drawLine(160,150,130,200);
				new delay();
				g.drawLine(80,200,150,160);
				new delay();
				g.drawLine(150,160,200,210);
				new delay();
				g.drawLine(60,160,150,160);
			}
		}			
		
		String mss1="Delay Analysis and Optimality of Scheduling Policies for";
		setForeground(Color.WHITE);
		g.setFont(f);
		g.drawString(mss1,100,40);
		
		String mss2="Multi-Hop Wireless Networks";
		setForeground(Color.WHITE);
		g.setFont(f);
		g.drawString(mss2,320,70);
		
	
		
		g.setFont(f2);	
		
		g.drawString("Enter Delay",540,230);
		//g.drawString("Shortest Path : c-->c3-->c4-->c9",500,290);
		g.drawString("Available Paths: ",50,380);
		g.drawString("c-->c1-->c2-->c4-->c9",50,400);
		g.drawString("c-->c1-->c3-->c4-->c9",50,420);
		g.drawString("c-->c3-->c2-->c4-->c9",50,440);
		g.drawString("c-->c3-->c4-->c9",50,460);
		g.drawString("c-->c3-->c7-->c9",50,480);
		g.drawString("c-->c3-->c7-->c8-->c9",50,500);
		g.drawString("c-->c5-->c6-->c8-->c9",50,520);
		g.drawString("c-->c5-->c6-->c8-->c7-->c9",50,540);
		g.drawString("c-->c5-->c6-->c8-->c7-->c3-->c9",50,560);
		g.drawString("c-->c5-->c6-->c8-->c7-->c3-->c4-->c9",50,580);
		g.drawString("c-->c5-->c6-->c8-->c7-->c3-->c2-->c4-->c9",50,600);
		g.drawString("c-->c5-->c6-->c8-->c7-->c3-->c1-->c2-->c4-->c9",50,620);
	}

	public void actionPerformed(ActionEvent e)
	{		
		if(e.getSource()==but1)
		{			
			try
			{				
				ss=new ServerSocket(4545);
				System.out.println("Network Manager is listening.....");
				int i=0;
				while(i<=9)
				{			
					new Connect(ss,i);								
					i++;
				}
				System.out.println("Clients are connected....");	  
			}
			catch(Exception er)
			{
				System.out.println("error at :"+er);
			}			   
		} 

		if(e.getSource()==but2)
		{	
			tree="yes";		
			repaint();			
		}	
    if(e.getSource()==t1)
		{	
		 	 			
			i1=Integer.parseInt(t1.getText());		
			i2=Integer.parseInt(t2.getText());
		    i3=Integer.parseInt(t3.getText());
		  	i4=Integer.parseInt(t4.getText());
		 	i5=Integer.parseInt(t5.getText());
		    i6=Integer.parseInt(t6.getText());
		    i7=Integer.parseInt(t7.getText());
		 	i8=Integer.parseInt(t8.getText());
			i9=Integer.parseInt(t9.getText());
			i10=Integer.parseInt(t10.getText());
			i11=Integer.parseInt(t11.getText());
			i12=Integer.parseInt(t12.getText());
		 	i13=Integer.parseInt(t13.getText());
			i14=Integer.parseInt(t14.getText());
			i15=Integer.parseInt(t15.getText());
			i16=Integer.parseInt(t16.getText());
		
		}		
			
	}

	public MultiHopManager()
	{
		try
		{
			int i=0;
			while(i<=9)
		 	{
				mobile[i]="No";
				i++;
			}		
		}
		catch(Exception ee)
		{
			System.out.println("error in:"+ee);
		}
	}   

	public MultiHopManager(String me){}  
}

class delay extends Thread
{
	delay()
	{
		try
		{
			Thread.sleep(500);
		}
		catch(Exception ee){}
	}
}

class Connect 
{
	private ServerSocket ss;	
	private int i;	
    MultiHopManager m1=new MultiHopManager("initial");

	Connect(ServerSocket ss,int i)
	{
		try
		{
			this.ss=ss;	
			this.i=i; 
			Socket soc=ss.accept();						
			MultiHopManager.mobile[i]="yes";					
			MultiHopManager.cs[i]=soc;
			
			if(i==1 || i==3||i==5||i==6||i==7||i==8||i==9)
			{						
				new GetMessage(soc,i).start();
			}
			m1.repaint();			
		}
		catch(Exception ex)
		{
			System.out.println("Error in formingStream:"+ex);
		}
	}		
}

class GetMessage extends Thread
{
	private Socket soc;
	private BufferedReader in;
	private int i;
	MultiHopManager m1=new MultiHopManager("initial");

	GetMessage(Socket soc,int i)
	{
		try
		{
			this.soc=soc;
			this.i=i;
			in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
		}
		catch(Exception ex)
		{
			System.out.println("Error in formingStream:"+ex);
		}
	}

	public void run()
	{	
		while(true)
		{	
			try
			{							
				String message=in.readLine();//getting signal from mobile phones 
				if(message.equals("yes"))
					MultiHopManager.mobile[i]="yes";
				else 
					MultiHopManager.mobile[i]="no";				
			}	
			catch(Exception re){}
		}
	}
}