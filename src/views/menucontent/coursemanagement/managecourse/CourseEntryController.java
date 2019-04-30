package views.menucontent.coursemanagement.managecourse;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import models.CourseModel;
import views.menucontent.coursemanagement.managecourse.popups.CoursePopupBuilder;
import views.popup.InWindowPopupManager;

public class CourseEntryController extends HBox {
	
	@FXML private Label courseCode;
	@FXML private Label courseTitle;
	@FXML private Label courseInstructor;
	
	private int courseID;
	
	public CourseEntryController() {
		loadFXML();
	}


	public CourseEntryController setCourseCode(String cCode) {
		courseCode.setText(cCode);
		return this;
	}


	public CourseEntryController setCourseTitle(String cTitle) {
		courseTitle.setText(cTitle);
		return this;
	}


	public CourseEntryController setCourseInstructor(String cInstructor) {
		courseInstructor.setText(cInstructor);
		return this;
	}


	public int getCourseID() {
		return courseID;
	}


	public CourseEntryController setCourseID(int courseID) {
		this.courseID = courseID;
		return this;
	}
	
	public void deleteCourse(ActionEvent e) {
		System.out.println("Delete course button clicked");
		
		System.out.println("call CourseModel static delete method with given courseID");
		CourseModel.deleteCourse(5);
	
		
		System.out.println("Disable the entry clicked");
		setDisabled(true);
		
		
	}
	
	public void editCourse(ActionEvent e) {
		System.out.println("Edit course button clicked");
		
		InWindowPopupManager.getInstance()
							.setPopupTitle("Edit Course")
							.load(new CoursePopupBuilder().build())
							.show();
		
		System.out.println("call CourseModel static edit method with given courseID");
		CourseModel.editCourse(5);

		System.out.println("Course Model Template Created");
		
		System.out.println("CM course code set");
		System.out.println("CM course title set");
		System.out.println("CM prerequisite set");
		System.out.println("CM course summary set");
		System.out.println("CM course topics set");
		System.out.println("CM instructor set");
		System.out.println("CM assistant set");
		System.out.println("CourseModel ready to go");

		
	}
	
	
	private void loadFXML() {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CourseEntry.fxml"));
		 fxmlLoader.setRoot(this);
		 fxmlLoader.setController(this);

		 try {
			 	fxmlLoader.load();
		} catch (IOException exception) {
				throw new RuntimeException(exception);
		}
	}
	

}
