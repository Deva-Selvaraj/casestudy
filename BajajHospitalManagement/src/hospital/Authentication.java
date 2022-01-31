package hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Authentication {
     String username,password;
     int validate(String uname, String pass)
	{int v=0;
		try
		{
			 Class.forName("oracle.jdbc.OracleDriver");   
				Connection con=DriverManager.getConnection(  
				"jdbc:oracle:thin:Bajajc1/123@localhost:1521");
				
				PreparedStatement p= con.prepareStatement("select count(userid) from Authentication where userid=? and password=? ");
				p.setString(1,uname);
				p.setString(2,pass);
				ResultSet s= p.executeQuery();
				while(s.next())
				{
					v=s.getInt(1);
				}
				
		}
		 catch(Exception e)
        {
        	e.printStackTrace();
        }
		return v;
	}
     void addlogin(String uname,String pass)
     {
    	 try {
 			Class.forName("oracle.jdbc.OracleDriver");   
 			Connection con=DriverManager.getConnection(  
 			"jdbc:oracle:thin:Bajajc1/123@localhost:1521");
 			PreparedStatement stmt= con.prepareStatement("insert into Authentication values(?,?)");
 			stmt.setString(1,uname);
 			stmt.setString(2,pass);
 			int i=stmt.executeUpdate();
 			con.close();
 			System.out.println("Added.....");
      }
      catch(Exception e)
      {
      	e.printStackTrace();
      }
     }
	
}
