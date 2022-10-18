package com.academy.student.servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.academy.classes.dao.AcademyClassDAO;
import com.academy.classes.dto.AcademyClass;
import com.academy.student.dao.AcademyStudentDAO;

/**
 * Servlet implementation class AcademyStudentServlet
 */
@WebServlet("/home/students/edit")
public class AcademyStudenEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AcademyClassDAO academyClassDAO;
	private AcademyStudentDAO academyStudentDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcademyStudenEditServlet() {
		super();
		academyClassDAO = new AcademyClassDAO();
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
			case "/home/students/edit":
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
		if(request.getAttribute("academyStudent") == null) {
			request.setAttribute("academyStudent", academyStudentDAO.getStudent(id));
		}
		request.setAttribute("classMap", loadClasses());
		request.setAttribute("isNew", false);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
		dispatcher.forward(request, response);
	}

	private Object loadClasses() {
		Map<Long, String> classData = new LinkedHashMap<>();
		classData.put(Long.MIN_VALUE, "Select");
		List<AcademyClass> classList = academyClassDAO.listAllClasses();
		for (AcademyClass academyClass : classList) {
			classData.put(academyClass.getId(), academyClass.getClassName());
		}
		return classData;
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
