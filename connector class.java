import java.sql.*;

class sql {
public static void main(String args[]) {
try {
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books?characterEncoding=latin1S", "*your username*", "*your password*");
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("select * from books");

while (rs.next())
System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) +
" " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));

con.close();
} catch (Exception e) {
System.out.println(e);
}
}
}