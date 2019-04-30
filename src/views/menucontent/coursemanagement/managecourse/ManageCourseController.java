package views.menucontent.coursemanagement.managecourse;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import views.menucontent.AbstractMenuContent;
import views.menucontent.coursemanagement.managecourse.popups.CoursePopupBuilder;
import views.popup.InWindowPopupManager;

public class ManageCourseController extends AbstractMenuContent {
	
	@FXML private VBox courseTable;
	
	public ManageCourseController() {
		super("ManageCourse.fxml");
	}
	
	public ManageCourseController setCourseTable(Node table) {
		courseTable.getChildren().add(table);
		return this;
	}
	
	public void addCourse(ActionEvent event) {
		System.out.println("Add Course");
		
		InWindowPopupManager.getInstance()
								.setPopupTitle("Add New Course")
								.load(new CoursePopupBuilder().build())
								.show();
	}
	
	
	
}
