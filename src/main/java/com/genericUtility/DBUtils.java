package com.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DBUtils {
	Connection con = null;

	/**
	 * This method is to connect to DB
	 * 
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathConstants.DBURL, IPathConstants.DBUsername, IPathConstants.DBPassword);
	}

	/**
	 * This method will execute query and return data to the user
	 * 
	 * @param query
	 * @param columnIndex
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String query, int columnIndex, String expData) throws Throwable {
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag = false;
		String data = null;
		while (result.next()) {
			data = result.getString(columnIndex);

			if (data.equalsIgnoreCase(expData)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println(data + "---->data verified");
			return expData;
		} else {
			System.out.println("data not verified");
			return "";
		}
	}

	/**
	 * This method used to close DB
	 * 
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		con.close();
	}

}
