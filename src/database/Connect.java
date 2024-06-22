package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	private Connection con;
	private String jdb_url="jdbc:mysql://localhost:3306/book_inventory";
	private String username="root";
	private String password="password";
	
	public Connect() {
		connect();
	}
	
	private void connect() {
		try {
			con=DriverManager.getConnection(jdb_url,username,password);
			System.out.println("connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return con;
	}

}
