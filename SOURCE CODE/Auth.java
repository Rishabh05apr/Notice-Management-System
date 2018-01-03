import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.event.*;
class Auth implements ActionListener
{
	JFrame f;
	JButton b1,b2;
	JLabel l1,l2;
	JTextField t1;
	JPasswordField t2;
	String url;
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	public Auth()
	{
		try
		{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			url="jdbc:mysql://localhost:3306/nms?user=root&password=root";
			con=DriverManager.getConnection(url);
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=stmt.executeQuery("Select * from faculty");
		}
		catch(Exception e)
		{
		}
		f=new JFrame();
		f.setSize(400,450);	
		JLabel jbl=new JLabel(new ImageIcon("logo.png"));
		jbl.setBounds(20,20,350,200);
		
		f.setLayout(null);
		l1=new JLabel("Username");
		l1.setBounds(20,230,150,50);
		f.add(l1);

		l2=new JLabel("Password");
		l2.setBounds(20,290,150,50);
		f.add(l2);
		
		t1=new JTextField();
		t1.setBounds(210,230,150,50);
		f.add(t1);

		t2=new JPasswordField();
		t2.setBounds(210,290,150,50);
		f.add(t2);
		
		b1=new JButton("Login");
		b1.setBounds(20,350,150,50);
		b1.addActionListener(this);
		f.add(b1);
		 
		b2=new JButton("Clear");
		b2.setBounds(210,350,150,50);
		b2.addActionListener(this);
		f.add(b2);
		f.add(jbl);
		
		f.setVisible(true);

	}
	public void actionPerformed(ActionEvent e)
	{
		try{
		String str=e.getActionCommand();
		if(str=="Login")
		{
			boolean flag=false;
			rs.beforeFirst();
			while(rs.next())
			{
				if((rs.getString("name").equals(t1.getText()+""))&&(rs.getString("password").equals(t2.getText()+"")))
				{
					flag=true;
					new Notice(rs.getString("emailid"),rs.getString("password"));
					f.dispose();
					f.setVisible(false);
				}
			}
			if(flag==false)	
			JOptionPane.showMessageDialog(f,"Incorrect id or password");
		}
		else if(str=="Clear")
		{
			t1.setText("");
			t2.setText("");
		}
		}
		catch(SQLException sql)
		{

		}
			
	}
	public static void main(String args[])
	{
		Auth a=new Auth();
	}
}
