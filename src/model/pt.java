package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ShortCase.dbConnection;

public class pt extends user{
	
	
    dbConnection connDb = new dbConnection();
	PreparedStatement preparedStatement = null;
	Statement st = null;
	ResultSet rs = null;
	Connection con = connDb.conn();

	
	
	public pt() {}

public pt(String name, String surname, int ssn, String password, int age, int height, int weight, int fat,
			int muscle, String payment, String expiration, String position, String workout) {
		super(name, surname, ssn, password, age, height, weight, fat, muscle, workout); // payment, expiration, position);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<user> getMemberList() throws SQLException{
		ArrayList<user> list = new ArrayList<>();
		
		Statement st = null;
		ResultSet rs = null;
		Connection con = connDb.conn();
		user obj;
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM member WHERE position = 'member'");
			while(rs.next()) {
				obj = new user (rs.getString("name"), rs.getString("surname"), 
						rs.getInt("ssn"), rs.getString("password"), rs.getInt("age"), 
						rs.getInt("height"), rs.getInt("weight"), rs.getInt("fat"),
						rs.getInt("muscle"), rs.getString("workout")); /*, rs.getString("payment"), rs.getString("expiration"),
						rs.getString("position"));*/
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
	
	
public boolean memberRegister(String name, String surname,int age, int height, int weight, int fat,
		int muscle, int ssn, String password) throws SQLException {
		
		int key = 0;
		int count = 0;
		String query = "INSERT INTO member" + "(name, surname, age, height, weight, fat, muscle, ssn, password, position) VALUES" + "(?,?,?,?,?,?,?,?,?,?)";
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
				preparedStatement.setInt(3, age);
				preparedStatement.setInt(4, height);
				preparedStatement.setInt(5, weight);
				preparedStatement.setInt(6, fat);
				preparedStatement.setInt(7, muscle);
				preparedStatement.setInt(8, ssn);
				preparedStatement.setString(9, password);
				preparedStatement.setString(10, "member");
				
			


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
/*
public boolean addMember(String name, String surname, int ssn, String password) {
	
	String query = "INSERT INTO member" + "(name, surname, ssn, password, position) VALUES" + "(?,?,?,?,?)";
	boolean key = false;
	try {
		st = con.createStatement();
		preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, surname);
		preparedStatement.setInt(3, ssn);
		preparedStatement.setString(4, password);
		preparedStatement.setString(5, "member");

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

	 */

public boolean deleteMember(int ssn) throws SQLException{
	
	String query = "DELETE FROM member WHERE  ssn = ?";
	boolean key = false;
	try {
		st = con.createStatement();
		preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1, ssn);
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


public boolean editMember(int ssn, String name, String surname,int age, int height, int weight, int fat,
		int muscle, String password) throws SQLException {
	
	String query = "UPDATE member SET name = ?, surname = ?, password = ?, age = ?, height = ?, weight = ?, fat = ?, muscle = ? WHERE ssn = ?";
	boolean key = false;
	try {
		st = con.createStatement();
		preparedStatement = con.prepareStatement(query);
		
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, surname);		
		preparedStatement.setString(3, password);
		preparedStatement.setInt(4, age);
		preparedStatement.setInt(5, height);
		preparedStatement.setInt(6, weight);
		preparedStatement.setInt(7, fat);
		preparedStatement.setInt(8, muscle);
		preparedStatement.setInt(9, ssn);
		

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



}
