package views.menucontent.coursemanagement.schedulecourses;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import views.menucontent.AbstractMenuContent;


public class ScheduleCoursesController extends AbstractMenuContent {
	
	@FXML private VBox schedule;
	
	public ScheduleCoursesController() {
		super("ScheduleCourses.fxml");	
	}
	
	public ScheduleCoursesController setSchedule(Node sch) {
		schedule.getChildren().add(sch);
		return this;
	}
	
}
