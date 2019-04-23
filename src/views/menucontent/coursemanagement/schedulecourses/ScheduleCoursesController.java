package views.menucontent.coursemanagement.schedulecourses;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import views.menucontent.AbstractMenuContent;
import views.menucontent.coursemanagement.schedulecourses.popups.ScheduleCoursePopupBuilder;
import views.popup.InWindowPopupManager;


public class ScheduleCoursesController extends AbstractMenuContent {
	
	@FXML private VBox schedule;
	
	public ScheduleCoursesController() {
		super("ScheduleCourses.fxml");	
	}
	
	public ScheduleCoursesController setSchedule(Node sch) {
		schedule.getChildren().add(sch);
		return this;
	}
	
	public void schedule(ActionEvent event) {
		System.out.println("Shedule Clicked");
		
		InWindowPopupManager.getInstance()
								.setPopupTitle("Schedule Course")
								.load(new ScheduleCoursePopupBuilder().build())
								.show();
	}
	
	public void apply(ActionEvent event) {
		System.out.println("Apply Clicked");
	}
	
}
