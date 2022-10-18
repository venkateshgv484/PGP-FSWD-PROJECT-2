package com.academy.utils;

import java.util.List;

import com.academy.classes.dao.AcademyClassDAO;
import com.academy.classes.dto.AcademyClass;
import com.academy.classsubjectteacher.dao.AcademyClassSubjectTeacherDAO;
import com.academy.classsubjectteacher.dto.AcademyClassSubjectTeacher;
import com.academy.student.dao.AcademyStudentDAO;
import com.academy.student.dto.AcademyStudent;
import com.academy.subject.dao.AcademySubjectDAO;
import com.academy.subject.dto.AcademySubject;
import com.academy.teacher.dao.AcademyTeacherDAO;
import com.academy.teacher.dto.AcademyTeacher;

public class DataUtils {

	private static boolean isDataLoaded = false;
	
	public static void loadSampleData() {
		
		if(isDataLoaded) {
			return;
		}
		
		isDataLoaded = true;
		
		AcademySubjectDAO academySubjectDAO = new AcademySubjectDAO();
		AcademyTeacherDAO academyTeacherDAO = new AcademyTeacherDAO();
		AcademyClassDAO academyClassDAO = new AcademyClassDAO();
		AcademyClassSubjectTeacherDAO academyClassSubjectTeacherDAO = new AcademyClassSubjectTeacherDAO();
		AcademyStudentDAO academyStudentDAO = new AcademyStudentDAO();

		academySubjectDAO.insert(new AcademySubject("COURSE 0", "Orientation Session for Caltech PGP Full Stack Web Development Program"));
		academySubjectDAO.insert(new AcademySubject("COURSE 1", "PG FSD Implement OOPS using JAVA with Data Structures and Beyond"));
		academySubjectDAO.insert(new AcademySubject("COURSE 2", "PG FSD Become a back-end expert"));
		academySubjectDAO.insert(new AcademySubject("COURSE 3", "PG FSD Implement Frameworks the DevOps way"));
		academySubjectDAO.insert(new AcademySubject("COURSE 4", "PG FSD Develop a Web Application using frontend stack"));
		academySubjectDAO.insert(new AcademySubject("PROJECT", "PG FSD - Full Stack Web Development Capstone Project"));
		academySubjectDAO.insert(new AcademySubject("ELECTIVE 1", "Caltech CTME Full Stack Development Master Class"));
		academySubjectDAO.insert(new AcademySubject("ELECTIVE 2", "PG FSD Testing in a DevOps Lifecycle"));

		academyTeacherDAO.insert(new AcademyTeacher("VM", "Vinod Mahendra"));

		academyClassDAO.insert(new AcademyClass("PGP FSD JUL 2022 Cohort 1", "Post Graduate Program in Full Stack Web Development-234"));

		List<AcademyTeacher> teachers = academyTeacherDAO.listAllTeachers();
		List<AcademySubject> subjects = academySubjectDAO.listAllSubjects();
		List<AcademyClass> classes = academyClassDAO.listAllClasses();

		for (AcademySubject academySubject : subjects) {
			academyClassSubjectTeacherDAO.insert(new AcademyClassSubjectTeacher(classes.get(0).getId(),
					academySubject.getId(), teachers.get(0).getId()));
		}

		academyStudentDAO.insert(new AcademyStudent("S484", "GV Venkatesh", "venkatesh.gv484@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S001", "Deirdre Ince", "deirdre.ince@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S002", "Anne Morgan", "anne.morgan@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S003", "Gavin Harris", "gavin.harris@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S004", "Julian Johnston", "julian.johnston@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S005", "Jasmine Mackenzie", "jasmine.mackenzie@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S006", "Molly Black", "molly.black@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S007", "Cameron McLean", "cameron.mclean@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S008", "Edward Edmunds", "edward.edmunds@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S009", "Carolyn Davidson", "carolyn.davidson@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S010", "Joseph Walker", "joseph.walker@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S011", "Simon Lee", "simon.lee@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S012", "Evan Welch", "evan.welch@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S013", "Grace Henderson", "grace.henderson@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S014", "Cameron Rutherford", "cameron.rutherford@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S015", "Anthony Walker", "anthony.walker@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S016", "Anna Bond", "anna.bond@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S017", "Amelia Dowd", "amelia.dowd@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S018", "Frank Miller", "frank.miller@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S019", "Justin Hunter", "justin.hunter@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S020", "Wanda Carr", "wanda.carr@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S021", "Bella Parsons", "bella.parsons@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S022", "Brandon Berry", "brandon.berry@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S023", "Molly Lambert", "molly.lambert@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S024", "Hannah Wallace", "hannah.wallace@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S025", "Jessica Berry", "jessica.berry@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S026", "Irene Ross", "irene.ross@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S027", "Austin Parr", "austin.parr@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S028", "Liam Black", "liam.black@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S029", "Una Welch", "una.welch@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S030", "Jennifer Buckland", "jennifer.buckland@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S031", "Faith May", "faith.may@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S032", "Dorothy Morrison", "dorothy.morrison@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S033", "Vanessa Kerr", "vanessa.kerr@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S034", "Thomas Newman", "thomas.newman@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S035", "David Terry", "david.terry@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S036", "Maria Cameron", "maria.cameron@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S037", "Emily Lawrence", "emily.lawrence@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S038", "Adam Robertson", "adam.robertson@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S039", "Christian Gray", "christian.gray@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S040", "Peter Underwood", "peter.underwood@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S041", "Audrey Mills", "audrey.mills@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S042", "Stephanie Nolan", "stephanie.nolan@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S043", "Leah Bailey", "leah.bailey@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S044", "Boris Lambert", "boris.lambert@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S045", "Adam Sharp", "adam.sharp@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S046", "Dominic Bower", "dominic.bower@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S047", "Sebastian Alsop", "sebastian.alsop@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S048", "Gavin Davies", "gavin.davies@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S049", "Justin Smith", "justin.smith@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S050", "Leah Cornish", "leah.cornish@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S051", "Lucas Buckland", "lucas.buckland@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S052", "Emma Lawrence", "emma.lawrence@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S053", "Carolyn Knox", "carolyn.knox@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S054", "Ryan Peake", "ryan.peake@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S055", "Sonia Peake", "sonia.peake@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S056", "Jennifer Rutherford", "jennifer.rutherford@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S057", "Zoe Carr", "zoe.carr@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S058", "Claire Baker", "claire.baker@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S059", "Lucas MacDonald", "lucas.macdonald@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S060", "Deirdre Hart", "deirdre.hart@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S061", "Amy Cameron", "amy.cameron@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S062", "Peter Hudson", "peter.hudson@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S063", "Yvonne McDonald", "yvonne.mcdonald@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S064", "Yvonne Morgan", "yvonne.morgan@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S065", "Vanessa Lambert", "vanessa.lambert@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S066", "Diane Underwood", "diane.underwood@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S067", "Wendy Mills", "wendy.mills@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S068", "Adam Mackay", "adam.mackay@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S069", "Evan Knox", "evan.knox@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S070", "Evan McLean", "evan.mclean@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S071", "Andrew Mackenzie", "andrew.mackenzie@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S072", "Peter Mackay", "peter.mackay@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S073", "Cameron Howard", "cameron.howard@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S074", "Abigail Short", "abigail.short@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S075", "Neil Duncan", "neil.duncan@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S076", "Katherine Clarkson", "katherine.clarkson@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S077", "Olivia Hart", "olivia.hart@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S078", "Edward Simpson", "edward.simpson@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S079", "Colin Paige", "colin.paige@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S080", "Blake Taylor", "blake.taylor@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S081", "Connor Manning", "connor.manning@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S082", "Brandon Randall", "brandon.randall@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S083", "Samantha Hodges", "samantha.hodges@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S084", "Kylie Allan", "kylie.allan@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S085", "Hannah Hart", "hannah.hart@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S086", "Sonia Grant", "sonia.grant@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S087", "Carol Hunter", "carol.hunter@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S088", "Brian Manning", "brian.manning@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S089", "Amanda Sharp", "amanda.sharp@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S090", "Liam Wilkins", "liam.wilkins@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S091", "Michelle Berry", "michelle.berry@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S092", "Bella Skinner", "bella.skinner@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S093", "Lillian Walker", "lillian.walker@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S094", "Amelia Duncan", "amelia.duncan@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S095", "Edward Nash", "edward.nash@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S096", "Lauren Bond", "lauren.bond@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S097", "Tracey Ross", "tracey.ross@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S098", "Ruth Campbell", "ruth.campbell@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S099", "Dan McDonald", "dan.mcdonald@gmail.com", classes.get(0).getId()));
		academyStudentDAO.insert(new AcademyStudent("S100", "Andrew Marshall", "andrew.marshall@gmail.com", classes.get(0).getId()));
		
	}

}
