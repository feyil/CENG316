package dataaccess;

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

}
