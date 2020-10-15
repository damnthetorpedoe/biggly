package org.app.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.app.DAO.UserDAO;
import org.app.exception.BusinessException;
import org.app.model.user.User;
import org.app.utilities.DAOUtilities;

/**
 * Servlet implementation class UpdateUserInfoServlet
 */
public class UpdateUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		String userId = request.getParameter("userId");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDAO dao = DAOUtilities.getUserDAO();
		User user=null;
		try {
			user = dao.getUserByUsernamePassword(username, password);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(user != null) {
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setContact(Long.parseLong(request.getParameter("price")));
			request.setAttribute("user", user);
		try {
			isSuccess = dao.updateUser(user);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}} 
		else {
		isSuccess = false;
		}
		
		if(isSuccess) {
			request.getSession().setAttribute("message", "Customer information successfully updated!");
			response.sendRedirect("ViewUserDetails?userId=" + userId);
		}
		else {
			request.getSession().setAttribute("message", "We're sorry. We experienced an error updated your customer information.");
			request.getRequestDispatcher("userDetails.html").forward(request, response);

		}
	}
}