package views.menucontent.coursemanagement.managecourse.popups;

import javafx.event.ActionEvent;
import models.CourseModel;
import views.popup.AbstractPopup;

public class CoursePopupController extends AbstractPopup {
	
	public CoursePopupController() {
		super("Course.fxml");
	}
	
	public void applyEdit(ActionEvent e) {
		
		System.out.println("Apply Clicked");
		CourseModel courseModel = new CourseModel();
		System.out.println("Course Model Template Created");
		
		System.out.println("CM course code updated");
		System.out.println("CM course title updated");
		System.out.println("CM prerequisite updated");
		System.out.println("CM course summary updated");
		System.out.println("CM course topics updated");
		System.out.println("CM instructor updated");
		System.out.println("CM assistant updated");
		
		courseModel.push();
		System.out.println("CourseModel pushed to the DB");
		System.out.println("DB declare success or failure check it");
		
		System.out.println("Course updated successfully");
	}
}
