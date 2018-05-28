package com.niit.utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Properties;

public class MyConnect {
	Properties prop = new Properties();
    InputStream input = null;
 
public Connection getConn()
{
	
	Connection con=null;
	   try {

	        input = new FileInputStream("H://database.properties");
	        
	        // load a properties file
	        prop.load(input);
	        String driver=prop.getProperty("driver");
	        String url=prop.getProperty("url");
	        String uname=prop.getProperty("dbuser");
	        String pname=prop.getProperty("dbpassword");
	        String dbname=prop.getProperty("db_name");
	        // get the property value and print it out
	       Class.forName(driver);
	        con=DriverManager.getConnection(url+dbname,uname,pname);
	       System.out.println("Connect Successfully");

	    } catch (Exception ex) {
	    	System.out.println(ex);
	    }

	return con;
}
public static void main(String[] args) {
	Connection con=new MyConnect().getConn();
	
}
}

