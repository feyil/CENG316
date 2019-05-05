package views.menucontent.coursemanagement.schedulecourses.popups;

import java.util.List;

import models.CourseModel;

public class ScheduleCoursePopupBuilder {
	
	private ScheduleCoursePopupController instance;
	private String courseCode;
	
	public ScheduleCoursePopupBuilder() {
		instance = new ScheduleCoursePopupController();
	}
	
	public ScheduleCoursePopupBuilder setSelectedCourseCode(String courseCode) {
		this.courseCode = courseCode;
		return this;
	}
	
	public ScheduleCoursePopupController build() {
		System.out.println("Call CourseModel static getByCourseCode method");
		CourseModel model = CourseModel.getByCourseCode(courseCode);
		System.out.println("Call ScheduleCoursePopupController setCourseModel method");
		instance.setCourseModel(model);
		
		return instance;
	}

}
