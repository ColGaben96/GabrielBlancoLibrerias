package co.edu.unbosque.model;

import java.sql.*;

public class Database {
	private Connection db;
	private Statement status;
	private ResultSet result;
	public Database() {
		//JOptionPane.showMessageDialog(null, "Este programa usa conexi�n a internet. Los cambios en los datos se demoran de acuerdo a la velocidad de internet.\nCuando est� listo pulse el bot�n para continuar", "Advertencia", JOptionPane.WARNING_MESSAGE, null);
		Thread connect2DB = new Thread() {
			@Override
			public void run() {
				try {
					String url = "jdbc:mysql://remotemysql.com:3306/u1eDZqJ2oP";
					String user = "u1eDZqJ2oP";
					String pass = "946E388ojx";
					Class.forName("com.mysql.cj.jdbc.Driver");
					db = DriverManager.getConnection(url, user, pass);
					status = db.createStatement();
					System.out.println("Connected Successfuly!");
					
				} catch (Exception e) {
					System.out.println("Can't connect! Please check your internet connection and try again. If problem the persists consult with your network administrator to solve the problem\n"
							+ ""+e.getMessage());
				}
			}
		};
		connect2DB.start();
	}
	public String closeConnection() throws Exception {
		String msg = "";
		db.close();
		msg = "Connection Closed!";
		return msg;
	}
	public String insertReport(String Country, int ID, String Date, int ActiveCases, int RecoveredCases, int NewCases, int DeathReported, int TotalDeaths, int TotalCases) throws Exception {
		String msg = "";
		try {
			int myresult = status.executeUpdate("INSERT INTO `"+Country+"`(`ID`, `Date`, `ActiveCases`, `RecoveredCases`, `NewCases`, `DeathReported`, `TotalDeaths`, `TotalCases`) VALUES (+"+ID+",'"+Date+"',"+ActiveCases+","+RecoveredCases+","+NewCases+","+DeathReported+","+TotalDeaths+","+TotalCases+")");
			System.out.println(myresult);
		} catch (Exception e) {
			System.out.println("Can't connect! Please check your internet connection and try again. If problem the persists consult with your network administrator to solve the problem\n"
					+ ""+e.getMessage());
		}
		return msg;
	}
	public String deleteReport(String Country, int ID) throws Exception {
		String msg = "";
		try {
			int myresult = status.executeUpdate("DELETE FROM '"+Country+"' WHERE ID = "+ID);
			System.out.println(myresult);
		} catch (Exception e) {
			System.out.println("Can't connect! Please check your internet connection and try again. If problem the persists consult with your network administrator to solve the problem\n"
					+ ""+e.getMessage());
		}
		return msg;
	}
	public String getDate(String Country) throws Exception {
		String msg = "";
		try {
			result = status.executeQuery("SELECT * FROM "+Country);
			while(result.next()) {
				msg += result.getString("Date")+"\n";
			}
		} catch (Exception e) {
			System.out.println("Can't connect! Please check your internet connection and try again. If problem the persists consult with your network administrator to solve the problem\n"
					+ ""+e.getMessage());
		}
		return msg;
	}
	public String getActiveCases(String Country) throws Exception {
		String msg = "";
		try {
			result = status.executeQuery("SELECT * FROM "+Country);
			while(result.next()) {
				msg += result.getString("ActiveCases")+"\n";
			}
		} catch (Exception e) {
			System.out.println("Can't connect! Please check your internet connection and try again. If problem the persists consult with your network administrator to solve the problem\n"
					+ ""+e.getMessage());
		}
		return msg;
	}
	public String getRecoveredCases(String Country) throws Exception {
		String msg = "";
		try {
			result = status.executeQuery("SELECT * FROM "+Country);
			while(result.next()) {
				msg += result.getString("RecoveredCases")+"\n";
			}
		} catch (Exception e) {
			System.out.println("Can't connect! Please check your internet connection and try again. If problem the persists consult with your network administrator to solve the problem\n"
					+ ""+e.getMessage());
		}
		return msg;
	}
	public String getNewCases(String Country) throws Exception {
		String msg = "";
		try {
			result = status.executeQuery("SELECT * FROM "+Country);
			while(result.next()) {
				msg += result.getString("NewCases")+"\n";
			}
		} catch (Exception e) {
			System.out.println("Can't connect! Please check your internet connection and try again. If problem the persists consult with your network administrator to solve the problem\n"
					+ ""+e.getMessage());
		}
		return msg;
	}
	public String getDeathReported(String Country) throws Exception {
		String msg = "";
		try {
			result = status.executeQuery("SELECT * FROM "+Country);
			while(result.next()) {
				msg += result.getString("DeathReported")+"\n";
			}
		} catch (Exception e) {
			System.out.println("Can't connect! Please check your internet connection and try again. If problem the persists consult with your network administrator to solve the problem\n"
					+ ""+e.getMessage());
		}
		return msg;
	}
	public String getTotalDeaths(String Country) throws Exception {
		String msg = "";
		try {
			result = status.executeQuery("SELECT * FROM "+Country);
			while(result.next()) {
				msg += result.getString("TotalDeaths")+"\n";
			}
		} catch (Exception e) {
			System.out.println("Can't connect! Please check your internet connection and try again. If problem the persists consult with your network administrator to solve the problem\n"
					+ ""+e.getMessage());
		}
		return msg;
	}
	public String getTotalCases(String Country) throws Exception {
		String msg = "";
		try {
			result = status.executeQuery("SELECT * FROM "+Country);
			while(result.next()) {
				msg += result.getString("TotalCases")+"\n";
			}
		} catch (Exception e) {
			System.out.println("Can't connect! Please check your internet connection and try again. If problem the persists consult with your network administrator to solve the problem\n"
					+ ""+e.getMessage());
		}
		return msg;
	}
}
