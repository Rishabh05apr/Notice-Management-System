import  java.io.*;  
import  java.sql.*;
import  org.apache.poi.hssf.usermodel.HSSFSheet;  
import  org.apache.poi.hssf.usermodel.HSSFWorkbook; 
import  org.apache.poi.hssf.usermodel.HSSFRow;
import  org.apache.poi.hssf.usermodel.HSSFCell;  

public class dataexport{
public static void main(String[]args){
try{
String filename="d:/data.xls";
HSSFWorkbook hwb=new HSSFWorkbook();
HSSFSheet sheet =  hwb.createSheet("new sheet");

HSSFRow rowhead=   sheet.createRow((short)0);
rowhead.createCell((short) 0).setCellValue("SNo");
rowhead.createCell((short) 1).setCellValue("Name");
rowhead.createCell((short) 2).setCellValue("Address");
rowhead.createCell((short) 3).setCellValue("Contact No");
rowhead.createCell((short) 4).setCellValue("E-mail");

DriverManager.registerDriver(new com.mysql.jdbc.Driver());
String url="jdbc:mysql://localhost:3306/test?user=root&password=root";
Connection con=DriverManager.getConnection(url);
Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
ResultSet rs=stmt.executeQuery("Select * from account");
int i=1;
while(rs.next())
{
HSSFRow row=   sheet.createRow((short)i);
row.createCell((short) 0).setCellValue(Integer.toString(rs.getInt("id")));
row.createCell((short) 1).setCellValue(rs.getString("name"));
row.createCell((short) 2).setCellValue(rs.getString("address"));
row.createCell((short) 3).setCellValue(Integer.toString(rs.getInt("contactNo")));
row.createCell((short) 4).setCellValue(rs.getString("email"));
i++;
}
FileOutputStream fileOut =  new FileOutputStream(filename);
hwb.write(fileOut);
fileOut.close();
System.out.println("Your excel file has been generated!");

} catch ( Exception ex ) {
    System.out.println(ex.getMessage());

}
    }
}
