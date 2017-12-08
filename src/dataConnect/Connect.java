package dataConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 
public class Connect {
 
 // connect to MySQL.
 public  Connection getMySQLConnection() throws SQLException,
         ClassNotFoundException {
     String hostName = "localhost";
 
     String dbName = "jobs";
     String userName = "root";
     String password = "iwatani";
 
     return getMySQLConnection(hostName, dbName, userName, password);
 }
 
 public  Connection getMySQLConnection(String hostName, String dbName,
        String userName, String password) throws SQLException,
        ClassNotFoundException {

	 	Class.forName("com.mysql.jdbc.Driver");
	 	// examp;e: jdbc:mysql://localhost:3306/simplehr
	 	String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
	 	String unicode = "?useUnicode=true&characterEncoding=utf8";
	 	Connection conn = DriverManager.getConnection(connectionURL+unicode, userName,password);
	 	return conn;
 }


}