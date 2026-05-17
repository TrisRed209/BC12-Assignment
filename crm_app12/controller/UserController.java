package crm_app12.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm_app12.UserEntity;
import crm_app12.services.UserServices;

@WebServlet(name = "userController", urlPatterns = {"/user"})
public class UserController extends HttpServlet {
	
	private UserServices userServices = new UserServices();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<UserEntity> listUserEntities = userServices.getAll();
		
		req.setAttribute("listUsers", listUserEntities);				
		
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
		req.getRequestDispatcher("user-table.jsp").forward(req, resp);
	}

}
