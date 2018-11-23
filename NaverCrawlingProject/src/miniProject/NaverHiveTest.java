package miniProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NaverHiveTest {

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con = DriverManager.getConnection("jdbc:hive2://127.0.0.1:10000/movie", "", "");
		Statement stmt = con.createStatement();
		ResultSet res = stmt.executeQuery("select * from navermovie order by name");
		while(res.next()){
			System.out.println(res.getString(1) + " " + res.getInt(2) + " " + res.getString(3));
		}
	}
}