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
@WebServlet("/home/subjects/update")
public class AcademySubjectUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AcademySubjectDAO academySubjectDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcademySubjectUpdateServlet() {
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
			case "/home/subjects/update":
				update(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		long id = Long.parseLong(request.getParameter("id"));
		String subjectCode = request.getParameter("subjectCode");
		String subjectName = request.getParameter("subjectName");
		AcademySubject subject = new AcademySubject(subjectCode, subjectName);
		subject.setId(id);
		if(validate(request, response, subject)) {
			try {
				academySubjectDAO.update(subject);
				response.sendRedirect(request.getContextPath() + "/home/subjects/list");
			} catch (Exception e) {
				request.setAttribute("academySubject", subject);
				request.setAttribute("errors", e.getCause());
				request.getRequestDispatcher("/home/subjects/edit").forward(request, response);
			}
		}
	}

	private boolean validate(HttpServletRequest request, HttpServletResponse response, AcademySubject subject)
			throws ServletException, IOException {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<AcademySubject>> constraintViolations = validator.validate(subject);
		if (constraintViolations.isEmpty()) {
			return true;
		}
		
		String errors = "<ul style=\"display: inline-block; text-align: left;\">";
		for (ConstraintViolation<AcademySubject> constraintViolation : constraintViolations) {
			errors += "<li>" + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage()
					+ "</li>";
		}
		errors += "</ul>";
		
		request.setAttribute("academySubject", subject);
		request.setAttribute("errors", errors);
		request.getRequestDispatcher("/home/subjects/edit").forward(request, response);
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
