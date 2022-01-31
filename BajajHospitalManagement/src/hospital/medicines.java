package hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class medicines {
	String med_name, med_comp, exp_date;
	int med_cost, count;
    public String getMed_name() {
		return med_name;
	}
	public void setMed_name(String med_name) {
		this.med_name = med_name;
	}
	public String getMed_comp() {
		return med_comp;
	}
	public void setMed_comp(String med_comp) {
		this.med_comp = med_comp;
	}
	public String getExp_date() {
		return exp_date;
	}
	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}
	public int getMed_cost() {
		return med_cost;
	}
	public void setMed_cost(int med_cost) {
		this.med_cost = med_cost;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
 public void addmed()
 {
	 Scanner input = new Scanner(System.in);
     System.out.print("name:-");
     setMed_name(input.nextLine());
     System.out.print("comp:-");
     setMed_comp(input.nextLine());
     System.out.print("exp_date:-");
     setExp_date (input.nextLine());
     System.out.print("cost:-");
     setMed_cost(input.nextInt());
     System.out.print("no of unit:-");
     setCount(input.nextInt());
     try {
			Class.forName("oracle.jdbc.OracleDriver");   
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:Bajajc1/123@localhost:1521");
			PreparedStatement stmt= con.prepareStatement("insert into medicines values(?,?,?,?,?)");
			stmt.setString(1,getMed_name());
			stmt.setString(2,getMed_comp());
			stmt.setString(3,getExp_date());
			stmt.setInt(4,getMed_cost());
			stmt.setInt(5,getCount());
			int i=stmt.executeUpdate();
			con.close();
     }
     catch(Exception e)
     {
     	e.printStackTrace();
     }
     finally
     {
     	System.out.println("Medicines Added...");
     }
 }
 public void existMedicines()
 {
	 try
		{
			Class.forName("oracle.jdbc.OracleDriver");   
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:Bajajc1/123@localhost:1521");
		    Statement st= con.createStatement();
			ResultSet rs = st.executeQuery("select * from medicines");
			 System.out.println("--------------------------------------------------------------------------------");
             System.out.println("Name      Company      Expiry Date      Cost      Count");
             System.out.println("--------------------------------------------------------------------------------");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"     "+rs.getString(2)+"       "+rs.getString(3)+"      "+rs.getInt(4)+"        "+rs.getInt(5));
				System.out.println("--------------------------------------------------------------------------------------------------------");
			}
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
			
		}		
		finally {
			
			System.out.println("Existing Medicine's in the Hospital ");
		}
 }
 
 public void searchMed()
 {
	 try
	 {
		 System.out.println("Enter Med name : ");
		 String searchMed,choice;
		 int no;
		 Scanner sc = new Scanner(System.in);
		 searchMed= sc.nextLine();
		 System.out.println("Do you want to Purchase? yes/no: ");
		 choice=sc.nextLine();
	
		 Class.forName("oracle.jdbc.OracleDriver");   
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:Bajajc1/123@localhost:1521");
			switch(choice){
			case "no":
			{
		  
			  int available=-1;
		      PreparedStatement st0= con.prepareStatement("Select count from medicines where med_name=?");
		      st0.setString(1,searchMed);
		      ResultSet r=st0.executeQuery();
		      while(r.next())
		      {
		    	  available=r.getInt(1);
		      }
			if(available<0)
			{
				 System.out.println("Medicine Out of Stock....");
		    	 System.out.println("Do you want to add stock ? yes/no ");
		    	 String ch;
		    	 Scanner s= new Scanner(System.in);
		    	 ch=s.nextLine();
		    	 switch(ch)
		    	 {
		    	 case "yes":
		    	 {
		    	 addmed();
		    	 break;
		    	 }
		    	 case "no":
		    	 {
		    		 System.out.println("Out of Stock Sorry!");
		    	 break;
		    	 }
		    	 }
				
			}
			
			PreparedStatement st= con.prepareStatement("select * from medicines where med_name= ?  ");
			st.setString(1,searchMed);
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				System.out.println("Name      Company      Expiry Date      Cost      Count");
				if(available>0)
				{
				System.out.println(rs.getString(1)+"     "+rs.getString(2)+"       "+rs.getString(3)+"      "+rs.getInt(4)+"        "+rs.getInt(5));
				System.out.println("--------------------------------------------------------------------------------------------------------");
				}
			}
			break;
			}
			case "yes":
			{    System.out.println("How much do you want to purchase : ");
			      no=sc.nextInt();
			      int available=0;
			      PreparedStatement st0= con.prepareStatement("Select count from medicines where med_name=?");
			      st0.setString(1,searchMed);
			      ResultSet r=st0.executeQuery();
			      while(r.next())
			      {
			    	  available=r.getInt(1);
			      }
			     if(available>no)
			     {
				 PreparedStatement st= con.prepareStatement(" Update medicines SET count=(count-?) where med_name=?");
				 st.setInt(1,no);
				 st.setString(2,searchMed);
                 st.executeUpdate();
				 PreparedStatement st1= con.prepareStatement("select * from medicines");
					ResultSet rs=st1.executeQuery();
					System.out.println("Name      Company      Expiry Date      Cost      Count");
					System.out.println();
					while(rs.next())
					{
						System.out.println(rs.getString(1)+"     "+rs.getString(2)+"       "+rs.getString(3)+"      "+rs.getInt(4)+"        "+rs.getInt(5));
						System.out.println("--------------------------------------------------------------------------------------------------------");
					}
					break;
			     }
			     else if(available<no && available >1)
			     {
			    	 System.out.println("Medicine Out of Stock....");
			    	 System.out.println("Do you want to add stock ? yes/no ");
			    	 String ch;
			    	 int n;
			    	 Scanner s= new Scanner(System.in);
			    	 ch=s.nextLine();
			    	 switch(ch)
			    	 {
			    	 case "yes":
			    	 {   int num;
			    	     System.out.println("Enter how much do you want to add in stock: ?");
			    	     num=sc.nextInt();
			    		 PreparedStatement st3= con.prepareStatement(" update medicines set count=(count+?) where med_name=?");
			    		 st3.setInt(1,num);
			    		 st3.setString(2,searchMed);
			    		 st3.executeUpdate();
			    		 break;
			    	 }
			    	 case "no":
			    	 {
			    		 System.out.println("Out of Stock Sorry!");
			    		 break;
			    	 }
			    	 }
			     }
			     else
			     {
			    	 System.out.println("Medicine Out of Stock....");
			    	 System.out.println("Do you want to add stock ? yes/no ");
			    	 String ch;
			    	 Scanner s= new Scanner(System.in);
			    	 ch=s.nextLine();
			    	 switch(ch)
			    	 {
			    	 case "yes":
			    	 {
			    	 addmed();
			    	 break;
			    	 }
			    	 case "no":
			    	 {
			    		 System.out.println("Out of Stock Sorry!");
			    	 }
			    	 break;
			    	 }
			     }
			}
			
			
			}
		
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
 }
}
