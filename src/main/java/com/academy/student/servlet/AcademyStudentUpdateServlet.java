package com.academy.student.servlet;

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

import com.academy.student.dao.AcademyStudentDAO;
import com.academy.student.dto.AcademyStudent;

/**
 * Servlet implementation class AcademyStudentServlet
 */
@WebServlet("/home/students/update")
public class AcademyStudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AcademyStudentDAO academyStudentDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcademyStudentUpdateServlet() {
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
			case "/home/students/update":
				update(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		long id = Long.parseLong(request.getParameter("id"));
		String rollNo = request.getParameter("rollNo");
		String studentName = request.getParameter("studentName");
		String email = request.getParameter("email");
		long classId = Long.parseLong(request.getParameter("classId"));
		AcademyStudent student = new AcademyStudent(rollNo, studentName, email, classId);
		student.setId(id);
		if(validate(request, response, student)) {
			try {
				academyStudentDAO.update(student);
				response.sendRedirect(request.getContextPath() + "/home/students/list");
			} catch (Exception e) {
				request.setAttribute("academyStudent", student);
				request.setAttribute("errors", e.getCause());
				request.getRequestDispatcher("/home/students/edit").forward(request, response);
			}
		}

	}

	private boolean validate(HttpServletRequest request, HttpServletResponse response, AcademyStudent student)
			throws ServletException, IOException {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<AcademyStudent>> constraintViolations = validator.validate(student);
		if (constraintViolations.isEmpty()) {
			return true;
		}
		
		String errors = "<ul style=\"display: inline-block; text-align: left;\">";
		for (ConstraintViolation<AcademyStudent> constraintViolation : constraintViolations) {
			errors += "<li>" + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage()
					+ "</li>";
		}
		errors += "</ul>";
		
		request.setAttribute("academyStudent", student);
		request.setAttribute("errors", errors);
		request.getRequestDispatcher("/home/students/edit").forward(request, response);
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
