package com.academy.subject.servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.academy.subject.dao.AcademySubjectDAO;
import com.academy.subject.dto.AcademySubject;

/**
 * Servlet implementation class AcademySubjectServlet
 */
@WebServlet("/home/subjects/insert")
public class AcademySubjectInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AcademySubjectDAO academySubjectDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcademySubjectInsertServlet() {
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
			case "/home/subjects/insert":
				insert(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subjectCode = request.getParameter("subjectCode");
		String subjectName = request.getParameter("subjectName");
		AcademySubject newSubject = new AcademySubject(subjectCode, subjectName);
		if(validate(request, response, newSubject)) {
			try {
				academySubjectDAO.insert(newSubject);
				response.sendRedirect(request.getContextPath() + "/home/subjects/list");
			} catch (Exception e) {
				request.setAttribute("academySubject", newSubject);
				request.setAttribute("errors", e.getCause());
				request.getRequestDispatcher("/home/subjects/new").forward(request, response);
			}
		}
	}

	private boolean validate(HttpServletRequest request, HttpServletResponse response, AcademySubject newSubject)
			throws ServletException, IOException {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<AcademySubject>> constraintViolations = validator.validate(newSubject);
		if (constraintViolations.isEmpty()) {
			return true;
		}
		
		String errors = "<ul style=\"display: inline-block; text-align: left;\">";
		for (ConstraintViolation<AcademySubject> constraintViolation : constraintViolations) {
			errors += "<li>" + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage()
					+ "</li>";
		}
		errors += "</ul>";
		
		request.setAttribute("academySubject", newSubject);
		request.setAttribute("errors", errors);
		request.getRequestDispatcher("/home/subjects/new").forward(request, response);
		return false;
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
