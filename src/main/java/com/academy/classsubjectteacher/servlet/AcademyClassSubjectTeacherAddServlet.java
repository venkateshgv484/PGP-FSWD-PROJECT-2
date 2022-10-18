package com.academy.classsubjectteacher.servlet;

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
import com.academy.subject.dao.AcademySubjectDAO;
import com.academy.subject.dto.AcademySubject;
import com.academy.teacher.dao.AcademyTeacherDAO;
import com.academy.teacher.dto.AcademyTeacher;

/**
 * Servlet implementation class AcademySubjectServlet
 */
@WebServlet("/home/classes/assignment/new")
public class AcademyClassSubjectTeacherAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AcademyClassDAO academyClassDAO;
	private AcademySubjectDAO academySubjectDAO;
	private AcademyTeacherDAO academyTeacherDAO;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AcademyClassSubjectTeacherAddServlet() {
		super();
		academyClassDAO = new AcademyClassDAO();
		academySubjectDAO = new AcademySubjectDAO();
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
			case "/home/classes/assignment/new":
				showNewForm(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long classId = Long.parseLong(request.getParameter("classId"));
		request.setAttribute("academyClass", academyClassDAO.getClass(classId));
		request.setAttribute("subjectMap", loadSubjects());
		request.setAttribute("teacherMap", loadTeachers());
		request.setAttribute("isNew", true);
		RequestDispatcher dispatcher = request.getRequestDispatcher("class-assignment-form.jsp");
		dispatcher.forward(request, response);
	}

	private Object loadSubjects() {
		Map<Long, String> subjectData = new LinkedHashMap<>();
		subjectData.put(Long.MIN_VALUE, "Select");
		List<AcademySubject> subjectList = academySubjectDAO.listAllSubjects();
		for (AcademySubject academySubject : subjectList) {
			subjectData.put(academySubject.getId(), academySubject.getSubjectName());
		}
		return subjectData;
	}

	private Object loadTeachers() {
		Map<Long, String> teacherData = new LinkedHashMap<>();
		teacherData.put(Long.MIN_VALUE, "Select");
		List<AcademyTeacher> teacherList = academyTeacherDAO.listAllTeachers();
		for (AcademyTeacher academyTeacher : teacherList) {
			teacherData.put(academyTeacher.getId(), academyTeacher.getTeacherName());
		}
		return teacherData;
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
