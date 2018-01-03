import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.util.Date;
import java.util.regex.*;
import java.text.SimpleDateFormat;
import javax.activation.*;
import java.awt.Toolkit;

class Notice extends MouseAdapter implements ActionListener
{
	DefaultMutableTreeNode top,first,second,third,fourth,shift1,shift2,sectiona,sectionb,group1,group2,group3;	
	JFrame f;
	State state;
	JSplitPane sp,sp1,sp2;
	JPanel p1,p2,p3,p4,p5,p6,p7,pan;
	JButton add;
	JButton cs,it,mech,elec,civil,ec,send;
	JLabel filename;
	JTree tree;
	Statement stmt;
	ResultSet rs;
	DefaultTableModel model;
	JTable table;
	JButton btech,mtech,mba,pharma;
	String username;
	String password;
	String rows[][];
	JScrollPane pane;
	DefaultMutableTreeNode node;
	String pattern,line;
	Pattern p;
	Matcher m;
	JButton send1,save1,cancel1;
	JTextField t1,t2,t3;
	JLabel l1,l2,l3;
	JTextArea ta;
	JFrame sf;
	JScrollPane pane1;
	Boolean flag,flag1;
	SimpleDateFormat dateFormat;
	Date date;
	String to,body,sub;
	int noofclick;
	TableColumn column;
	JLabel yearl,shiftl,sectionl,groupl;
	JTextField yeart,sectiont,groupt,shiftt;
	String branch,year,shift,section,path,course;
	JButton submit,back;
	
	JButton logout;
	String filename1;
	Properties props;
	Session session;
	MimeMessage message;
	Multipart multipart;
	BodyPart messageBodyPart;
	DataSource source;
	String from,pwd;
	
