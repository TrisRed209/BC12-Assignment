package crm_app12;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConfig {

//	//Hàm mở kết nối tới CSDL
//	public static Connection getConnection() {
//		
//		try {
//			String url = "jbdc:mysql://localhost:3307/crm_app";
//			String username = "root";
//			String password = "admin123";
//			
//			
//			Class.forName("com.mysql.cj.jbdc.Driver");
//			return DriverManager.getConnection(url, username, password);
//		} catch (Exception e){
//			System.out.println("getConnection" + e.getMessage());
//		}
//		
//		return null;

	// Hàm mở kết nối tới CSDL
	public static Connection getConnection() {
		try {
			String url = "jdbc:mysql://localhost:3307/crm_app";
			String username = "root";
			String password = "Minhtri@2002";

			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("getConnection " + e.getMessage());
		}

		return null;

	}

}
