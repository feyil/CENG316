package dataaccess;

import java.util.ArrayList;
import java.util.List;

import models.CourseModel;

public class CourseDAO {
	
	// Singleton
	private static CourseDAO instance;
	
	public static CourseDAO getInstance() {
		if(instance == null) {
			instance = new CourseDAO();
		}
		return instance;
	}
	
	private CourseDAO() {
		
	}
	
	public Boolean push(CourseModel courseModel) {
		System.out.println("It checks ID if it exist edit if not create new one");
		System.out.println("Course model related field accessed");
		System.out.println("DB connection accessed");
		System.out.println("Related SQL commands runned");
		System.out.println("Success status returned as boolean");
		
		return false;
	}
	
	public List<CourseModel> getModels() {
		System.out.println("Make the needed SQL calls get all models");
		System.out.println("Wrap all models into a list and return it");
		
		return null;
	}
	
	public Boolean deleteCourse(int courseID) {
		System.out.println("Make the needed SQL call delete the course from db");
		System.out.println("Return result of the operation");
		return false;
	}
	
	public Boolean editCourse(int courseID) {
		System.out.println("Make the needed SQL call edit the course from db");
		System.out.println("Return result of the operation");
		return false;
	}
	
	public List<CourseModel> getByYear(int year) {
		List<CourseModel> models = new ArrayList<CourseModel>();
		System.out.println("With given year make necessarily SQL query and return as List<CourseModel>");
		CourseModel model = new CourseModel();
		
		//TODO It is static only to show concept
		if(year == 1) {
			model.setCourseID(1);
			model.setCourseCode("CENG111");
			model.setCourseTitle("Intro to CENG");
		}
		else if(year == 2) {
			model.setCourseID(1);
			model.setCourseCode("CENG222");
			model.setCourseTitle("Fundamentals of Programming");
		}
		models.add(model);
		return models;
	}
	
	public CourseModel getByCourseCode(String courseCode) {
		System.out.println("With given Course Code make neccssariyl Sql query and return a CourseModel");
		CourseModel model = new CourseModel();
		model.setPosition("f1");

		return model;
	}

}