	public Notice(String from,String pwd)
	{
		f=new JFrame();
		this.from=from;
		this.pwd=pwd;
		Toolkit tk = Toolkit.getDefaultToolkit();  
		int xSize = ((int) tk.getScreenSize().getWidth());  
		int ySize = ((int) tk.getScreenSize().getHeight());  
		f.setSize(xSize,ySize);
	
		state=new State();
		add=new JButton("Add");
		filename=new JLabel("filename");
		add.setBounds(20,20,150,30);
		filename.setBounds(30,50,150,30);
	
		add.addActionListener(this);

   	 	String columns[] = {"Roll no", "Name", "Email id"};
    		model = new MyDefaultTableModel(rows, columns);
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				noofclick=e.getClickCount();
				}
		});
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener()
		{
		 public void valueChanged(ListSelectionEvent e) 
		 {
				if(e.getValueIsAdjusting() == false) 
				{
						int row = table.getSelectedRow();
						row++;
						if (row > 0) 
						{
							
						}
   				}
		 }	
		});
		
		pane = new JScrollPane(table);
		
		p1=new JPanel();
		p1.setLayout(null);
    	p1.setPreferredSize(new Dimension(200,160));
		p1.add(add);
		p1.add(filename);
		p2=new JPanel();
		
		btech=new JButton("Btech");
		p2.add(btech);
		mtech=new JButton("Mtech");
		p2.add(mtech);
		mba=new JButton("Mba");
		p2.add(mba);
		pharma=new JButton("Pharmacy");
		p2.add(pharma);
		btech.addActionListener(this);
		mtech.addActionListener(this);
		mba.addActionListener(this);
		pharma.addActionListener(this);
		
		p4=new JPanel();
		
		back=new JButton("Back");
		back.addActionListener(this);
		
		cs=new JButton("Computer Science");
		p4.add(cs);
		it=new JButton("Information Tech");
		p4.add(it);
		mech=new JButton("Mechanical");
		p4.add(mech);
		civil=new JButton("Civil");
		p4.add(civil);
		ec=new JButton("E.C");
		p4.add(ec);
		elec=new JButton("Electrical");
		p4.add(elec);
	//	p4.add(back);
		
		send=new JButton("Send");
		send.setBounds(20,100,150,30);
		p1.add(send);
		send.addActionListener(this);
		
		cs.addActionListener(this);
		it.addActionListener(this);
		ec.addActionListener(this);
		elec.addActionListener(this);
		civil.addActionListener(this);
		mech.addActionListener(this);
		
		yearl=new JLabel("Enter Year");
		yearl.setBounds(20,10,100,30);
		sectionl=new JLabel("Enter Section");
		sectionl.setBounds(20,80,100,30);
		shiftl=new JLabel("Enter Shift");
		shiftl.setBounds(20,150,100,30);
		groupl=new JLabel("Enter Group");
		groupl.setBounds(20,220,100,30);
		
		yeart=new JTextField();
		yeart.setBounds(20,40,100,30);
		sectiont=new JTextField();
		sectiont.setBounds(20,110,100,30);
		shiftt=new JTextField();
		shiftt.setBounds(20,180,100,30);
		groupt=new JTextField();
		groupt.setBounds(20,250,100,30);
		
		submit=new JButton("Submit");
		submit.setBounds(20,330,130,40);
		submit.addActionListener(this);
		
		logout=new JButton("LOGOUT");
		logout.setBounds(20,470,130,40);
		logout.setBackground(Color.RED);
		logout.addActionListener(this);
				
		pan=new JPanel();
		pan.setLayout(null);
		pan.add(yearl);
		pan.add(yeart);
		pan.add(sectionl);
		pan.add(sectiont);
		pan.add(shiftl);
		pan.add(shiftt);
		pan.add(groupl);
		pan.add(groupt);
		pan.add(submit);
		pan.add(logout);
		pan.setPreferredSize(new Dimension(200,160));
		sp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,p1,p4);
		sp2=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pan,pane);
		sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp1,sp2);
		sp1.setPreferredSize(new Dimension(700,160));
		f.add(sp);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		course="b.tech";
	}
	public void actionPerformed(ActionEvent e)
	{
		String str=e.getActionCommand();
			if(str=="Send")
			{
				try{
				rs.beforeFirst();
				while(rs.next())
				{
					to = rs.getString("Emailid");
					props = new Properties();
					props.put("mail.smtp.host","smtp.gmail.com");
					props.put("mail.smtp.port", "465"); 
					props.put("mail.smtp.auth","true");
					props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
					props.put("mail.debug", "false");
	
					session = Session.getDefaultInstance(props,new SimpleMailAuthenticator(from,pwd));

         			message = new MimeMessage(session);
         			message.setFrom(new InternetAddress(from));
        			message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));
       		      		message.setSubject("This is the Subject Line!");
 
        			messageBodyPart = new MimeBodyPart();
       				messageBodyPart.setText("This is message body");
       		  
       				multipart = new MimeMultipart();
        			multipart.addBodyPart(messageBodyPart);
 
         			messageBodyPart = new MimeBodyPart();
        			filename1 = filename.getText()+"";
        			source = new FileDataSource(path);
        			messageBodyPart.setDataHandler(new DataHandler(source));
       				messageBodyPart.setFileName(filename1);
         			multipart.addBodyPart(messageBodyPart);
         			message.setContent(multipart);
 
         			Transport.send(message);
      			}
			   }
      			catch (MessagingException mex) {
      				JOptionPane.showMessageDialog(f,"Mail could not be sent");
       				  mex.printStackTrace();
      				}
      				catch(SQLException eee)
      				{}
				
			
			}
			else if(str=="Back")
			{
				sp1.remove(p4);
				sp1.setRightComponent(p2);
				removerows();
				yeart.setText("");
				sectiont.setText("");
				shiftt.setText("");
				groupt.setText("");
				path="";
				filename.setText("");
			}
			else if(str=="LOGOUT")
			{
				f.dispose();
				f.setVisible(false);
				new Auth();
			}	
			else if(str=="Add")
			{
				 JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(f);
   				 if(returnVal == JFileChooser.APPROVE_OPTION) {
   				    System.out.println("You chose to open this file: " +
      			      chooser.getSelectedFile().getName());
      			      path=chooser.getSelectedFile().getAbsolutePath()+"";
      			      System.out.println(path);
      			      filename.setText(chooser.getSelectedFile().getName());
      			      
   					 }		

			}	
			else if(str=="Btech")
			{
				sp1.setDividerLocation(0.3);
				sp1.remove(p2);
				sp1.setRightComponent(p4);
				course="b.tech";
			}
			else if(str=="Computer Science")
			{
				try{
    			stmt=state.getStatement();
    			rs=stmt.executeQuery("Select * from student where Branch='cs'");
    			removerows();
    			while(rs.next())
    			{
    				model.addRow(new String[]{rs.getString("Rollno"), rs.getString("Name"), rs.getString("Emailid")});
    			}
    			}
    			catch(SQLException ee)
    			{
    				ee.printStackTrace();
    			}
    			branch="cs";
			}
			else if(str=="Information Tech")
			{
				try{
    			stmt=state.getStatement();
    			rs=stmt.executeQuery("Select * from student where Branch='it'");
    			removerows();
    			while(rs.next())
    			{
    				model.addRow(new String[]{rs.getString("Rollno"), rs.getString("Name"), rs.getString("Emailid")});
    			}
    			}
    			catch(SQLException ee)
    			{
    				ee.printStackTrace();
    			}
    			branch="it";
			}
			else if(str=="Mechanical")
			{
				try{
    			stmt=state.getStatement();
    			rs=stmt.executeQuery("Select * from student where Branch='mech'");
    			removerows();
    			while(rs.next())
    			{
    				model.addRow(new String[]{rs.getString("Rollno"), rs.getString("Name"), rs.getString("Emailid")});
    			}
    			}
    			catch(SQLException ee)
    			{
    				ee.printStackTrace();
    			}
    			branch="mech";
			}
			else if(str=="Civil")
			{
				try{
    			stmt=state.getStatement();
    			rs=stmt.executeQuery("Select * from student where Branch='civil'");
    			removerows();
    			while(rs.next())
    			{
    				model.addRow(new String[]{rs.getString("Rollno"), rs.getString("Name"), rs.getString("Emailid")});
    			}
    			}
    			catch(SQLException ee)
    			{
    				ee.printStackTrace();
    			}
    			branch="civil";
			}
			else if(str=="E.C")
			{
				try{
    			stmt=state.getStatement();
    			rs=stmt.executeQuery("Select * from student where Branch='ec'");
    			removerows();
    			while(rs.next())
    			{
    				model.addRow(new String[]{rs.getString("Rollno"), rs.getString("Name"), rs.getString("Emailid")});
    			}
    			}
    			catch(SQLException ee)
    			{
    				ee.printStackTrace();
    			}
    			branch="ec";
			}
			else if(str=="Electrical")
			{
				try{
    			stmt=state.getStatement();
    			rs=stmt.executeQuery("Select * from student where Branch='elec'");
    			removerows();
    			while(rs.next())
    			{
    				model.addRow(new String[]{rs.getString("Rollno"), rs.getString("Name"), rs.getString("Emailid")});
    			}
    			}
    			catch(SQLException ee)
    			{
    				ee.printStackTrace();
    			}
    			branch="elec";
			}
			else if(str=="Submit")
			{
				try{
    			stmt=state.getStatement();
    			rs=stmt.executeQuery("Select * from student where Branch='"+branch+"' and Course='"+course+"' and Section='"+sectiont.getText()+"' and Year='"+yeart.getText()+"' and Grp='"+groupt.getText()+"' and Shift='"+shiftt.getText()+"' ");
    			removerows();
    			while(rs.next())
    			{
    				model.addRow(new String[]{rs.getString("Rollno"), rs.getString("Name"), rs.getString("Emailid")});
    			}
    			}
    			catch(SQLException ee)
    			{
    				ee.printStackTrace();
    			}
			}
	}
        public void removerows()
	{
		int rowNum=table.getRowCount();
		for(int i=rowNum;i>0;i--)
		{
			rowNum=table.getRowCount();
			model.removeRow(rowNum-1);
		}
	}
        public static void main(String args[])
        {
    	Notice n=new Notice("skitstudent1@gmail.com","admin123?");
   	}
}
