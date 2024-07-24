package ECA_Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Company {
	private int id;
	private String cname;
	private int gst;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getGst() {
		return gst;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", cname=" + cname + ", gst=" + gst + "]";
	}
	public Company(int id, String cname, int gst) {
		super();
		this.id = id;
		this.cname = cname;
		this.gst = gst;
	}
	public void setGst(int gst) {
		this.gst = gst;
	}
	

	public static void saveCompany(Company c, String query, Connection con) throws Exception {
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, c.getId());
			pstmt.setString(2, c.getCname());
			pstmt.setInt(3,c.getGst());
			
			int res = pstmt.executeUpdate();
			if(res==1) {
				System.out.println("Company added into the db");
			}
		} catch (SQLException e) {
			System.out.println("Company with Duplicate ID not allowed");
		}
	}
	
	public static void updateCompany(Connection con, Scanner sc) {
		String query ="update companies set gst=? where cid =?"; 
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			System.out.println("Enter the Company id: ");
			pstmt.setInt(2, sc.nextInt());
			System.out.println("Enter the GST no to be updated : ");
			pstmt.setInt(1, sc.nextInt());
			int res =pstmt.executeUpdate();
			if(res==1) {
				System.out.println("Company updated from db");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Company findCompanybyID(int id,Connection con, Scanner sc) {
		String query = "select * from companies where cid =?";
		Company returned_p=null;
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1,id);
			ResultSet res =pstmt.executeQuery();
			while(res.next()) {

				returned_p= new Company(res.getInt("cid"), res.getString("cname"), res.getInt("gst"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(returned_p==null) {
			return null;
		}
		else {
			return returned_p;
		}
		
	}
	
	public static Company deleteCompany(int id,Connection con, Scanner sc) {
		String query = "delete from companies where cid =?";
		Company returned_p=null;
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1,id);
			
			int res =pstmt.executeUpdate();
			
			if(res==1) {
				System.out.println("Company deletd from db");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(returned_p==null) {
			return null;
		}
		else {
			return returned_p;
		}
		
	}
	
	public static ArrayList<Company> listAllCompanys(Connection con, Scanner sc, Statement stmt) {
	    String query = "select * from companies"; 
	    ArrayList<Company> company_list = new ArrayList();
	    try {
	        ResultSet rs = stmt.executeQuery(query);
	        
	        while (rs.next()) {
	            company_list.add(new Company(rs.getInt("cid"), rs.getString("cname"), rs.getInt("gst")));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return company_list;
	}

}
