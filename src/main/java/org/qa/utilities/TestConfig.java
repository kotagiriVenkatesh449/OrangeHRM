package org.qa.utilities;

public class TestConfig {

//********* MAIL CONFIG ***********
	public static String server="smtp.gmail.com";
	public static String from = "venkatesh.9692678@gmail.com";
	public static String password = "Selenium@123";
	public static String[] to ={"xyzg@gmail.com","abc@gmail.com"};
	public static String subject = "Extent Project Report";
	
	public static String messageBody ="TestMessage";
	public static String attachmentPath="";
	public static String attachmentName="";
	
//	*********** MYSQL **************
	public static String mysql_driver = "com.mysql.cj.jdbc.Driver";
	public static String mysql_Username="root";
	public static String mysql_Password="password";
	public static String mysql_Url="jdbc:mysql://localhost:3306/sakila";
	
//	 *********** SQL *****************
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://192.101.44.22;DatabaseName=monitor_eval"; 
	public static String dbUserName="root"; 
	public static String dbPassword="password"; 
	
}
