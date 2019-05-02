package views.menucontent.coursemanagement.schedulecourses;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import models.CourseModel;
import views.menucontent.AbstractMenuContent;
import views.menucontent.coursemanagement.schedulecourses.popups.ScheduleCoursePopupBuilder;
import views.popup.InWindowPopupManager;


public class ScheduleCoursesController extends AbstractMenuContent {
	
	@FXML private VBox schedule;
	@FXML private ComboBox<Integer> yearComboBox;
	@FXML private ComboBox<String> courseComboBox;
	
	private ScheduleController scheduleTable;

	public ScheduleCoursesController() {
		super("ScheduleCourses.fxml");
		
		setYearOption();
	}
	
	public ScheduleCoursesController setSchedule(ScheduleController sch) {
		schedule.getChildren().clear();
		schedule.getChildren().add(sch);
		scheduleTable = sch;
		return this;
	}
	
	public void schedule(ActionEvent event) {
		System.out.println("Schedule Clicked");
		
		InWindowPopupManager.getInstance()
								.setPopupTitle("Schedule Course")
								.load(new ScheduleCoursePopupBuilder().build())
								.show();
	}
	
	public void apply(ActionEvent event) {
		System.out.println("Apply Clicked");
	}
	
	private ScheduleCoursesController setYearOption() {
		yearComboBox.getItems().addAll(1, 2, 3, 4);
		return this;
	}
	
	public void yearOptionChanged(ActionEvent event) {
		int yearOption = yearComboBox.getValue();
		
		System.out.println("Update Course Option Called");
		updateCourseOptions(yearOption);

		System.out.println("Update Schedule Called");
		updateSchedule(yearOption);	
	}
	
	private ScheduleCoursesController updateCourseOptions(int courseYear) {
		System.out.println("Update Possible Courses");
		
		System.out.println("Call CourseModel static getByYear method to obtain possible courses");
		List<CourseModel> models = CourseModel.getByYear(courseYear);
		
		System.out.println("Clear the ComboBox");
		courseComboBox.getItems().clear();
		
		System.out.println("For obtained models add course option to the ComboBox");
		for(int i = 0; i < models.size(); i++) {
			courseComboBox.getItems().add(models.get(i).getCourseCode());
		}
		
		return this;
	}
	
	private ScheduleCoursesController updateSchedule(int scheduleYear) {
		System.out.println("Update Schedule Table");
		
		System.out.println("Call CourseModel static getByYear method to obtain possible courses");
		List<CourseModel> models = CourseModel.getByYear(scheduleYear);
		
		System.out.println("Set Brand New Schedule");
		setSchedule(new ScheduleController());
		
		System.out.println("Loop models positions and put them to correct position");
		List<Label> monday = scheduleTable.getScheduleOf(ScheduleDay.MONDAY);
		
		for(int i = 0; i < models.size(); i++) {
			String position = models.get(i).getPosition();
			monday.get(0).setText(models.get(i).getCourseCode());
		}
		
		return this;
	}
}
