package views.menucontent.coursemanagement.managecourse;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class ManageCourseController extends VBox {
	
	@FXML private VBox courseTable;
	
	public ManageCourseController() {
		loadFXML();
	}
	
	public ManageCourseController setCourseTable(Node table) {
		courseTable.getChildren().add(table);
		return this;
	}
	
	private void loadFXML() {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManageCourse.fxml"));
		 fxmlLoader.setRoot(this);
		 fxmlLoader.setController(this);

		 try {
			 	fxmlLoader.load();
		} catch (IOException exception) {
				throw new RuntimeException(exception);
		}
	}
}
