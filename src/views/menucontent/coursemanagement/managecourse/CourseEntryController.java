package views.menucontent.coursemanagement.managecourse;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import models.CourseModel;

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
