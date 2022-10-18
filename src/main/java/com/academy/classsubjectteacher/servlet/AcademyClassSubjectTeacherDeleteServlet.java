package com.academy.classsubjectteacher.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.academy.classsubjectteacher.dao.AcademyClassSubjectTeacherDAO;
import com.academy.classsubjectteacher.dto.AcademyClassSubjectTeacher;

/**
 * Servlet implementation class AcademyClassServlet
 */
@WebServlet("/home/classes/assignment/delete")
public class AcademyClassSubjectTeacherDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AcademyClassSubjectTeacherDAO academyClassSubjectTeacherDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcademyClassSubjectTeacherDeleteServlet() {
		super();
		academyClassSubjectTeacherDAO = new AcademyClassSubjectTeacherDAO();
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
			case "/home/classes/assignment/delete":
				delete(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		long id = Long.parseLong(request.getParameter("id"));
		long classId = Long.parseLong(request.getParameter("classId"));

		try {
			AcademyClassSubjectTeacher academyClassSubjectTeacher = academyClassSubjectTeacherDAO.getClassSubjectTeacher(id);
			academyClassSubjectTeacherDAO.delete(academyClassSubjectTeacher);
			response.sendRedirect(request.getContextPath() + "/home/classes/assignment/list?classId=" + classId);
		} catch (Exception e) {
			request.setAttribute("errors", e.getCause());
			request.getRequestDispatcher(request.getContextPath() + "/home/classes/assignment/list?classId=" + classId).forward(request, response);
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
