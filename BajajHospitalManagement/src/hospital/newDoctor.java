package hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class newDoctor 
{
	String did, dname, specilist, appoint, doc_qual;
	int droom;
    public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getSpecilist() {
		return specilist;
	}

	public void setSpecilist(String specilist) {
		this.specilist = specilist;
	}

	public String getAppoint() {
		return appoint;
	}

	public void setAppoint(String appoint) {
		this.appoint = appoint;
	}

	public String getDoc_qual() {
		return doc_qual;
	}

	public void setDoc_qual(String doc_qual) {
		this.doc_qual = doc_qual;
	}

	public int getDroom() {
		return droom;
	}

	public void setDroom(int droom) {
		this.droom = droom;
	}

	
	
   public void new_doctor()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("id:-");
        setDid( input.nextLine());
        System.out.print("name:-");
        setDname(input.nextLine());
        System.out.print("specilization:-");
        setSpecilist (input.nextLine());
        System.out.print("work time:-");
        setAppoint ( input.nextLine());
        System.out.print("qualification:-");
        setDoc_qual(input.nextLine());
        System.out.print("room no.:-");
        setDroom (input.nextInt());
        try {
			Class.forName("oracle.jdbc.OracleDriver");   
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:Bajajc1/123@localhost:1521");   
			PreparedStatement stmt=con.prepareStatement("insert into Doctors values(?,?,?,?,?,?)");  
			stmt.setString(1,getDid());
			stmt.setString(2,getDname());
			stmt.setString(3,getSpecilist());
			stmt.setString(4,getAppoint());
			stmt.setString(5,getDoc_qual());
			stmt.setInt(6,getDroom());
			int i=stmt.executeUpdate();
			con.close();
		}
		
		catch(Exception e1)
		{
			e1.printStackTrace();
			
		}		
		finally {
			
			//con.close();
			System.out.print("  Doctors added...");
		}
    
}
 public void existDoc()
 {
	 try {
			Class.forName("oracle.jdbc.OracleDriver");   
			Connection con=DriverManager.getConnection( "jdbc:oracle:thin:Bajajc1/123@localhost:1521"); 
			PreparedStatement st= con.prepareStatement("Select * from Doctors");
			ResultSet rs= st.executeQuery();
			System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println("id      Name      Specilist      Timing      Qualification      Room No.");
            System.out.println("--------------------------------------------------------------------------------------------------------");
            while(rs.next())
            {
            	System.out.println(rs.getString(1)+"     "+rs.getString(2)+"       "+rs.getString(3)+"      "+rs.getString(4)+"      "+rs.getString(5)+"      "+rs.getInt(6));
            	System.out.println("--------------------------------------------------------------------------------------------------------");
            }
            con.close();
	 }
	 catch(Exception e1)
		{
			e1.printStackTrace();
			
		}		
		finally {
			
			System.out.println("Existing Doctor's in the Hospital ");
		}
	 
	 
 }



}
