package com.academy.subject.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/home/subjects/list")
public class AcademySubjectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AcademySubjectDAO academySubjectDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcademySubjectListServlet() {
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
			case "/home/subjects/list":
				list(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AcademySubject> academySubjectList = academySubjectDAO.listAllSubjects();
		request.setAttribute("academySubjectList", academySubjectList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("subject-list.jsp");
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
