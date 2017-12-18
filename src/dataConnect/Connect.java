package dataConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
 
public class Connect {
 
 // connect to MySQL.
 public  Connection getMySQLConnection() throws SQLException,
         ClassNotFoundException {
//     String hostName = "localhost";
// 
//     String dbName = "jobs";
//     String userName = "root";
//     String password = "iwatani";
	 
	 ReadPropertiesLibrary readPropertiesLibrary = new ReadPropertiesLibrary();
	 Properties properties = readPropertiesLibrary.readFileProperties();
	 
	 	String hostName = properties.getProperty("hostName");
		String dbName = properties.getProperty("dbName");
		String userName = properties.getProperty("userName");
		String password = properties.getProperty("password");
 
     return getMySQLConnection(hostName, dbName, userName, password);
 }
 
 public  Connection getMySQLConnection(String hostName, String dbName,
        String userName, String password) throws SQLException,
        ClassNotFoundException {

	 	Class.forName("com.mysql.jdbc.Driver");
	 	// examp;e: jdbc:mysql://localhost:3306/simplehr
	 	String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
//	 	String connectionURL = "jdbc:mysql://" + hostName + "/" + dbName;
	 	String unicode = "?useUnicode=true&characterEncoding=utf8";
	 	Connection conn = DriverManager.getConnection(connectionURL+unicode, userName,password);
	 	return conn;
 }


}