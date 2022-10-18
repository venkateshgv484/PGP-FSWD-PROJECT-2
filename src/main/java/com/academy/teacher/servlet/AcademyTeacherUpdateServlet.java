package com.academy.teacher.servlet;

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

import com.academy.teacher.dao.AcademyTeacherDAO;
import com.academy.teacher.dto.AcademyTeacher;

/**
 * Servlet implementation class AcademyTeacherServlet
 */
@WebServlet("/home/teachers/update")
public class AcademyTeacherUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AcademyTeacherDAO academyTeacherDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcademyTeacherUpdateServlet() {
		super();
		academyTeacherDAO = new AcademyTeacherDAO();
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
			case "/home/teachers/update":
				update(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		long id = Long.parseLong(request.getParameter("id"));
		String teacherCode = request.getParameter("teacherCode");
		String teacherName = request.getParameter("teacherName");
		AcademyTeacher teacher = new AcademyTeacher(teacherCode, teacherName);
		teacher.setId(id);
		if(validate(request, response, teacher)) {
			try {
				academyTeacherDAO.update(teacher);
				response.sendRedirect(request.getContextPath() + "/home/teachers/list");
			} catch (Exception e) {
				request.setAttribute("academyTeacher", teacher);
				request.setAttribute("errors", e.getCause());
				request.getRequestDispatcher("/home/teachers/edit").forward(request, response);
			}
		}
	}

	private boolean validate(HttpServletRequest request, HttpServletResponse response, AcademyTeacher teacher)
			throws ServletException, IOException {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<AcademyTeacher>> constraintViolations = validator.validate(teacher);
		if (constraintViolations.isEmpty()) {
			return true;
		}
		
		String errors = "<ul style=\"display: inline-block; text-align: left;\">";
		for (ConstraintViolation<AcademyTeacher> constraintViolation : constraintViolations) {
			errors += "<li>" + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage()
					+ "</li>";
		}
		errors += "</ul>";
		
		request.setAttribute("academyTeacher", teacher);
		request.setAttribute("errors", errors);
		request.getRequestDispatcher("/home/teachers/edit").forward(request, response);
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
