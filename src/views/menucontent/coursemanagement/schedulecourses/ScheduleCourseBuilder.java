package views.menucontent.coursemanagement.schedulecourses;

public class ScheduleCourseBuilder {

	public ScheduleCourseBuilder() {
		
	}
	
	public ScheduleCoursesController build() {
		
		ScheduleCoursesController a = new ScheduleCoursesController();
		ScheduleController schedule = new ScheduleController();
		a.setSchedule(schedule);
		
		return a;
	}
}
