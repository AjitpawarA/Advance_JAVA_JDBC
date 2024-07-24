package ECA_Company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class CompanyDao {

	private static String url = "jdbc:postgresql://localhost:5432/eca_jdbc";
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection con= null;
		Statement stmt=null;
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded");
			
			
			con = DriverManager.getConnection(url,"postgres","Ajit@123");
			System.out.println("Connection established");

			stmt= con.createStatement();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		boolean exit = true;
		System.out.println("Welcome to the store");
		while(exit) {
			System.out.println("choose correct options");
			System.out.println("1:add Company");
			System.out.println("2:update Company details");
			System.out.println("3:delete company");
			System.out.println("4:list all Companys");
			System.out.println("5:find Company");
			System.out.println("0:exit");
			
			int ch = sc.nextInt();
			
			try {
				switch(ch) {
				case 1:{
					String query ="insert into companies values (?,?,?)"; 
					System.out.println("Enter Company id :");
					int cid = sc.nextInt();
					System.out.println("Enter Company name :");
					String cname = sc.next();
					System.out.println("Enter Company gst no:");
					int gst = sc.nextInt();
					
					Company p = new Company(cid, cname, gst);
					
					Company.saveCompany(p, query, con);
					
				}
				break;
				
				case 2:{
					Company.updateCompany(con, sc);
				}
				break;
				case 3:{
					System.out.println("Enter id:");
					int id=sc.nextInt();
					Company.deleteCompany(id, con, sc);
				}
				break;
				case 4:{
				    ArrayList<Company> clist = Company.listAllCompanys(con, sc, stmt);
				    if(clist.size()==0) {
				    	System.out.println("No Companys");
				    }
				    else {
				    	for (Company Company : clist) {
							System.out.println(Company);
						}
				    }
				}
				break;
				case 5:{
					System.out.println("Enter Company id:");
					int id = sc.nextInt();
					Company c =Company.findCompanybyID(id, con, sc);
					
					if(c==null) {
						System.out.println("No Company found");
					}
					else {
						System.out.println(c);
					}
				}
				break;
				case 0:{
					exit=false;
				}
				break;
				default:{
					System.out.println("wrong choise .....");
				}
				}
			} catch (Exception e) {
				System.out.println("....");
			}
		}
		System.out.println("Thank you");
	}
}
