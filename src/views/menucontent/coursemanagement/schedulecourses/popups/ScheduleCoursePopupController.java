package views.menucontent.coursemanagement.schedulecourses.popups;

import javafx.event.ActionEvent;
import views.popup.AbstractPopup;

public class ScheduleCoursePopupController extends AbstractPopup {
	
	public ScheduleCoursePopupController() {
		super("ScheduleCourse.fxml");
	}

	public void apply(ActionEvent event) {
		System.out.println("Apply Clicked");
	}
}
