package com.academy.teacher.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.academy.teacher.dao.AcademyTeacherDAO;
import com.academy.teacher.dto.AcademyTeacher;

/**
 * Servlet implementation class AcademyTeacherServlet
 */
@WebServlet("/home/teachers/edit")
public class AcademyTeacherEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AcademyTeacherDAO academyTeacherDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcademyTeacherEditServlet() {
		super();
		academyTeacherDAO = new AcademyTeacherDAO();
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
			case "/home/teachers/edit":
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
		if(request.getAttribute("academyTeacher") == null) {
			AcademyTeacher existingTeacher = academyTeacherDAO.getTeaccher(id);
			request.setAttribute("academyTeacher", existingTeacher);
		}
		request.setAttribute("isNew", false);
		RequestDispatcher dispatcher = request.getRequestDispatcher("teacher-form.jsp");
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
