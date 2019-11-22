/*
 * 1. Use eclipse (preferably)
 * 2. Copy "mysql-connector.jar" to jdk path "\Java\jdk1.8.0_171\jer\lib\ext"
 * 3. Compile and run "Connector.java"
 */

package project2;

import java.sql.*;
import java.util.Scanner;

class Connector {
	private static Scanner login;
	private static String username;
	private static String pswrd;

	public static void main(String args[]) {
		login = new Scanner(System.in);
		
		
		
		System.out.println("Enter your username: ");
		username = login.nextLine();
		System.out.println("Enter your password: ");
		pswrd = login.nextLine();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books?characterEncoding=latin1", username, pswrd);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from books");
			
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + 
						"  " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6) + "  " + rs.getString(7));
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
