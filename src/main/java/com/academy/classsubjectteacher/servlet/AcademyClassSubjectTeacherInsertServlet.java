package com.academy.classsubjectteacher.servlet;

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

import com.academy.classsubjectteacher.dao.AcademyClassSubjectTeacherDAO;
import com.academy.classsubjectteacher.dto.AcademyClassSubjectTeacher;

/**
 * Servlet implementation class AcademyClassServlet
 */
@WebServlet("/home/classes/assignment/insert")
public class AcademyClassSubjectTeacherInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AcademyClassSubjectTeacherDAO academyClassSubjectTeacherDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcademyClassSubjectTeacherInsertServlet() {
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
			case "/home/classes/assignment/insert":
				insert(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		long classId = Long.parseLong(request.getParameter("classId"));
		long subjectId = Long.parseLong(request.getParameter("subjectId"));
		long teacherId = Long.parseLong(request.getParameter("teacherId"));
		AcademyClassSubjectTeacher newClassSubjectTeacher = new AcademyClassSubjectTeacher(classId, subjectId, teacherId);
		if(validate(request, response, newClassSubjectTeacher)) {
			try {
				academyClassSubjectTeacherDAO.insert(newClassSubjectTeacher);
				response.sendRedirect(request.getContextPath() + "/home/classes/assignment/list?classId=" + request.getParameter("classId"));
			} catch (Exception e) {
				request.setAttribute("academyClassSubjectTeacher", newClassSubjectTeacher);
				request.setAttribute("errors", e.getCause());
				request.getRequestDispatcher("/home/classes/assignment/new").forward(request, response);
			}
		}
	}

	private boolean validate(HttpServletRequest request, HttpServletResponse response, AcademyClassSubjectTeacher academyClassSubjectTeacher)
			throws ServletException, IOException {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<AcademyClassSubjectTeacher>> constraintViolations = validator.validate(academyClassSubjectTeacher);
		if (constraintViolations.isEmpty()) {
			return true;
		}
		
		String errors = "<ul style=\"display: inline-block; text-align: left;\">";
		for (ConstraintViolation<AcademyClassSubjectTeacher> constraintViolation : constraintViolations) {
			errors += "<li>" + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage()
					+ "</li>";
		}
		errors += "</ul>";
		
		request.setAttribute("academyClassSubjectTeacher", academyClassSubjectTeacher);
		request.setAttribute("errors", errors);
		request.getRequestDispatcher("/home/classes/assignment/new").forward(request, response);
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
