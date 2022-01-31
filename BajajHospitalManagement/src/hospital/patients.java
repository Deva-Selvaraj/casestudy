package hospital;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class patients {
	String pid, pname, disease, sex, admit_status;
	int age;
    public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAdmit_status() {
		return admit_status;
	}
	public void setAdmit_status(String admit_status) {
		this.admit_status = admit_status;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void addpatients()
	{
		System.out.println("Enter Patient Details : ");
		Scanner input = new Scanner(System.in);
        System.out.print("id:-");
         setPid(input.nextLine());
        System.out.print("name:-");
        setPname(input.nextLine());
        System.out.print("disease:-");
        setDisease(input.nextLine());
        System.out.print("sex:-");
        setSex(input.nextLine());
        System.out.print("admit_status:-");
        setAdmit_status(input.nextLine());
        System.out.print("age:-");
        setAge(input.nextInt());
        try {
			Class.forName("oracle.jdbc.OracleDriver");   
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:Bajajc1/123@localhost:1521");
			PreparedStatement stmt= con.prepareStatement("insert into patients values(?,?,?,?,?,?)");
			stmt.setString(1,getPid());
			stmt.setString(2,getPname());
			stmt.setString(3,getDisease());
			stmt.setString(4,getSex());
			stmt.setString(5,getAdmit_status());
			stmt.setInt(6,getAge());
			int i=stmt.executeUpdate();
			con.close();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        finally
        {
        	System.out.println("Patients Added...");
        }
	}
	public void existpatients()
	{
		
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");   
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:Bajajc1/123@localhost:1521");
		    Statement st= con.createStatement();
			ResultSet rs = st.executeQuery("select * from patients");
			 System.out.println("--------------------------------------------------------------------------------");
             System.out.println("id      Name     Disease     Gender     Admit Status     Age");
             System.out.println("--------------------------------------------------------------------------------");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"     "+rs.getString(2)+"       "+rs.getString(3)+"      "+rs.getString(4)+"      "+rs.getString(5)+"      "+rs.getInt(6));
				System.out.println("--------------------------------------------------------------------------------------------------------");
			}
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
			
		}		
		finally {
			
			System.out.println("Existing Patient's in the Hospital ");
		}
		
	}
    
}
