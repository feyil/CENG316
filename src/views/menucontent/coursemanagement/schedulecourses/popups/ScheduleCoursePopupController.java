package views.menucontent.coursemanagement.schedulecourses.popups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import models.CourseModel;
import views.popup.AbstractPopup;
import views.popup.InWindowPopupManager;

public class ScheduleCoursePopupController extends AbstractPopup {
	
	// For Monday
	@FXML private CheckBox m1;
	@FXML private CheckBox m2;
	@FXML private CheckBox m3;
	@FXML private CheckBox m4;
	@FXML private CheckBox m5;
	@FXML private CheckBox m6;
	@FXML private CheckBox m7;
	@FXML private CheckBox m8;
	
	private List<CheckBox> monday; 
	
	// For Tuesday
	@FXML private CheckBox tu1;
	@FXML private CheckBox tu2;
	@FXML private CheckBox tu3;
	@FXML private CheckBox tu4;
	@FXML private CheckBox tu5;
	@FXML private CheckBox tu6;
	@FXML private CheckBox tu7;
	@FXML private CheckBox tu8;
	
	private List<CheckBox> tuesday;
	
	// For Friday
	@FXML private CheckBox f1;
	@FXML private CheckBox f2;
	@FXML private CheckBox f3;
	@FXML private CheckBox f4;
	@FXML private CheckBox f5;
	@FXML private CheckBox f6;
	@FXML private CheckBox f7;
	@FXML private CheckBox f8;
	
	private List<CheckBox> friday;
	
	private CourseModel course;
	
	public ScheduleCoursePopupController() {
		super("ScheduleCourse.fxml");
		monday = new ArrayList<CheckBox>(Arrays.asList(m1, m2, m3, m4, m5, m6, m7, m8));
		tuesday = new ArrayList<CheckBox>(Arrays.asList(tu1, tu2, tu3, tu4, tu5, tu6, tu7, tu8));
		friday = new ArrayList<CheckBox>(Arrays.asList(f1, f2, f3, f4, f5, f6, f7, f8));
	}

	public void apply(ActionEvent event) {
		System.out.println("Apply Clicked from ScheduleCoursePopup");
		System.out.println("Read all the checkbox status");
		System.out.println("Call CourseModel push method");
		course.push();
		System.out.println("DB Package now how to edit a course and return status");
		
		System.out.println("Close the popup");
		InWindowPopupManager.getInstance().close();
	}
	
	public void setCourseModel(CourseModel model) {
		this.course = model;
		System.out.println("With given model call fillTable method");
		fillTable(model);
	}
	
	private void fillTable(CourseModel model) {
		System.out.println("Fill the table with given model position attribute");
		if(model.getPosition().equals("f1")) {
			f1.setSelected(true);
		}
	}
}
