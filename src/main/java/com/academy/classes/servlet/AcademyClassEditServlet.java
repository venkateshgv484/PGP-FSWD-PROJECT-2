package com.academy.classes.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.academy.classes.dao.AcademyClassDAO;
import com.academy.classes.dto.AcademyClass;

/**
 * Servlet implementation class AcademySubjectServlet
 */
@WebServlet("/home/classes/edit")
public class AcademyClassEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AcademyClassDAO academyClassDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcademyClassEditServlet() {
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
			case "/home/classes/edit":
				showEditForm(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		if(request.getAttribute("academyClass") == null) {
			AcademyClass existingClass = academyClassDAO.getClass(id);
			request.setAttribute("academyClass", existingClass);
		}
		request.setAttribute("isNew", false);
		RequestDispatcher dispatcher = request.getRequestDispatcher("class-form.jsp");
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
