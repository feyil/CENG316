package views.menucontent.coursemanagement.schedulecourses;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import models.CourseModel;
import views.menucontent.AbstractMenuContent;
import views.menucontent.coursemanagement.schedulecourses.popups.ScheduleCoursePopupBuilder;
import views.popup.InWindowPopupManager;


public class ScheduleCoursesController extends AbstractMenuContent {
	
	@FXML private VBox schedule;
	@FXML private ComboBox<Integer> yearComboBox;
	@FXML private ComboBox<String> courseComboBox;
	
	public ScheduleCoursesController() {
		super("ScheduleCourses.fxml");
		
		setYearOption();
	}
	
	public ScheduleCoursesController setSchedule(Node sch) {
		schedule.getChildren().add(sch);
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
	
	public ScheduleCoursesController setYearOption() {
		yearComboBox.getItems().addAll(1, 2, 3, 4);
		return this;
	}
	
	public void yearOptionChanged(ActionEvent event) {
		System.out.println("Update Possible Courses");
		
		System.out.println("Call CourseModel static getByYear method to obtain possible courses");
		List<CourseModel> models = CourseModel.getByYear(yearComboBox.getValue());
		
		System.out.println("Clear the ComboBox");
		courseComboBox.getItems().clear();
		
		System.out.println("For obtained models add course option to the ComboBox");
		for(int i = 0; i < models.size(); i++) {
			courseComboBox.getItems().add(models.get(i).getCourseCode());
		}
		
	}
	
}
