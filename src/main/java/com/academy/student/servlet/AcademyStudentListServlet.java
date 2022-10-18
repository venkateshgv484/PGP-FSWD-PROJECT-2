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
import com.academy.student.dto.AcademyStudent;

/**
 * Servlet implementation class AcademyStudentServlet
 */
@WebServlet("/home/students/list")
public class AcademyStudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AcademyClassDAO academyClassDAO;
	private AcademyStudentDAO academyStudentDAO;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcademyStudentListServlet() {
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
			case "/home/students/list":
				list(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AcademyStudent> academyStudentList = academyStudentDAO.listAllStudents();
		request.setAttribute("academyStudentList", academyStudentList);
		request.setAttribute("classMap", loadClasses());
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
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
