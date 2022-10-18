package com.academy.subject.servlet;

import java.io.IOException;

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
@WebServlet("/home/subjects/edit")
public class AcademySubjectEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AcademySubjectDAO academySubjectDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcademySubjectEditServlet() {
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
			case "/home/subjects/edit":
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
		if(request.getAttribute("academySubject") == null) {
			AcademySubject existingSubject = academySubjectDAO.getSubject(id);
			request.setAttribute("academySubject", existingSubject);
		}
		request.setAttribute("isNew", false);
		RequestDispatcher dispatcher = request.getRequestDispatcher("subject-form.jsp");
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
