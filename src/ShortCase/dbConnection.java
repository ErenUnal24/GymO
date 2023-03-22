package ShortCase;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.*;

public class dbConnection {
	
	Connection c = null;
	
	public dbConnection() {}
		
		public Connection conn() {
			
			 final String url = "jdbc:postgresql://localhost/postgres";
			    final String user = "postgres";
			    final String password = "123456";
			
			try {
				this.c = DriverManager.getConnection(url, user, password);
		        System.out.println("Connected to the PostgreSQL server successfully.");


				//return c;
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return c;

		}
	
	
}




/*
public static Connection connect() {

    final String url = "jdbc:postgresql://localhost/postgres";
    final String user = "postgres";
    final String password = "123456";

    Connection conn = null;
    try {
        conn = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to the PostgreSQL server successfully.");
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

    return conn;
}

*/
