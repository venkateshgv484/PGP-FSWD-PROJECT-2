package com.academy.login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.academy.utils.DataUtils;

/**
 * Servlet implementation class AcademySubjectServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/login":
				login(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String errors = "";
		
		if(username == null || username.isEmpty()) {
			errors += "<li>" + "Username must be entered" + "</li>";
		}
		
		if(password == null || password.isEmpty()) {
			errors += "<li>" + "Password must be entered" + "</li>";
		}
		
		if(!errors.isEmpty()) {
			errors = "<ul style=\"display: inline-block; text-align: left;\">" + errors;
			errors += "</ul>";
			
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else if (username.equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("sessionId", session.getId());
			response.sendRedirect("home");
			DataUtils.loadSampleData();
		} else {
			errors = "<ul style=\"display: inline-block; text-align: left;\">";
			errors += "<li>" + "Invalid username and password" + "</li>";
			errors += "<li>" + "HINT: Password should be same as username" + "</li>";
			errors += "</ul>";
			
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
