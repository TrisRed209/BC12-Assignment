package crm_app12.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import crm_app12.MysqlConfig;
import crm_app12.UserEntity;

/**
 * Manage all query related to user tbl
 */

public class UserRepository {

	/**
	 * SELECT -> find 
	 * WHERE -> BY
	 * username = '' -> userName
	 * 
	 * ví dụ: SELECT * FROM user WHERE username = ''
	 * -> findByUsername();
	 *  
	 */
	
	public List<UserEntity> findAll() {
		
		/** 
		 * b1: Chuẩn bị câu truy vấn
		 * b2: Mở kết nối CSDL (viết thành hàm để tái sử dụng)
		 * b3: truyền câu vấn vào kết nối vừa mở và truyền tham số (nếu có).
		 * b4: thực thi câu query
		 */
		
		List<UserEntity> listUserEntities = new ArrayList<UserEntity>();
		

		
		try {
			
			//b1: Chuẩn bị câu truy vấn
			String query = "SELECT \r\n"
					+ "    u.id,\r\n"
					+ "    u.first_name,\r\n"
					+ "    u.last_name,\r\n"
					+ "    u.email,\r\n"
					+ "    r.name AS role_name\r\n"
					+ "FROM users u\r\n"
					+ "JOIN roles r ON u.role_id = r.id";
			
			//Bước 2: Mở kết nối tói CSDL
			Connection connection = MysqlConfig.getConnection();
			
			//Bước 3: truyền query vào keeys nối
			PreparedStatement statement = connection.prepareStatement(query);
			
			//bước 4: thực thi câu truy vấn
			//executeQuery: Khi query SELECT
			//executeUpdate: khi query KHÔNG phải SELECT
			ResultSet resultSet = statement.executeQuery();
			
	        while(resultSet.next()) {

	            UserEntity userEntity = new UserEntity();

	            userEntity.setId(resultSet.getInt("id"));
	            userEntity.setFirstname(resultSet.getString("first_name"));
	            userEntity.setLastname(resultSet.getString("last_name"));
	            userEntity.setEmail(resultSet.getString("email"));
	            userEntity.setRolename(resultSet.getString("role_name"));

	            listUserEntities.add(userEntity);
	        }

	    } catch (Exception e) {
	        System.out.println("Loi findAll " + e.getMessage());
	    }

	    return listUserEntities;
	}
	
	public UserEntity findUserByEmailandPassword(String email, String password) {
		
		try {
			
			//b1: Chuẩn bị câu truy vấn
			String query = "SELECT * FROM users u\r\n"
					+ "WHERE u.email = ? AND u.password = ?;";
			
			//Bước 2: Mở kết nối tói CSDL
			Connection connection = MysqlConfig.getConnection();
			
			//Bước 3: truyền query vào keeys nối
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, email);
			statement.setString(2, password);
			
			//bước 4: thực thi câu truy vấn
			//executeQuery: Khi query SELECT
			//executeUpdate: khi query KHÔNG phải SELECT
			ResultSet resultSet = statement.executeQuery();
			
	        while(resultSet.next()) {

	            UserEntity userEntity = new UserEntity();

	            userEntity.setId(resultSet.getInt("id"));
	            userEntity.setEmail(resultSet.getString("email"));
	            userEntity.setPassword(resultSet.getString("password"));
	            
	            return userEntity;

	        }
			
			
		} catch (Exception e) {
			System.out.println("Lỗi login" + e.getMessage());
		}
		
	return null;
	}
	
	
	
}