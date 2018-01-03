import java.sql.*;
public class State {

Statement stmt;
Connection con;
String url;

    public State() {
    }
    public Statement getStatement()
    {
    	try
		{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());//loads the driver
			url="jdbc:mysql://localhost:3306/nms?user=root&password=root";//local host system 3306 port no. 
			con=DriverManager.getConnection(url);//establishes the connection
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);//changes are reflected ....result set is updatable 
			
		}
		catch(SQLException e)
		{}
		return stmt;
    }
    
}