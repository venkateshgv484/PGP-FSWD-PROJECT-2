package com.academy.teacher.servlet;

import java.io.IOException;

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
@WebServlet("/home/teachers/delete")
public class AcademyTeacherDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AcademyTeacherDAO academyTeacherDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcademyTeacherDeleteServlet() {
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
			case "/home/teachers/delete":
				delete(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			long id = Long.parseLong(request.getParameter("id"));
			AcademyTeacher subject = academyTeacherDAO.getTeaccher(id);
			academyTeacherDAO.delete(subject);
			response.sendRedirect(request.getContextPath() + "/home/teachers/list");
		} catch (Exception e) {
			request.setAttribute("errors", e.getCause());
			request.getRequestDispatcher("/home/teachers/list").forward(request, response);
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
