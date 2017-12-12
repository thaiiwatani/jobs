package dataConnect;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class ReadPropertiesLibrary {
	
	public Properties readFileProperties(){
//		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		Properties properties = new Properties();
		try {
//			properties.load(classLoader.getResourceAsStream("..\\config.properties"));
//			properties.load(new FileReader(new File("./config.properties")));
			properties.load(new FileReader(new File("config.properties")));
			
			String hostName = properties.getProperty("hostName");
			String dbName = properties.getProperty("dbName");
			String userName = properties.getProperty("userName");
			String password = properties.getProperty("password");
//			System.out.println("‚“‚„‚‡‚“‚„‚“‚„‚“‚“‚“‚“‚“‚“‚“‚“‚“‚“‚“‚“‚“‚“‚“‚“‚“‚“‚“‚“‚“‚“‚“");
		} catch (Exception e) {
			System.out.println("abcb"+e.getMessage());
			
		}
		return properties; 
	}
}