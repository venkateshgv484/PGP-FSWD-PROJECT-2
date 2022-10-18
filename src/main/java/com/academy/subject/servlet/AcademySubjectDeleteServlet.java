package com.academy.subject.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.academy.subject.dao.AcademySubjectDAO;
import com.academy.subject.dto.AcademySubject;

/**
 * Servlet implementation class AcademySubjectServlet
 */
@WebServlet("/home/subjects/delete")
public class AcademySubjectDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AcademySubjectDAO academySubjectDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcademySubjectDeleteServlet() {
		super();
		academySubjectDAO = new AcademySubjectDAO();
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
			case "/home/subjects/delete":
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
			AcademySubject subject = academySubjectDAO.getSubject(id);
			academySubjectDAO.delete(subject);
			response.sendRedirect(request.getContextPath() + "/home/subjects/list");
		} catch (Exception e) {
			request.setAttribute("errors", e.getCause());
			request.getRequestDispatcher("/home/subjects/list").forward(request, response);
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
