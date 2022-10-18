package com.academy.report.servlet;

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
import com.academy.classsubjectteacher.dao.AcademyClassSubjectTeacherDAO;
import com.academy.student.dao.AcademyStudentDAO;
import com.academy.subject.dao.AcademySubjectDAO;
import com.academy.subject.dto.AcademySubject;
import com.academy.teacher.dao.AcademyTeacherDAO;
import com.academy.teacher.dto.AcademyTeacher;

/**
 * Servlet implementation class AcademySubjectServlet
 */
@WebServlet("/home/report")
public class ClassReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AcademyClassDAO academyClassDAO;
	private AcademySubjectDAO academySubjectDAO;
	private AcademyTeacherDAO academyTeacherDAO;
	private AcademyClassSubjectTeacherDAO academyClassSubjectTeacherDAO;
	private AcademyStudentDAO academyStudentDAO;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClassReportServlet() {
		super();
		academyClassDAO = new AcademyClassDAO();
		academySubjectDAO = new AcademySubjectDAO();
		academyTeacherDAO = new AcademyTeacherDAO();
		academyClassSubjectTeacherDAO = new AcademyClassSubjectTeacherDAO();
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
			case "/home/report":
				report(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}
	}

	private void report(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long classId = Long.parseLong(request.getParameter("classId"));
		
		if(classId > Long.MIN_VALUE) {
			request.setAttribute("academyClass", academyClassDAO.getClass(classId));
			request.setAttribute("classSubjectTeachers", academyClassSubjectTeacherDAO.listAllClassSubjectTeachers(classId));
			request.setAttribute("classStudents", academyStudentDAO.listAllClassStudents(classId));
			request.setAttribute("subjectMap", loadSubjects());
			request.setAttribute("teacherMap", loadTeachers());
			RequestDispatcher dispatcher = request.getRequestDispatcher("report.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("errors", "Please select the class to generate the report");
			request.getRequestDispatcher("/home").forward(request, response);
			// response.sendRedirect(request.getContextPath() + "/home");
		}
		
	}

	private Object loadSubjects() {
		Map<Long, String> subjectData = new LinkedHashMap<>();
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
