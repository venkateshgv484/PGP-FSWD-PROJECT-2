package com.academy.classes.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.academy.classes.dao.AcademyClassDAO;
import com.academy.classes.dto.AcademyClass;
import com.academy.classsubjectteacher.dao.AcademyClassSubjectTeacherDAO;

/**
 * Servlet implementation class AcademyClassServlet
 */
@WebServlet("/home/classes/delete")
public class AcademyClassDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AcademyClassDAO academyClassDAO;
	private AcademyClassSubjectTeacherDAO academyClassSubjectTeacherDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcademyClassDeleteServlet() {
		super();
		academyClassDAO = new AcademyClassDAO();
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
			case "/home/classes/delete":
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
			AcademyClass academyClass = academyClassDAO.getClass(id);
			academyClassDAO.delete(academyClass);
			academyClassSubjectTeacherDAO.deleteByClassId(id);
			response.sendRedirect(request.getContextPath() + "/home/classes/list");
		} catch (Exception e) {
			request.setAttribute("errors", e.getCause());
			request.getRequestDispatcher("/home/classes/list").forward(request, response);
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
