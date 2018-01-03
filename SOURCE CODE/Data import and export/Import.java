import java.io.*; 
import java.sql.*;    
import java.util.*;
import java.util.regex.*;    
import org.apache.poi.hssf.usermodel.*;   
import org.apache.poi.poifs.filesystem.POIFSFileSystem;   
public class Import 
{   
    public static void main( String [] args ) 
	{   
	      String fileName="d:\\data.xls";  
 	      Vector dataHolder=read(fileName);   
	      saveToDatabase(dataHolder); 
	}
    public static Vector read(String fileName)
    {         
	Vector cellVectorHolder = new Vector();     
 	try
	{                
		 FileInputStream myInput = new FileInputStream(fileName); 
                POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput); 
            HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);   
          HSSFSheet mySheet = myWorkBook.getSheetAt(0);     
       Iterator rowIter = mySheet.rowIterator();  
           while(rowIter.hasNext())
		{          
		         HSSFRow myRow = (HSSFRow) rowIter.next(); 
                  Iterator cellIter = myRow.cellIterator();   
                Vector cellStoreVector=new Vector();    
               while(cellIter.hasNext())
		{                   
		        HSSFCell myCell = (HSSFCell) cellIter.next();   
                        cellStoreVector.addElement(myCell);     
              }   
                cellVectorHolder.addElement(cellStoreVector);   
	        }
         }
	catch (Exception e)
	{
		e.printStackTrace(); 
	}         
	return cellVectorHolder;     

}         
private static void saveToDatabase(Vector dataHolder) 
{         
String username="";      
           String password="";    
             for (int i=0;i<dataHolder.size(); i++)
		{                  
			 Vector cellStoreVector=(Vector)dataHolder.elementAt(i);
                         for (int j=0; j < cellStoreVector.size();j++)
			{               
	 	                 HSSFCell myCell = (HSSFCell)cellStoreVector.elementAt(j);  
                               String st = myCell.toString(); 
				System.out.println("st value is:- "+st);
                                username=st.substring(0,1);   
                               password=st.substring(0);      
                         } 
                        /*try
			{  
  				 Class.forName("com.mysql.jdbc.Driver").newInstance();
				    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "root");         Statement stat=con.createStatement();         int k=stat.executeUpdate("insert into login(username,password) value('"+username+"','"+password+"')");  
       System.out.println("Data is inserted");   
      stat.close();
         con.close();     
    }         
catch(Exception e)
{}  */       
}   
      } 
      }