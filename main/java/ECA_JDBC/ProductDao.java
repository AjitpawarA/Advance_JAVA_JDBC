package ECA_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import Statements.Prepared_Statements;
import Statements.prepared_statement_delete_query;

public class ProductDao {
	static Scanner sc = new Scanner(System.in);
	private static final String url = "jdbc:postgresql://localhost:5432/eca_jdbc";
	static Connection con = null;
	static Statement stmt = null;
	static {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, "postgres", "Ajit@123");
			stmt = con.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void saveProduct(Product p) throws Exception {
		String query = "insert into produts values (?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setInt(1, p.getPid());
			pstmt.setString(2, p.getPname());
			pstmt.setString(3, p.getPtype());
			pstmt.setInt(4, p.getPcost());

			int res = pstmt.executeUpdate();
			if (res == 1) {
				System.out.println("Product added into the db");
			}
		} catch (SQLException e) {
			System.out.println("Pdoduct with Duplicate key not allowed");
		}
	}

	public static void updateProduct() {
		String query = "update produts set pcost=? where pid =?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			System.out.println("Enter the product id: ");
			pstmt.setInt(2, sc.nextInt());
			System.out.println("Enter the cost to be updated : ");
			pstmt.setInt(1, sc.nextInt());
			int res = pstmt.executeUpdate();
			if (res == 1) {
				System.out.println("product updated from db");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Product findProductbyID(int id) {
		String query = "select * from products where pid =?";
		Product returned_p = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();
			if (res.next()) {
				returned_p = new Product(res.getInt("pid"), res.getString("pname"), res.getString("ptype"),
						res.getInt("pcost"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (returned_p == null) {
			return null;
		} else {
			return returned_p;
		}

	}

	public static Product deleteproduct(int id) {
		String query = "delete from produts where pid =?";
		Product returned_p = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);

			int res = pstmt.executeUpdate();

			if (res == 1) {
				System.out.println("product deletd from db");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (returned_p == null) {
			return null;
		} else {
			return returned_p;
		}

	}

	public static ArrayList<Product> displayAll() {
		String query = "select * from produts";
		ArrayList<Product> prod_list = new ArrayList();
		try {
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				prod_list.add(new Product(rs.getInt("pid"), rs.getString("pname"), rs.getString("ptype"),
						rs.getInt("pcost")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prod_list;
	}

	public static void main(String[] args) {

		boolean exit = true;
		System.out.println("Welcome to the store");
		while (exit) {
			System.out.println("choose correct options");
			System.out.println("1:add product");
			System.out.println("2:update product details");
			System.out.println("3:delete priduct");
			System.out.println("4:list all products");
			System.out.println("5:find product");
			System.out.println("0:exit");

			int ch = sc.nextInt();

			try {
				switch (ch) {
				case 1: {
					System.out.println("Enter product id :");
					int pid = sc.nextInt();
					System.out.println("Enter product name :");
					String pname = sc.next();
					System.out.println("Enter product type");
					String ptype = sc.next();
					System.out.println("Enter Product cost");
					int pcost = sc.nextInt();

					Product p = new Product(pid, pname, ptype, pcost);

					saveProduct(p);

				}
					break;

				case 2: {
					updateProduct();
				}
					break;
				case 3: {
					System.out.println("Enter id:");
					int id = sc.nextInt();
					deleteproduct(id);
				}
					break;
				case 4: {
					ArrayList<Product> plist = displayAll();
					if (plist.size() == 0) {
						System.out.println("No products");
					} else {
						for (Product product : plist) {
							System.out.println(product);
						}
					}
				}
					break;
				case 5: {
					System.out.println("Enter Product id:");
					int id = sc.nextInt();
					Product p = findProductbyID(id);

					if (p == null) {
						System.out.println("No product found");
					} else {
						System.out.println(p);
					}
				}
					break;
				case 0: {
					exit = false;
				}
					break;
				default: {
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
