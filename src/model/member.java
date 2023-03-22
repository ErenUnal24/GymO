package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ShortCase.dbConnection;

//import model.*;

public class member extends user{
	
	Statement st = null;
	ResultSet rs = null;
    dbConnection connDb = new dbConnection();
	PreparedStatement preparedStatement = null;
	Connection con = connDb.conn();


	public member() {
				
	}
	
	public boolean register(String name, String surname, int ssn, String password) {
		
		int key = 0;
		int count = 0;
		String query = "INSERT INTO member" + "(name, surname, ssn, password, position) VALUES" + "(?,?,?,?,?)";
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM  member WHERE ssn = '" + ssn + "'");
			
			while(rs.next()) {
				count = 1;
				break;
			}
			
			if(count == 0) {
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, surname);
				preparedStatement.setInt(3, ssn);
				preparedStatement.setString(4, password);
				preparedStatement.setString(5, "member");

				preparedStatement.executeUpdate();
			}
			
			key = 1;
		
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if (key == 1)
				return true;
			else
				return false;
			
		}
	
	public boolean showExpiration(String expiration) throws SQLException{
		
		String query = "SELECT expiration FROM member";
		boolean key = false;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, expiration);
			preparedStatement.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(key)
			return true;
		else
			return false;
			
		
	}
	
	
	public ArrayList<user> getMember(int ssn) throws SQLException{
		ArrayList<user> list = new ArrayList<>();
		
		Statement st = null;
		ResultSet rs = null;
		Connection con = connDb.conn();
		user obj;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM member WHERE ssn = " + ssn);
			while(rs.next()) {
				obj = new user (rs.getString("name"), rs.getString("surname"), 
						rs.getInt("ssn"), rs.getString("password"), rs.getInt("age"), 
						rs.getInt("height"), rs.getInt("weight"), rs.getInt("fat"),
						rs.getInt("muscle"), rs.getString("workout"));
				list.add(obj);
				
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			st.close();
			rs.close();
			con.close();
		}
		
		return list;
	}

	
	public ArrayList<user> getOneMember() throws SQLException{
		ArrayList<user> list = new ArrayList<>();
		
		Statement st = null;
		ResultSet rs = null;
		Connection con = connDb.conn();
		user obj;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM member WHERE ssn");
			while(rs.next()) {
				obj = new user (rs.getString("name"), rs.getString("surname"), 
						rs.getInt("ssn"), rs.getString("password"), rs.getInt("age"), 
						rs.getInt("height"), rs.getInt("weight"), rs.getInt("fat"),
						rs.getInt("muscle"), rs.getString("workout"));
				list.add(obj);
				
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			st.close();
			rs.close();
			con.close();
		}
		
		return list;
	}
	
	
	
	
	
}
