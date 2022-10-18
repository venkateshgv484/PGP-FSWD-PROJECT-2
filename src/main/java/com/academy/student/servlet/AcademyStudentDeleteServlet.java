package com.academy.student.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.academy.student.dao.AcademyStudentDAO;
import com.academy.student.dto.AcademyStudent;

/**
 * Servlet implementation class AcademyStudentServlet
 */
@WebServlet("/home/students/delete")
public class AcademyStudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AcademyStudentDAO academyStudentDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcademyStudentDeleteServlet() {
		super();
		academyStudentDAO = new AcademyStudentDAO();
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
			case "/home/students/delete":
				delete(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		long id = Long.parseLong(request.getParameter("id"));

		try {
			AcademyStudent student = academyStudentDAO.getStudent(id);
			academyStudentDAO.delete(student);
			response.sendRedirect(request.getContextPath() + "/home/students/list");
		} catch (Exception e) {
			request.setAttribute("errors", e.getCause());
			request.getRequestDispatcher("/home/students/list").forward(request, response);
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
