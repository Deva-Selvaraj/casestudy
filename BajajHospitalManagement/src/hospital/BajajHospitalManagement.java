package hospital;
import java.util.Calendar;
import java.util.Scanner;

public class BajajHospitalManagement {
	
        public static void main(String[] args)
		{
        	
        	Authentication A= new Authentication();
        	String a,b;
        	System.out.println("Enter user name: ");
        	Scanner s= new Scanner(System.in);
        	a=s.nextLine();
        	System.out.println("Enter user password: ");
        	b=s.nextLine();
        	if(A.validate(a.toLowerCase(),b)==1)
        	{
      
	        String months[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul", "Aug","Sep","Oct","Nov","Dec"};
	        Calendar calendar = Calendar.getInstance();
	       

	 

	        System.out.println("\n--------------------------------------------------------------------------------");

	 

	        System.out.println("            *** Welcome to Bajaj Hospital Management System Project in Java ***");
	        System.out.println("--------------------------------------------------------------------------------");
	        System.out.print("Date: " + months[calendar.get(Calendar.MONTH)] + " " + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.YEAR));
	        System.out.println("\t\t\t\t\t\tTime: " + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));
	       

	        Scanner input = new Scanner(System.in);
	        int choice, j, c1, status = 1, s1 = 1, s2 = 1, s3 = 1, s4 = 1, s5 = 1, s6 = 1;
	        newDoctor ob = new newDoctor();
	        patients p1 = new patients();
	        medicines m1 = new medicines();
	       while (status == 1)
	        {
	            System.out.println("\n                                    MAIN MENU");
	            System.out.println("-----------------------------------------------------------------------------------");

	 

	            System.out.println("1.Doctos  2. Patients  3.Medicines 4.AddLogin  ");
	            System.out.println("-----------------------------------------------------------------------------------");
	            choice = input.nextInt();
	           
	           
	        
	            switch (choice)
	            {
	                case 1:
	                    {
	                        System.out.println("--------------------------------------------------------------------------------");
	                        System.out.println("                      **DOCTOR SECTION**");
	                        System.out.println("--------------------------------------------------------------------------------");
	                        s1 = 1;
	                        while (s1 == 1)
	                        {
	                            System.out.println("1.Add New Entry\n2.Existing Doctors List");
	                            c1 = input.nextInt();
	                            switch (c1)
	                            {
	                                case 1:
	                                    {
	                                    ob.new_doctor();
	                         	           
	                                        break;
	                                    }
	                                case 2:
	                                    {
	                                        System.out.println("--------------------------------------------------------------------------------");
	                                        System.out.println("id \t Name\t Specilist \t Timing \t Qualification \t Room No.");

	 

	                                        System.out.println("--------------------------------------------------------------------------------");
	                      
	                                        	 ob.existDoc();
	                                        
	                                        break;
	                                    }
	                            }
	                            System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
	                            s1 = input.nextInt();
	                        }
	                        break;
	                    }
	                case 2:
	                    {
	                        System.out.println("--------------------------------------------------------------------------------");
	                        System.out.println("                     **PATIENT SECTION**");
	                        System.out.println("--------------------------------------------------------------------------------");
	                        s2 = 1;
	                        while (s2 == 1)
	                        {
	                            System.out.println("1.Add New Entry\n2.Existing Patients List");
	                            c1 = input.nextInt();
	                            switch (c1)
	                            {
	                                case 1:
	                                    {
	                                        p1.addpatients();
	                                        break;
	                                    }
	                                case 2:
	                                    {
	                                        p1.existpatients();
	                                        break;
	                                    }
	                            }
	                            System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
	                            s2 = input.nextInt();
	                        }
	                        break;
	                    }
	               case 3:
	                    {
	                        s3 = 1;
	                        System.out.println("--------------------------------------------------------------------------------");
	                        System.out.println("                     **MEDICINE SECTION**");
	                        System.out.println("--------------------------------------------------------------------------------");
	                        while (s3 == 1)
	                        {
	                            System.out.println("1.Add New Entry\n2. Existing Medicines List\n3. Search Medicine by Name");
	                            c1 = input.nextInt();
	                            switch (c1)
	                            {
	                                case 1:
	                                    {
	                                    	m1.addmed();
	                                        break;
	                                    }
	                                case 2:
	                                    {
	                                        m1.existMedicines();
	                                        break;
	                                    }
	                                case 3:
	                                {
	                                	m1.searchMed();
	                                	break;
	                                }
	                            }
	                            System.out.println("\nReturn to Back Press 1 and for Main Menu Press 0");
	                            s3 = input.nextInt();
	                        }
	                        break;
	                    }
	               case 4:
	               {
	            	  String aa,bb;
	               	System.out.println("Enter Newuser name: ");
	               	Scanner ss= new Scanner(System.in);
	               	aa=ss.nextLine();
	               	System.out.println("Enter Newuser password: ");
	               	bb=ss.nextLine();
	               	A.addlogin(aa.toLowerCase(),bb);
	               	break;
	               	
	               }
	              
	             default:
	                    {
	                        System.out.println(" You Have Enter Wrong Choice!!!");
	                    }
	            }
	            System.out.println("\nReturn to MAIN MENU Press 1");
	            status = input.nextInt();
		}
	       }
        	 else
             {
             	System.out.println("Invalid User");
             	
             }
		}
       
}
	

