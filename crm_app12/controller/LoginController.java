package crm_app12.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crm_app12.MysqlConfig;
import crm_app12.UserEntity;
import crm_app12.services.LoginServices;

@WebServlet(name = "loginController", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	LoginServices loginServices = new LoginServices();


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			// b1: Lấy dữ liệu từ jsp
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			// b2: Xử lý login
			UserEntity userEntity = loginServices.checkLogin(email, password);

			// b3: Check user
			if (userEntity != null) {
				// successful case
				System.out.println("Đăng nhập thành công");

			} else {
				System.out.println("Đăng nhập thất bại");
			}

		} catch (Exception e) {
			System.out.println("Mở kết nối " + e.getMessage());
		}

		/**
		 * Chuyển request hiện tại sang file user-table.jsp
		 * JSP sẽ chịu trách nhiệm hiển thị giao diện cho client
		 * Browser gửi request
			        ↓
			Controller nhận request
			        ↓
			doGet() chạy
			        ↓
			forward sang user-table.jsp
			        ↓
			JSP render HTML
			        ↓
			Trả HTML về browser
		 * 
		 */
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

}
