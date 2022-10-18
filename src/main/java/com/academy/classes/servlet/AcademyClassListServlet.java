package com.academy.classes.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.academy.classes.dao.AcademyClassDAO;
import com.academy.classes.dto.AcademyClass;

/**
 * Servlet implementation class AcademyClassServlet
 */
@WebServlet("/home/classes/list")
public class AcademyClassListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AcademyClassDAO academyClassDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcademyClassListServlet() {
		super();
		academyClassDAO = new AcademyClassDAO();
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
			case "/home/classes/list":
				list(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AcademyClass> academyClassList = academyClassDAO.listAllClasses();
		request.setAttribute("academyClassList", academyClassList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("class-list.jsp");
		dispatcher.forward(request, response);
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
