package views.menucontent.coursemanagement.managecourse;


import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import views.menucontent.AbstractMenuContent;

public class ManageCourseController extends AbstractMenuContent {
	
	@FXML private VBox courseTable;
	
	public ManageCourseController() {
		super("ManageCourse.fxml");
	}
	
	public ManageCourseController setCourseTable(Node table) {
		courseTable.getChildren().add(table);
		return this;
	}
	
}
