package models;

import java.util.List;

import dataaccess.CourseDAO;

public class CourseModel {
	
	public static List<CourseModel> getModels() {
		System.out.println("Access DAO Object");
		System.out.println("Call getModels method");
		CourseDAO.getInstance().getModels();
		System.out.println("Return getted List<CourseModel>");
		
		return null;
	}
	
	public static Boolean deleteCourse(int courseID) {
		System.out.println("Access CourseDAO object");
		System.out.println("Call necessary method delete Method for CourseDAO");
		CourseDAO.getInstance().deleteCourse(5);
		return false;
	}
	
	public static Boolean editCourse(int courseID) {
		System.out.println("Access CourseDAO object");
		System.out.println("Call necessary method edit Method for CourseDAO");
		CourseDAO.getInstance().editCourse(5);
		return false;
	}
	
	public static List<CourseModel> getByYear(int year) {
		System.out.println("Access CourseDAO object and call getByYear method with given year");
		List<CourseModel> models = CourseDAO.getInstance().getByYear(year);
		System.out.println("Return Obtained Models");
		return models;
	}
	
	private int courseID;
	private String courseCode;
	private String courseTitle;
	private String courseInstructor;
	private boolean courseEnable;
	
	public CourseModel() {
		
	}
	
	public Boolean push() {
		
		System.out.println("UserDAO object accessed");
		System.out.println("User Model passed as parameter to push method of UserDAO");
		
		return CourseDAO.getInstance().push(this);
	}
	
	
	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseInstructor() {
		return courseInstructor;
	}

	public void setCourseInstructor(String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}

	public boolean isCourseEnable() {
		return courseEnable;
	}

	public void setCourseEnable(boolean courseEnable) {
		this.courseEnable = courseEnable;
	}
	
	

}
