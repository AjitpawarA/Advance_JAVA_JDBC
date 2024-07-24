package TransactionManagement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class transaction_Managemnt {
	public static void main(String[] args) {
		Connection con = connectionPool.getConnectionObject();
		
		String bookinfo= "INSERT INTO book_info VALUES(1,'AIR-IND','BLR','US')";
		
		String pass_1_info="INSERT INTO passangerinfo VALUES(1,'priya',22,'female')";
		String pass_2_info="INSERT INTO passangerinfo VALUES(2,'neha',42,'male')";
		String pass_3_info="INSERT INTO passangerinfo VALUES(3,'ajit',24,'male')";
		
		String payinfo="INSERT INTO paymentinfo VALUES(1,1,250000,7000,'requested')";
		
		try {
			
			con.setAutoCommit(false);
			
			Statement s1 = con.createStatement();
			s1.execute(bookinfo);
			
			Statement s2 = con.createStatement();
			s2.execute(pass_1_info);
			
			Statement s3 = con.createStatement();
			s3.execute(pass_2_info);
			
			Statement s4 = con.createStatement();
			s4.execute(pass_3_info);
			
			if(paymantGateway.isSucess()) {
				Statement s5 = con.createStatement();
				s5.execute(payinfo);
				con.commit();
				System.out.println("Transaction sucessful ...");
			}
			else {
				con.rollback();
				System.out.println("Payment failed , Transacion rollback");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
		
	}
}
