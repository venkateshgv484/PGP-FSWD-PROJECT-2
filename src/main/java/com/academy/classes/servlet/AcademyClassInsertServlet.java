package com.academy.classes.servlet;

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

import com.academy.classes.dao.AcademyClassDAO;
import com.academy.classes.dto.AcademyClass;

/**
 * Servlet implementation class AcademyClassServlet
 */
@WebServlet("/home/classes/insert")
public class AcademyClassInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AcademyClassDAO academyClassDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcademyClassInsertServlet() {
		super();
		academyClassDAO = new AcademyClassDAO();
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
			case "/home/classes/insert":
				insert(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String classCode = request.getParameter("classCode");
		String className = request.getParameter("className");
		AcademyClass newClass = new AcademyClass(classCode, className);
		if(validate(request, response, newClass)) {
			try {
				academyClassDAO.insert(newClass);
				response.sendRedirect(request.getContextPath() + "/home/classes/list");
			} catch (Exception e) {
				request.setAttribute("academyClass", newClass);
				request.setAttribute("errors", e.getCause());
				request.getRequestDispatcher("/home/classes/new").forward(request, response);
			}
		}
	}

	private boolean validate(HttpServletRequest request, HttpServletResponse response, AcademyClass academyClass)
			throws ServletException, IOException {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<AcademyClass>> constraintViolations = validator.validate(academyClass);
		if (constraintViolations.isEmpty()) {
			return true;
		}
		
		String errors = "<ul style=\"display: inline-block; text-align: left;\">";
		for (ConstraintViolation<AcademyClass> constraintViolation : constraintViolations) {
			errors += "<li>" + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage()
					+ "</li>";
		}
		errors += "</ul>";
		
		request.setAttribute("academyClass", academyClass);
		request.setAttribute("errors", errors);
		request.getRequestDispatcher("/home/classes/new").forward(request, response);
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
