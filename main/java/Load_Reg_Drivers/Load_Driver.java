package Load_Reg_Drivers;

public class Load_Driver {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded sucessfully");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}
}
