package CRUDb;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class UserDao {

	String URL = "jdbc:sqlserver://sql6005.site4now.net;\" + \"databasename = DB_A44BEF_ilimsky; user = DB_A44BEF_ilimsky_admin; password = P@ssw0rd";
	Connection con = null;
	ResultSet rs = null;
	UserDao() {
		String connectionUrl = URL;
		try {
			con = DriverManager.getConnection(connectionUrl);
			if (con != null){
				System.out.println("Success");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void consult(DefaultTableModel model, String user) {
		int numberFields = 4;
		Object[] row = new Object[numberFields];
		String SQL = null;

		if(user == null) {
			SQL = "SELECT * FROM dbo.Ilim";
		}
		else {
			SQL = "SELECT * FROM dbo.Ilim where userID = '" + user + "'";
		}

		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				for (int i = 0; i < numberFields; i++)
					row[i] = rs.getObject(i + 1);
				model.addRow(row);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void insert(String profile, String user, String name, String surname) {
		String SQL = "INSERT INTO dbo.Ilim(profile, userID, name, surname)values('"+profile+"','"+user+"','"+name+"','"+surname+"')";
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.execute(SQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(String user_before, String profile, String user, String name, String surname) {
		String SQL = "UPDATE dbo.Ilim "
				+ "SET profile = '"+profile+"',"
				+ "userID = '"+user+"',"
				+ "name = '"+name+"',"
				+ "surname = '"+surname+"'"
				+ "where userID = '"+user_before+"'";
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.execute(SQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void remove(String user) {
		String SQL = "DELETE FROM dbo.Ilim"
				+ "where userID = '"+user+"'";
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.execute(SQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}